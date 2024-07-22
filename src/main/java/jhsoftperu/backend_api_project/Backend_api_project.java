 
package jhsoftperu.backend_api_project;

 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
 import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author Asus
 */
@SpringBootApplication
@ComponentScan({"jhsoftperu.backend_api_project", "jhsoftperu.controller", "jhsoftperu.service", "jhsoftperu.model","jhsoftperu.util"})
@EnableJpaRepositories("jhsoftperu.dao")
@EntityScan("jhsoftperu.model")

 public class Backend_api_project {

    public static void main(String[] args) {
        /*TODO:Inicializar Sprint aplication   */
        SpringApplication.run(Backend_api_project.class, args);
 
    }
}
