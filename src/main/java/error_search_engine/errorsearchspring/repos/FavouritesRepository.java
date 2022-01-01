package error_search_engine.errorsearchspring.repos;

import error_search_engine.errorsearchspring.entities.Favourites;
import error_search_engine.errorsearchspring.CompositeIDS.FavouritesID;
import error_search_engine.errorsearchspring.entities.Posts;
import error_search_engine.errorsearchspring.entities.Users;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "favourite", path = "favourite")
@CrossOrigin
public interface FavouritesRepository extends CrudRepository<Favourites, FavouritesID> {

    Favourites findByUseridAndPostid(Users userid, Posts postid);
}
