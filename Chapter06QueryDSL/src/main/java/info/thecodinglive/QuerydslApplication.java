package info.thecodinglive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class QuerydslApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(QuerydslApplication.class, args);
	}

}
