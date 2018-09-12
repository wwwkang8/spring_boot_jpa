## 반복주기 3 학습 목표
* 데이터베이스에 사용자 데이터 추가
* 개인정보 수정 기능 구현
* 질문하기, 질문 목록 기능 구현

## 강의 순서
* 3-1. QnA HTML 템플릿, H2 데이터베이스 설치, 설정, 관리툴 확인
* 3-2. 자바 객체와 테이블 매핑, 회원 가입 기능 구현
* 3-3. 개인정보 수정 기능 구현
* 3-4. 질문하기, 질문목록 기능 구현(강의 전 직접 구현)
* 3-5. 원격 서버에 소스 코드 배포
*연습2. vi 에디터 연습하기

## 3-1강. QnA HTML 템플릿, H2 데이터베이스 설치, 설정, 관리툴 확인
### HTML 템플릿 가져오기
    - $ git clone : https://github.com/slipp/web-application-server.git
      - 깃 클론으로 박재성 강사님의 html을 로컬에 저장한다.
    - 이클립스 import : 이클립스를 이용하여 maven project로 import한다.
      - 클론된 프로젝트가 이클립스 플젝이 아니기 때문에 General로 선택해서 하면 import가 안된다.
        왜냐하면 이 프로젝트는 maven 기반의 프로젝트이기 때문이다. pom.xml이 maven 플젝을 이클립스 플젝으로 변환.

### H2 데이터베이스 설치
    - maven repository : h2 검색
    - pom.xml에 dependency 추가
        -<!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
          <dependency>
              <groupId>com.h2database</groupId>
              <artifactId>h2</artifactId>
              <version>1.4.196</version>
              <scope>test</scope>
          </dependency>
    - h2 console 접속 : localhost:9090/h2-console/ 로 h2에 접속 가능
      - White lable 에러 발생시 : maven의 <scope>test</scope> 지우고 서버 재부팅
    - h2 로그인 : jdbc:h2:mem:testdb
    
## 3-2강. 자바 객체와 테이블 매핑, 회원가입 기능 구현
### JPA 디펜던시 설정
     - <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
### H2 설정
    - spring.datasource.url=jdbc:h2:~/my-slipp;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
      spring.datasource.driverClassName=org.h2.Driver
      spring.datasource.username=sa
      spring.datasource.password=
      spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
      **jdbc:h2:~/my-slipp : 이게 바로 h2-console에서 로그인 하는 아이디이다.

## 3-3강. 새로운 HTML 적용 및 URL 리팩토링
    - @RequestMapping : Controller에서 대표 URL로 지정하여 Restful API에서 URL 중복을 피할 수 있다.
![reqeustmapping](https://user-images.githubusercontent.com/26863285/45261267-9de58380-b439-11e8-9cd2-dc70534120c1.png)
    - static 과 template 폴더의 차이 : static폴더의 html 파일들은 URL로 직접 접근이 가능하다.
                                      하지만 template 폴더의 html들은 반드시 Controller를 거쳐서 접근해야 한다.
    - mustache에서 include 하는 방법
        - {{> /include/navigation}} 이렇게 include 한다
        - mustache 엔진이 template 폴더를 검색할 때는 최상위 폴더인 template 폴더부터 보고 include->navigation.html 순서로 파일을 검색한다.
    - @Entity : VO 파일을 테이블로 만들어주는 어노테이션
    - @Id : 특정 필드값을 PK로 만들어준다
    - @GeneratedValue : 시퀀스 값을 자동으로 1씩 증가시켜준다
    - @Column(nullable=false) : Not null을 설정해 줄 수 있다.
 
 ### 3-4강. 개인정보 수정 기능 구현1
 	- 기본적으로 MVC 패턴에서는 View에 접근할 때 무조건 Controller를 통해서 한다.
	- 3-4강 10분부터 다시 
