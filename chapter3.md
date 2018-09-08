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
   

