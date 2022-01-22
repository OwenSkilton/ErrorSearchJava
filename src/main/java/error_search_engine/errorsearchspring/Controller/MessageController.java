package error_search_engine.errorsearchspring.Controller;

import error_search_engine.errorsearchspring.entities.*;
import error_search_engine.errorsearchspring.repos.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(path = "/backend", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {

    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;
    private final DocumentationRepository documentationRepository;
    private final CrawlerItemRepository crawlerItemRepository;
    private final ForumFavouritesRepository forumFavouritesRepository;
    private final DocumentationFavouritesRepository documentationFavouritesRepository;
    private final CrawlerFavouritesRepository crawlerFavouritesRepository;
    private final SearchHistoryRepository searchHistoryRepository;

    // ------------------ FORUM FAVOURITES ------------------

    @PostMapping(path = "/postforumfavourite/{userEmail}/{question_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ForumFavourites postForumFavourite(@PathVariable String userEmail, @PathVariable int question_id) throws IOException {
        Users user = createUser(userEmail);
        Posts post = createPost(question_id);
        return createForumFavourite(user, post);
    }

    @GetMapping(path = "/findforumfavourite/{userEmail}/{question_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ForumFavourites findForumFavourite(@PathVariable String userEmail, @PathVariable int question_id) throws IOException {
        Users user = findUser(userEmail);
        Posts post = findPost(question_id);
        return forumFavouritesRepository.findByUseridAndPostid(user, post);
    }

    @GetMapping(path = "finduserforumfavourites/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ForumFavourites> findUserForumFavourites(@PathVariable String userEmail){
        Users user = findUser(userEmail);
        return forumFavouritesRepository.findByUserid(user);
    }

    @Transactional
    @DeleteMapping(path = "/deleteforumfavourite/{userEmail}/{question_id}")
    public void deleteForumFavourite(@PathVariable String userEmail, @PathVariable int question_id) throws IOException {
        Users user = createUser(userEmail);
        Posts post = createPost(question_id);
        forumFavouritesRepository.deleteByUseridAndPostid(user, post);
    }

    // ------------------ DOCUMENTATION FAVOURITES ------------------

    @PostMapping(path = "/postdocumentationfavourite/{userEmail}/{documentation_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DocumentationFavourites postDocumentationFavourite(@PathVariable String userEmail, @PathVariable String documentation_id, @RequestBody String link) throws IOException {
        link = link.substring(1, link.length()-1);
        Users user = createUser(userEmail);
        Documentation documentation = createDocumentation(documentation_id, link);
        return createDocumentationFavourite(user, documentation);
    }

    @GetMapping(path = "/finddocumentationfavourite/{userEmail}/{documentation_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DocumentationFavourites findDocumentationFavourite(@PathVariable String userEmail, @PathVariable String documentation_id) throws IOException {
        Users user = findUser(userEmail);
        Documentation documentation = findDocumentation(documentation_id);
        return documentationFavouritesRepository.findByUseridAndDocumentationid(user, documentation);
    }

    @GetMapping(path = "finduserdocumentationfavourites/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DocumentationFavourites> findUserDocumentationFavourites(@PathVariable String userEmail){
        Users user = findUser(userEmail);
        return documentationFavouritesRepository.findByUserid(user);
    }

    @Transactional
    @DeleteMapping(path = "/deletedocumentationfavourite/{userEmail}/{documentation_id}")
    public void deleteDocumentationFavourite(@PathVariable String userEmail, @PathVariable String documentation_id, @RequestBody String link) throws IOException {
        Users user = createUser(userEmail);
        Documentation documentation = createDocumentation(documentation_id, link);
        documentationFavouritesRepository.deleteByUseridAndDocumentationid(user, documentation);
    }

    // ------------------ CRAWLER FAVOURITES ------------------

    @PostMapping(path = "/postcrawleritemfavourite/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CrawlerFavourites postCrawlerItemFavourite(@PathVariable String userEmail, @RequestBody String link) throws IOException {
        link = link.substring(1, link.length()-1);
        Users user = createUser(userEmail);
        CrawlerItem crawlerItem = createCrawlerItem(link);
        return createCrawlerItemFavourite(user, crawlerItem);
    }

    @PostMapping(path = "/findcrawleritemfavourite/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CrawlerFavourites findCrawlerItemFavourite(@PathVariable String userEmail, @RequestBody String link) throws IOException {
        link = link.substring(1, link.length()-1);
        Users user = findUser(userEmail);
        CrawlerItem crawlerItem = findCrawlerItem(link);
        return crawlerFavouritesRepository.findByUseridAndLinkid(user, crawlerItem);
    }

    @GetMapping(path = "findusercrawleritemfavourites/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CrawlerFavourites> findUserCrawlerItemFavourites(@PathVariable String userEmail){
        Users user = findUser(userEmail);
        return crawlerFavouritesRepository.findByUserid(user);
    }

    @Transactional
    @DeleteMapping(path = "/deletecrawleritemfavourite/{userEmail}")
    public void deleteCrawlerItemFavourite(@PathVariable String userEmail, @RequestBody String link) throws IOException {
        link = link.substring(1, link.length()-1);
        Users user = createUser(userEmail);
        CrawlerItem crawlerItem = createCrawlerItem(link);
        crawlerFavouritesRepository.deleteByUseridAndLinkid(user, crawlerItem);
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

    public Documentation createDocumentation(String documentation_id, String link) throws UnsupportedEncodingException {
        Documentation documentation = new Documentation(documentation_id, link);
        return documentationRepository.save(documentation);
    }
    public Documentation findDocumentation(String documentation_id){
        return documentationRepository.findByDocumentationid(documentation_id);
    }

    public CrawlerItem createCrawlerItem(String link_id) throws UnsupportedEncodingException {
        CrawlerItem crawlerItem = new CrawlerItem(link_id);
        return crawlerItemRepository.save(crawlerItem);
    }
    public CrawlerItem findCrawlerItem(String link_id){
        return crawlerItemRepository.findByLinkid(link_id);
    }

    public ForumFavourites createForumFavourite(Users user, Posts post){
        ForumFavourites favourite = new ForumFavourites(user, post);
        return forumFavouritesRepository.save(favourite);
    }

    public DocumentationFavourites createDocumentationFavourite(Users user, Documentation documentation){
        DocumentationFavourites favourite = new DocumentationFavourites(user, documentation);
        return documentationFavouritesRepository.save(favourite);
    }

    public CrawlerFavourites createCrawlerItemFavourite(Users user, CrawlerItem crawlerItem){
        CrawlerFavourites favourite = new CrawlerFavourites(user, crawlerItem);
        return crawlerFavouritesRepository.save(favourite);
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
