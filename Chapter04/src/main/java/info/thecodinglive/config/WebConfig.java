package info.thecodinglive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import info.thecodinglive.ExecuteTimeInterceptor;

/**
 * WebMvcConfigurer 인터페이스는 '@EnableWebMvc'에서 제공하는 Bean을 설정 할 수 있는 기능을 제공한다.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	/**
	 * <bean id="executeTimeInterceptor" class="info.thecodinglive.ExecuteTimeInterceptor"> 와 같음
	 */
	@Bean
	public ExecuteTimeInterceptor executeTimeIntercepter() {
		return new ExecuteTimeInterceptor();
	}
	/**
	 * addPathPatterns("/**")는 호출될 경로
	 * excludePathPatterns("/")는 인터셉터가 호출되지 않는 예외 페이지
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(executeTimeIntercepter()).addPathPatterns("/**").excludePathPatterns("/");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		// '/**' : 0개 이상의 디렉터리와 매칭 ↔ '/*' : 0개 이상의 파일과 매칭
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/", "/assets/")
				.setCachePeriod(60 * 60 * 24 * 365) // 캐시 기간 1년
				.resourceChain(true)
				// VersionResourceResolver().addContentVersionStrategy는 웹 리소스 파일 로드 시 해쉬 적용
				.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
	}

	/**
	 * 페이지와 URL연결만 필요한 경우 addViewControllers 메서드를 사용
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		WebMvcConfigurer.super.addViewControllers(registry);
		registry.addViewController("/home").setViewName("home");
	}

}
