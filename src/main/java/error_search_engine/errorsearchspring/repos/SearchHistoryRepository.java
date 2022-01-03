package error_search_engine.errorsearchspring.repos;

import error_search_engine.errorsearchspring.entities.SearchHistory;
import error_search_engine.errorsearchspring.entities.Users;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "searchhistory", path = "searchhistory")
@CrossOrigin
public interface SearchHistoryRepository extends CrudRepository<SearchHistory, Long> {

    List<SearchHistory> findByUserid(Users userid);
}
