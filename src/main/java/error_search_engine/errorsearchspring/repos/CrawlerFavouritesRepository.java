package error_search_engine.errorsearchspring.repos;

import error_search_engine.errorsearchspring.entities.*;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "crawlerfavourite", path = "crawlerfavourite")
@CrossOrigin
public interface CrawlerFavouritesRepository extends CrudRepository<CrawlerFavourites, String> {

    CrawlerFavourites findByUseridAndLinkid(Users userid, CrawlerItem crawlerItem);

    void deleteByUseridAndLinkid(Users userid, CrawlerItem crawlerItem);

    List<CrawlerFavourites> findByUserid(Users userid);
}
