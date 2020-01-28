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