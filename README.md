#단축 URL 서비스

프로젝트 소개
====
URL을 입력받아 짧게 줄여주고 단축된 URL을 입력하면 원래URL 로 리다이렉트하는 서비스
* URL 입력폼 제공 및 결과 출력
* 단축URL 키는 8자 이내로 생성
* 동일한 URL 에 대한 요청은 동일한 단축URL로 응답
* 단축URL 요청받으면 원래 URL 로 리다이렉트


개발환경
----
* JAVA 1.8  
* SpringBoot 2.1.7  
* MariaDB 5.7.21  
* MyBatis  1.3.1
* Gradle 5.4.1  
* JQuery 3.1.1  
* Swagger 2.6

프로세스
----
* 이미 등록된 단축URL을 생성시
![process_1](https://user-images.githubusercontent.com/33255462/63277479-61283a80-c2e0-11e9-984a-8d361eda9d97.png)

* 새로운 단축URL 생성시
![process_2](https://user-images.githubusercontent.com/33255462/63277191-de06e480-c2df-11e9-8d4a-66df71f85a2f.png)

방법
----
단축URL의 문자열은 영문 대소문자(52자),숫자(10자)로 구성하였습니다.  

특수문자를 사용하지 않은 이유는 URL에 사용될 경우 URL인코딩 이슈가 있기 때문입니다.  
그래서 base64가아닌 ' +', '/'  문자를 제외한 base62로 인코딩을 진행하였습니다.  
(엄밀히 따지면 base64의 마지막 문자  패딩('=')까지 제외)

인코딩의 대상은 중복이되지않는 데이터베이스의 key값과 맵핑하였고,
키값을 인코딩하여 데이터베이스에 저장하였습니다.  

최종적으로 데이터베이스에는 아래와 같이 저장되게 하였습니다.  

seq : 키값(auto increment)  
origin_url : 사용자로부터 받은 URL  
short_url : seq를 인코딩한 문자열  

그리고 origin_url컬럼에 인덱스를 생성하였습니다.
이유는 단축url생성시 입력받은 URL이 존재하는지 항상 DB에서 확인하기 때문입니다.



빌드&실행 방법
----
1. gradle을 bulid합니다.

2. MariaDB를 설치하고 DDL문을 실행합니다.

3. DDL문은 DDL.sql이라는 이름으로 프로젝트안에 들어가 있습니다. (데이터베이스 생성, 테이블생성, 인덱스 추가)

4. 데이터베이스 계정정보는 application.yml에서 수정하시면 됩니다.

5. application을 실행합니다.

6. 브라우저에 localhost:8080를 실행합니다. 

실행화면
----
![urlshort_main](https://user-images.githubusercontent.com/33255462/63429554-55aa5000-c455-11e9-8bea-35762a783c42.png)
![urlshort_valid](https://user-images.githubusercontent.com/33255462/63429476-1f6cd080-c455-11e9-963e-3b2562bb2c2c.png)
![urlshort_input](https://user-images.githubusercontent.com/33255462/63429420-ee8c9b80-c454-11e9-8981-87d332e1f512.png)


현재 문제점 & 추후 개선방안
----
1. 단축URL 생성시 DB에 이미 저장된 단축 URL이 있는지 조회하고 있는대 , 악의적인 사용자가 같은URL에 대해서 연속적으로 누른다면?  
-연속적인 호출에 대해서 웹서버의 방화벽에서 막는 방법도 있다.  
-Ehcash를 적용한다. 같은 URL에 대해서는 같은 단축URL을 반환해주기 때문에 고려해볼만 하다.   


기타
----
* 크로스도메인 처리
