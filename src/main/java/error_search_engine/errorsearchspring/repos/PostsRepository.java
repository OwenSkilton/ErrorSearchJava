package error_search_engine.errorsearchspring.repos;

import error_search_engine.errorsearchspring.entities.Posts;
import error_search_engine.errorsearchspring.entities.Users;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
@CrossOrigin
public interface PostsRepository extends CrudRepository<Posts, Long> {

    Posts findByPostid(Long postid);
}
