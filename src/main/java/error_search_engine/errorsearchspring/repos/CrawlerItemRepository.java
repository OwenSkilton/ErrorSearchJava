package error_search_engine.errorsearchspring.repos;

import error_search_engine.errorsearchspring.entities.CrawlerItem;
import error_search_engine.errorsearchspring.entities.Documentation;
import error_search_engine.errorsearchspring.entities.Posts;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.print.Doc;

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "crawleritem", path = "crawleritem")
@CrossOrigin
public interface CrawlerItemRepository extends CrudRepository<CrawlerItem, String> {

    CrawlerItem findByLinkid(String linkid);
}
