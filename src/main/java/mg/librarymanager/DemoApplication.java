package mg.librarymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@Controller
public class DemoApplication {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        String[] beans = applicationContext.getBeanDefinitionNames();
        for (var bean : beans
        ) {
            System.out.println(bean);
        }
    }

}
