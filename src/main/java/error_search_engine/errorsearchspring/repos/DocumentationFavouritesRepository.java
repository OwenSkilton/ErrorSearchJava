package error_search_engine.errorsearchspring.repos;

import error_search_engine.errorsearchspring.CompositeIDS.DocumentationFavouritesID;
import error_search_engine.errorsearchspring.CompositeIDS.ForumFavouritesID;
import error_search_engine.errorsearchspring.entities.*;
import io.swagger.annotations.Api;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Api(tags = "Address Entity")
@RepositoryRestResource(collectionResourceRel = "documentationfavourite", path = "documentationfavourite")
@CrossOrigin
public interface DocumentationFavouritesRepository extends CrudRepository<DocumentationFavourites, DocumentationFavouritesID> {

    DocumentationFavourites findByUseridAndDocumentationid(Users userid, Documentation documentationid);

    void deleteByUseridAndDocumentationid(Users userid, Documentation documentationid);

    List<DocumentationFavourites> findByUserid(Users userid);
}
