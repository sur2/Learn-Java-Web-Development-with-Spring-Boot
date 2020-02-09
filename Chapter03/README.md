# Learn-Java-Web-Development-with-Spring-Boot
[도서:제이펍] 스프링 부트로 배우는 자바 웹 개발 



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