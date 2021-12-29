package error_search_engine.errorsearchspring.config;


import error_search_engine.errorsearchspring.entities.Favourites;
import error_search_engine.errorsearchspring.entities.Posts;
import error_search_engine.errorsearchspring.entities.Users;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Favourites.class);
        config.exposeIdsFor(Posts.class);
        config.exposeIdsFor(Users.class);

    }
}
