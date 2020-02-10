# Learn-Java-Web-Development-with-Spring-Boot
[도서:제이펍] 스프링 부트로 배우는 자바 웹 개발 

 

## Multiple problems have occurred 

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