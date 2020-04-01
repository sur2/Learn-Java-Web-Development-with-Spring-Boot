# Learn-Java-Web-Development-with-Spring-Boot
[도서:제이펍] 스프링 부트로 배우는 자바 웹 개발 

 

## [issue] 
### Multiple problems have occurred 
### 'Could not calculate build plan: Plugin' 해결법 

```
C:\Users\사용자\로그인\.m2\repository\org\apache\maven\plugins\maven-resources-plugin
```
경로의 2.6 폴더 **삭제**



## Servlet

### Multipart : getPart()로 데이터 전송 (Client에서 Server로 업로드)

### Filter : implements Filter의 doFilter로 servlet보다 먼저 작동

### Cookie : HTTP 헤더 정보에 포함되며 상태 정보를 저장할 공간

- 쿠키에 한글로 String 값 넣을 시 URLEncoder.encode URLDecoder.decode 할 것
- 쿠키의 삭제는 유효시간을 '0'으로 만들어서 무효화 할 것

### Session : 서버와 클라이언트의 유효한 커넥션을 식별(ID)

- 세션 초기화 request.getSession()
- 세션 만들기 Session.setAttribute(name, value);
- 세션 조회 Session.getAttribute(name);
- 세션 삭제(모든 세션 삭제) Session.invalidate();

### 디자인 패턴 활용

- Java EE 패턴

  - Interceping Filter : 요청에 대한 전처리 및 후처리
  - Front Controller : 요청에 대한 처리를 관리하는 중앙 컨트롤러(MV'C')
  - View Helper : 뷰의 표현을 위해 비즈니스 로직을 가지고 있는 개념상의 Helper
  - Composite View : 레고 블럭 가은 작은 뷰들을 조합해서 만드는 전체의 뷰
  - Service to Worker : Front Controller와 View Helper Pattern을 이용해 dispatcher 컴포넌트를 구성
  - Dispatcher View : Service to Worker와 동일하며 차이점은 뷰에 대한 처리 중에 수행되어야 하고, 작은 시스템에서 더 안정적이다.

- 프론트 컨트롤러 패턴 : 컨트롤러가 공통 요청을 머저 수행하고 뷰를 호출하는 패턴

  - response.sendRedirect(경로);

  - request.getRequestDispatcher(절대경로);

    ```
    RequestDispathcer rd = request.getRequestDispathcer(절대경로);
    rd.forward(ServletRequest request, ServletResponse response)
    ```

    ```
    if(url == "list") {
    	RequestDispatcher rd = request.getRequestDispatcher(url);
    	rd.forward(request, response);
    } else if(url == "write") {
    	RequestDispatcher rd = request.getRequestDispatcher(url);
    	rd.forward(request, response);
    }
    ```
- 커맨드 패턴 : 명령(로직)을 객체 안에 캡슐화해서 컨트롤러와 같은 클래스를 수정하지 않고 재사용할 수 있게 하는 패턴

  ```
  Front Controller(Servlet.java) → Commnad.class (:상속)→ HomeView.java → home.jsp
  ```



## 스프링 프레임워크

### 빈 + 컨테이너 : 스프링은 객체 관리를 해주는 빈 컨테이너 프레임워크

- 스프링 XML 설정 : applicationContext.xml 
  - 빈 등록 : <Bean> 태그, init-method, destory-method로 생명주기 제어 가능
    하위 속성으로 인터페이스는 <property>,  구현체는 <ref> 태그로 타입 및 클래스 명시
- 어노테이션 : @Configuration 
  - 빈 등록 : @Bean 
  - 생명주기 제어 @Bean(initMethond="", destoryMethod="") 또는 @PostConstruct, @PreDestroy

### 제어의 역전(Inversion of Control)

- 의존 관계 역전 원칙(Dependency Inversion Principle) : 인터페이스를 활용하여 결합도를 낮추자!
- 의존성 주입(Dependency Injection) : 인스턴스화를 하기 위해서는 반드시 객체 생성에 필요한 코드가 수반되어 완전히 분리할 수 없다. 그래서 인스턴스화 할 수 있는 코드의 의존성을 대신 해결에  주자

### 스프링 MVC

Front Controller 패턴에 Spring의 의존성 주입(DI)을 이용해서 컴포넌트들의 생명주기를 관리할 수 있는 컨트롤러 중심의 웹 Model View Control 프레임워크

