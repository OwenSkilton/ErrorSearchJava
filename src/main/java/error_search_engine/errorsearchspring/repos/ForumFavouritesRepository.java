package error_search_engine.errorsearchspring.repos;

import error_search_engine.errorsearchspring.entities.ForumFavourites;
import error_search_engine.errorsearchspring.CompositeIDS.ForumFavouritesID;
import error_search_engine.errorsearchspring.entities.Posts;
import error_search_engine.errorsearchspring.entities.Users;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "forumfavourite", path = "forumfavourite")
@CrossOrigin
public interface ForumFavouritesRepository extends CrudRepository<ForumFavourites, ForumFavouritesID> {

    ForumFavourites findByUseridAndPostid(Users userid, Posts postid);

    void deleteByUseridAndPostid(Users userid, Posts postid);

    List<ForumFavourites> findByUserid(Users userid);
}
