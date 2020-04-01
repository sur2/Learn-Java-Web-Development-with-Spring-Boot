# Learn-Java-Web-Development-with-Spring-Boot
[도서:제이펍] 스프링 부트로 배우는 자바 웹 개발 




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
