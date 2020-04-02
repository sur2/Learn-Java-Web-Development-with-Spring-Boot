package info.thecodinglive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Chapter06MariaDbApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Chapter06MariaDbApplication.class, args);
	}

}
