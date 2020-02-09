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