- 스프링 MVC 구조 : DispatcherServlet, Handler Mapping, Handler, Intercepter, View Resolver, View
  <img src="https://github.com/sur2/Learn-Java-Web-Development-with-Spring-Boot/blob/master/Chapter03MVC/springmvcimage.jpg?raw=true" style="zoom: 50%;" />
- 스프링 MVC 설정 : spring core(context), spring mvc, spring web(webmvc)
- DispatcherServlet 설정
  - web.xml
  - javaConfig (단, Servlet 3.0이상)
- Interceptor : 컨트롤러가 요청하기 전(pre), 후(post) 처리



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



## REST API Server

### REST

- 특성
  - 클라이언트/서버 client/server
  - 상태 없음 stateless
  - 레이어드 아키텍쳐 Layered Architecture
  - 캐시 chace
  - 코드 온 디멘드 code on demand
  - 통합 인터페이스 Integrated Interface
- REST 인터페이스 규칙
  - 리소스 식별 (URI와 같은 고유 식별자) 
  - 표현을 통한 리소스 처리 (JSON, XML, HTML 등 표현)
  - 자기 묘사 메시지 (Header를 통한 메타 데이터을 담음)
  - 에플리케이션의 상태에 대한 하이퍼미디어(HATEOAS, Hypermedia As The Engine Of Application State)
    데이터  + 링크 정보

### 리소스
Resource는 REST의 핵심 개념으로 접근할 수 있고 조작할 수 있는 모든 것. 
이미지, 비디오 등 명사화 할 수 있는 대부분의 것.

### REST  API

- HTTP Method
  - GET : 조회 (응답을 보장함)
  - POST :  생성 (응답을 보장하지 않음)
  - PUT : 업데이트 요청
- ResponseEntity : 응답 헤더는 ResponseEntity를 사용해 상태값을 전달할 수 있으며 HttpHeaders를 사용하면 헤더를 구현할 수 있다.
  - HATEOAS, Hypermedia As The Engine Of Application 
    ResourceSupport 는 RepresentationModel으로 변경되었음!
    https://docs.spring.io/spring-hateoas/docs/1.0.1.RELEASE/reference/html/    
  - HATEOAS를 이용한 URI정보 표현
    ControllerLinkBuilder.linkTo와 ControllerLinkBuilder.methodOn를 이용하여 메서드를 매핑한다. (해당 메서드의 URL 반환)
- REST API 문서화 
  
  - swagger : API 정보를 문서화 (왜 HATEOAS랑 의존성 같이 넣으면 Bena을 못 찾아?) 
  
    http://localhost:9090/swagger-ui.html#/
  
    - Selectors.any()는 전체 문서화 
  
  - REST 클라이언트 : RestTemplate 라이브러리를 사용해서 JSON 응답을 Map 또는 모델 클래스로 변환해서 사용 가능



##  데이터베이스

#### 대표적인 데이터 처리 방법 Mapper(MyBatis), ORM(Spring Data JPA), QueryDSL

### ORM 

 **Object Relational Mapping** : 데이터베이스 서버에 접속해서 쿼리를 수행하고, 그 결과를 프로그램상에서 사용할 수 있도록 JDBC API를 제공한다. (JDBC : Java Database Connectivity)

 ORM을 사용하여 코드의 반복을 줄이고 객체 중심의 설계로 개발을 진행한다.

#### Spring Data JPA

 **Java Persistence API**, ORM 중 하나이다. 관계형 데이터베이스에서 NOSQL로 변경하더라도 Repository 인터페이스에 정의된 동일한 메서드 시그니처를 사용할 수 있다.

 Spring Data JPA의 각 인터페이스들은 공통적으로 noRepository 어노테이션이 선언되어 있다. 인터페이스들을 구분해서 사용자가 만든 Repository들만 스프링이 인식하는 빈이 되도록 하는 것이다.

 Entity 클래스 : @Entity 어노테이션을 선언하여 데이터베이스 스키마의 내용을 자바 클래스로 표현한다.

Repository 인터페이스: JpaRepository 인터페이스를 상속받아 Entity 조작에 필요한 Query를 메서드화해서 사용할 수 있는 역할

### QueryDSL을 이용한 Type Safe한 쿼리 작성

 **기존 언어의 메서드를 사용하여 JPA보다 동적인 쿼리**

 **QueryDslRepositorySupport** 활용하면 JPA에서 queryDSL을 함께 사용할 수 있다. 

 준비과정

