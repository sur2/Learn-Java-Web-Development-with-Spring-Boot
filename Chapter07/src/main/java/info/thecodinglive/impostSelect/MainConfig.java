package info.thecodinglive.impostSelect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoMyModule("someValue")
public class MainConfig {
	@Bean
	public UseMyBean useMyBean() {
		return new UseMyBean();
	}
}
