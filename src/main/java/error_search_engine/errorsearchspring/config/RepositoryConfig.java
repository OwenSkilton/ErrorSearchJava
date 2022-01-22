package error_search_engine.errorsearchspring.config;


import error_search_engine.errorsearchspring.CompositeIDS.DocumentationFavouritesID;
import error_search_engine.errorsearchspring.CompositeIDS.ForumFavouritesID;
import error_search_engine.errorsearchspring.entities.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Users.class);
        config.exposeIdsFor(Posts.class);
        config.exposeIdsFor(ForumFavourites.class);
        config.exposeIdsFor(ForumFavouritesID.class);
        config.exposeIdsFor(Documentation.class);
        config.exposeIdsFor(DocumentationFavourites.class);
        config.exposeIdsFor(DocumentationFavouritesID.class);
        config.exposeIdsFor(CrawlerItem.class);
        config.exposeIdsFor(CrawlerFavourites.class);
    }
}
