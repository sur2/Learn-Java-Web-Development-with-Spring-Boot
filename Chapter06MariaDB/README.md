# Learn-Java-Web-Development-with-Spring-Boot
[도서:제이펍] 스프링 부트로 배우는 자바 웹 개발 



##  데이터베이스

#### 대표적인 데이터 처리 방법 Mapper(MyBatis), ORM(Spring Data JPA), QueryDSL


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

**외부 DB를 사용하여 스프링 컨테이너 실행 시 classpath의 SQL파일 Query 실행법**

```
 Resource resource = new ClassPathResource("SQLQuery.sql");
 ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
 databasePopulator.execute(dataSource);
```

#### selectKey

INSERT, UPDATE Query 전후 SELECT 구문을 실행해서 키가 되는 값을 매핑할 수 있게 해주는 기능 

| 속성명      | 역할                                                |
| ----------- | --------------------------------------------------- |
| resultType  | return할 Data Type                                  |
| Order       | selectKey 태그 안에 쿼리 실행 순서(Before \| after) |
| keyProperty | insert 문이나 다른 문장에서 참조할 수 있는 id 값    |

예시) Chapter06MariaDB/src/main/resources/sample/mapper/freeBoardMapper.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="sample.mapper.freeBoard">
	<insert id="insertBoard" parameterType="info.thecodinglive.model.FreeBoardVO">
		<selectKey resultType="String" order="BEFORE" keyProperty="boardId">
			SELECT
			CONCAT('FB', DATE_FORMAT(NOW(), '%y%m%d%h%i%s')) AS FBSEQ
		</selectKey>
		INSERT INTO FREE_BOARD
		(BOARD_ID, UNAME, TITLE, CATEGORY, CONTENT, WDATE)
		values(#{boardId}, #{userName}, #{title}, #{category}, #{content}, now())
	</insert>
</mapper>
```

#### 동적 쿼리 태그

**IF 태그**

````
<selcet id="FindbyUserId">
	SELECT * FROM USER
	WHERE DEL_YN = 'N'
	<if test = "userID != null">
		AND USER_ID = #{userId}
	</if>
</select>
````

```
<if>
	SELECT * FROM USER
	WHERE DEL_YN='N'
	AND USER_GRADE_IN("값1", "값2", "값3")
</if>
```

**Foreach 태그**

```
<select id="foreachUserList" parameterType="java.util.HashMap" resultType="java.util.HashMap">
		SELECT ID, USERNAME, PASSWORD
		FROM TBL_USER
		WHERE ID IN
		<foreach collection="user_list" item="userId" index="index" open="(" close=")" separator=",">
			#{userId}
		</foreach>
	</select>
```



