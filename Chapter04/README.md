# Learn-Java-Web-Development-with-Spring-Boot
[도서:제이펍] 스프링 부트로 배우는 자바 웹 개발 



##  스프링 부트

스프링 부트는 WAR가 아닌 JAR 형태로 동작하기 때문에 main 메서드를 이용해서 실행한다.
main 메서드가 실행되면 내장된 웹 애플리케이션 서버(WAS)가 실행되어 웹을 통해 접근할 수 다.

- 스프링 부트에서 웹 자원들을 실행하기 위한 규약

  | 웹 자원                        | 경로                                                         |
  | ------------------------------ | ------------------------------------------------------------ |
  | 정적 HTML 파일                 | src/main/resources/static<br />src/main/public               |
  | 웹 페이지 대표 아이콘(Favicon) | src/main/resources/favicon.ico                               |
  | 템플릿                         | src/main/resources/templates<br />html - Thymeleaf<br />tpl - Groovy<br />ftl - Freemaker<br />vm - velocity |


### 정적 자원 관리

WebMvcAutoConfiguration 클래스는 기본 설정으로 웹 리소스 폴더에서 자원을 찾는다.
기본 경로 : src/main/resources/static

웹 리소스 폴더 선정

- assets 폴더 추가 : WebMvcConfigurer 인터페이스를 구현하여 addResourceHandlers 메서드를 오버라이딩

  ```
  @Configuration
  public class WebConfig implements WebMvcConfigurer{
  	@Override
  	public void addResourceHandlers(ResourceHandlerRegistry registry) {
  		WebMvcConfigurer.super.addResourceHandlers(registry);
  		// '/**' : 0개 이상의 디렉터리와 매칭 ↔ '/*' : 0개 이상의 파일과 매칭
  		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/", "/assets/");
  	}
  }
  ```

  addResourceHandler는 호출 경로로 사용될 URI 값 지정, addResourceLocations는 실제로 파일이 위치할 폴더 경로

- Resource 주소에 MD5 값 설정
  스프링에서 제공하는 콘텐츠 버전 정책을 사용하면  URL 주소에 Hash값이 추가되고 캐시 주기도 별도로 설정할 수 있다. 
  addResourceHandlers 메서드에 캐시 관련 내용을 추가한다.

  ```
  @Override
  	public void addResourceHandlers(ResourceHandlerRegistry registry) {
  		WebMvcConfigurer.super.addResourceHandlers(registry);
  		// '/**' : 0개 이상의 디렉터리와 매칭 ↔ '/*' : 0개 이상의 파일과 매칭
  		registry.addResourceHandler("/assets/**")
  		.addResourceLocations("classpath:/assets/", "/assets/")
  		.setCachePeriod(60*60*24*365) // 캐시 기간 1년
  		.resourceChain(true)
  		// VersionResourceResolver().addContentVersionStrategy는 웹 리소스 파일 로드 시 해쉬 적용
  		.addResolver(new VersionResourceResolver().addContentVersionStrategy("/**"));
  	}
  ```

  versionResourceResolver를 통해 웹 리소스 파일을 호출하기 위해 ResourceUrlProvider를 이용하는 것이 좋다. 이는 설정한 resolver에 맞게 로드 할 수 있다.

  ```
  @ControllerAdvice
  public class ResourceAdvice {
	@Autowired
  	private ResourceUrlProvider resourceUrlProvider;
  	
  	@ModelAttribute("versionResourceResolver")
  	public ResourceUrlProvider versionResourceResolver() {
  		return this.resourceUrlProvider;
  	}
  }
  ```
  
### WebJars
pom.xml에 webJAR로 사용할 수 있는 라이브러리들(https://www.webjars.org)을 사용할 수 있도록 의존성을 추가할 수 있다.

### Interceptor with Spring boot

Spring framework에서는 ExcuteTimeInterceptor XML을 사용했지만 Spring boot에서는 그러지 않아도 적용할 수 있다.

- WebMvcConfigurer 인터페이스를 구현하여  HandlerInterceptorAdapter Bean을 등록하고 addInterceptors() 메서드를 구현한다.
- addPathPatterns("/**") :  경로 지정
- excludePathPatterns("/") :예외 페이지 지정