1. Q클래스 생성

  **Maven APT plugin 설정 : Q클래스 생성**

  ```
  <!-- QueryDSL plugin : Q클래스 생성 설정 -->
  			<plugin>
  				<groupId>com.mysema.maven</groupId>
  				<artifactId>apt-maven-plugin</artifactId>
  				<version>1.1.3</version>
  				<executions>
  					<execution>
  						<goals>
  							<goal>process</goal>
  						</goals>
  						<configuration>
  							<!-- Q클래스가 컴파일시 생성될 위치 -->
  							<outputDirectory>target/generated-sources/java</outputDirectory>
  							<!-- 컴파일시 JPAAnnotationProcessor 실행 -->
  							<processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
  						</configuration>
  					</execution>
  				</executions>
  			</plugin>
  ```

2. 커스텀 Repository 인터페이스 생성
3. QueryDslRepositorySupport 구현체 작성, 커스텀 Repository 생성
   Q클래스 초기화 - JPQLQuery 객체 초기화 : 쿼리 표현식 메서드 사용가능
   (Interface @Repository)Repository, (Interface)RepositoryCustom, (Class)RepositoryImpl(구현체)는 네이밍을 지켜야하며 같은 위치에 있어어야 한다.

### 쿼리 매퍼

#### Mybatis : 쿼리 매퍼를 사용하여 SQL Query 실행

 Mybatis 설정 클래스를 만들어 sqlSession 객체를 사용한다. sqlSession 객체를 생성하기 위해서 SqlSessionFactory를 사용한다. 스프링을 같이 사용할 때는 SqlSessionTemplate을 쓴다. 그 이유는 sqlSession을 대체할 수 있고, 예외 처리를 Mybatis가  아니라 Spring에 DataAcessException으로 치환시키는 역할을 해주기 때문이다.

Mapper.xml 예시

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 네임스페이스는 매퍼가 저장된 패키지명과 파일명으로 지정 -->	
<mapper namespace="sample.mapper.userMapper">
	<select id="selectUserInfoAll" resultType="hashmap">
	 <![CDATA[
	  SELECT id, username, password
	  FROM tbl_user
	 ]]>
	</select>
	
	<insert id="addUserInfo">
		insert into tbl_user(id, username, password)
		values(#{id}, #{userName}, #{passWord})
	</insert>
	
	<select id="findByUserNameLike" parameterType="map" resultType="hashmap">
		SELECT id, username, password 
		FROM tbl_user
		WHERE USERNAME LIKE '%${userName}%'
	</select>
	
	<!-- resultMap : 클래스 필드와 데이터베이스 필드를 매핑-->
	<resultMap id="userResultMap" type="info.thecodinglive.model.UserVO">
		<!-- property="클래스 필드" column="데이터베이스 필드" -->
		<result property="id" column="id"/>
		<result property="userName" column="username"/>
		<result property="passWord" column="password"/>
	</resultMap>
	<!-- resultMap으로 반환 -->
	<select id="findByUserName" parameterType="map" resultMap="userResultMap">
		SELECT * FROM TBL_USER WHERE USERNAME = #{userName}
	</select>
</mapper>
```

#### MyBatisConfig

@Bean을 설정한다.

SqlSessionTemplate - SqlSessionFactory - SqlSessionFactoryBean(DataSource)



### 데이터베이스 서버와 연동

**MariaDB** 
``C:\Users\Owner\Downloads\mariadb-10.1.20-winx64\mariadb-10.1.20-winx64\bin > mysql -u root -p --port=3307``

**사용할 데이터베이스와 사용자 계정 생성 후 권한 부여 **
``create database jpub;``
``create user jpubdev identified by 'qwer1234';``
``grant all privileges on jpub.* to jpubdev;``
``flush privileges;``

#### HikariCP

HikariCP : 데이터베이스 커넥션 풀 라이브러리 중 하나로 성능이 뛰어나다.
(데이터베이스를 사용하기 위한 네트워크 통신은 프로그램이 요청할 때 마다 커넥션을 생성)

application.properties

```
#spring.datasource.url=jdbc:데이터베이스명://서버IP:port/데이터베이스명
spring.datasource.url=jdbc:MariaDB://localhost:3307/jpub
spring.datasource.driver-class-name=org.MariaDB.jdbc.MySQLDataSource
spring.datasource.username=jpubdev
spring.datasource.password=1234
spring.datasource.separator=;
```

HikariCP로 생성할 Java Class 생성
@Configuration Annotation 정의
@PropertySource("application.properties") Annotation을 사용하여 application.properties를 @Value로 매핑