package info.thecodinglive.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		// '/**' : 0개 이상의 디렉터리와 매칭 ↔ '/*' : 0개 이상의 파일과 매칭
		registry.addResourceHandler("/assets/**")
		.addResourceLocations("classpath:/assets/", "/assets/")
		.setCachePeriod(60*60*24*365) // 캐시 기간 1년
		.resourceChain(true)
		// VersionResourceResolver().addContentVersionStrategy는 웹 리소스 파일 로드 시 해쉬 적용
		.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"))
		;
	}
}
