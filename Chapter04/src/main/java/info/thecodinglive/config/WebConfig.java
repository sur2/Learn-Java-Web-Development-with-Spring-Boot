package info.thecodinglive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		// '/**' : 0개 이상의 디렉터리와 매칭 ↔ '/*' : 0개 이상의 파일과 매칭
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/", "/assets/");
	}
}
