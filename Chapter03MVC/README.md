# Learn-Java-Web-Development-with-Spring-Boot
[도서:제이펍] 스프링 부트로 배우는 자바 웹 개발 



## 스프링 프레임워크
### 스프링 MVC

Front Controller 패턴에 Spring의 의존성 주입(DI)을 이용해서 컴포넌트들의 생명주기를 관리할 수 있는 컨트롤러 중심의 웹 Model View Control 프레임워크

- 스프링 MVC 구조 : DispatcherServlet, Handler Mapping, Handler, Intercepter, View Resolver, View
  <img src="https://github.com/sur2/Learn-Java-Web-Development-with-Spring-Boot/blob/master/Chapter03MVC/springmvcimage.jpg?raw=true" style="zoom: 50%;" />
- 스프링 MVC 설정 : spring core(context), spring mvc, spring web(webmvc)
- DispatcherServlet 설정
  - web.xml
  - javaConfig (단, Servlet 3.0이상)
- Interceptor : 컨트롤러가 요청하기 전(pre), 후(post) 처리