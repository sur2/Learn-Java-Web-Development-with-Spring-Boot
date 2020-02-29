# Learn-Java-Web-Development-with-Spring-Boot
[도서:제이펍] 스프링 부트로 배우는 자바 웹 개발 



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