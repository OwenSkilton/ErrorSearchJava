package error_search_engine.errorsearchspring.Controller;

import error_search_engine.errorsearchspring.entities.*;
import error_search_engine.errorsearchspring.repos.FavouritesRepository;
import error_search_engine.errorsearchspring.repos.PostsRepository;
import error_search_engine.errorsearchspring.repos.SearchHistoryRepository;
import error_search_engine.errorsearchspring.repos.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(path = "/backend", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {

    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;
    private final FavouritesRepository favouritesRepository;
    private final SearchHistoryRepository searchHistoryRepository;

    // ------------------ FAVOURITES ------------------

    @PostMapping(path = "/postfavourite/{userEmail}/{question_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Favourites postFavourite(@PathVariable String userEmail, @PathVariable int question_id) throws IOException {
        Users user = createUser(userEmail);
        Posts post = createPost(question_id);
        return createFavourite(user, post);
    }

    @GetMapping(path = "/findfavourite/{userEmail}/{question_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Favourites findFavourite(@PathVariable String userEmail, @PathVariable int question_id) throws IOException {
        Users user = findUser(userEmail);
        Posts post = findPost(question_id);
        return favouritesRepository.findByUseridAndPostid(user, post);
    }

    @GetMapping(path = "finduserfavourites/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Favourites> findUserFavourites(@PathVariable String userEmail){
        Users user = findUser(userEmail);
        return favouritesRepository.findByUserid(user);
    }

    @Transactional
    @DeleteMapping(path = "/deletefavourite/{userEmail}/{question_id}")
    public void deleteFavourite(@PathVariable String userEmail, @PathVariable int question_id) throws IOException {
        Users user = createUser(userEmail);
        Posts post = createPost(question_id);
        favouritesRepository.deleteByUseridAndPostid(user, post);
    }

    // ------------------ SEARCH HISTORY ------------------

    @GetMapping(path = "/findusersearchhistory/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SearchHistory> findSearchHistory(@PathVariable String userEmail) throws IOException {
        return searchHistoryRepository.findByUserid(findUser(userEmail));
    }

    @PostMapping(path = "/postsearchhistory/{userEmail}/{keywords}/{searchParameter}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SearchHistory postSearchHistory(@PathVariable String userEmail, @PathVariable String keywords, @PathVariable SearchParameter searchParameter) throws IOException {
        Users user = createUser(userEmail);
        return createSearchHistory(user, keywords, searchParameter);
    }

    @PostMapping(path = "/postsearchhistory/{userEmail}/{keywords}/{language}/{searchParameter}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SearchHistory postSearchHistory(@PathVariable String userEmail, @PathVariable String keywords, @PathVariable String language, @PathVariable SearchParameter searchParameter) throws IOException {
        Users user = createUser(userEmail);
        return createSearchHistory(user, keywords, language, searchParameter);
    }

    @PostMapping(path = "/postsearchhistory/{userEmail}/{keywords}/{language}/{framework}/{searchParameter}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SearchHistory postSearchHistory(@PathVariable String userEmail, @PathVariable String keywords, @PathVariable String language, @PathVariable String framework, @PathVariable SearchParameter searchParameter) throws IOException {
        Users user = createUser(userEmail);
        return createSearchHistory(user, keywords, language, framework, searchParameter);
    }


    // ------------------ HELPERS ------------------

    public Users createUser(String userEmail){
        Users user = new Users(userEmail);
        return usersRepository.save(user);
    }
    public Users findUser(String userEmail){
        return usersRepository.findByEmail(userEmail);
    }

    public Posts createPost(int question_id){
        Posts post = new Posts((long) question_id);
        return postsRepository.save(post);
    }
    public Posts findPost(int question_id){
        return postsRepository.findByPostid((long) question_id);
    }

    public Favourites createFavourite(Users user, Posts post){
        Favourites favourite = new Favourites(user, post);
        return favouritesRepository.save(favourite);
    }

    public SearchHistory createSearchHistory(Users user, String keywords, SearchParameter searchParameter){
        SearchHistory newSearchHistory = new SearchHistory(keywords, user, searchParameter);
        return searchHistoryRepository.save(newSearchHistory);
    }
    public SearchHistory createSearchHistory(Users user, String keywords, String language, SearchParameter searchParameter){
        SearchHistory newSearchHistory = new SearchHistory(keywords, language, user, searchParameter);
        return searchHistoryRepository.save(newSearchHistory);
    }
    public SearchHistory createSearchHistory(Users user, String keywords, String language, String framework, SearchParameter searchParameter){
        SearchHistory newSearchHistory = new SearchHistory(keywords, language, framework, user, searchParameter);
        return searchHistoryRepository.save(newSearchHistory);
    }
}
