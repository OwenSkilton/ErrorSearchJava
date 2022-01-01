package error_search_engine.errorsearchspring.Controller;

import error_search_engine.errorsearchspring.entities.Favourites;
import error_search_engine.errorsearchspring.entities.Posts;
import error_search_engine.errorsearchspring.entities.Users;
import error_search_engine.errorsearchspring.repos.FavouritesRepository;
import error_search_engine.errorsearchspring.repos.PostsRepository;
import error_search_engine.errorsearchspring.repos.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(path = "/backend", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {

    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;
    private final FavouritesRepository favouritesRepository;


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
}
