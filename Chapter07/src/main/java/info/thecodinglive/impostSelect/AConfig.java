package info.thecodinglive.impostSelect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AConfig {
	@Bean
	MyBean myBean() {
		return new MyBean("from AConfig");
	}
}
