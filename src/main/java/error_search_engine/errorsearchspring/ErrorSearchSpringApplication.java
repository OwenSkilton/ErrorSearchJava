package error_search_engine.errorsearchspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

@Import(SpringDataRestConfiguration.class)
@SpringBootApplication
public class ErrorSearchSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErrorSearchSpringApplication.class, args);
    }
}
