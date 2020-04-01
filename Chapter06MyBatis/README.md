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

