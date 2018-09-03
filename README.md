# spring_boot_jpa
자바지기 박재성님의 유튜브 강좌로 혼자 부트, JPA 독학

1) 앞으로 12월말 까지의 내가 공부할 로드맵 : 목표는 현재 할 수 있는 것에 집중해서 "완료"한다. 그 외의 것들은 배울 것들은 추후에 생각하기.
   내가 무엇을 공부해야 하는지 알고 있다. 이젠 그 계획을 실천하기. 다른 곳에 집중 흐트리지 말자
 - 언어 : Java. Effective 자바로 공부하기
 - 개발
   1) 프레임워크 : Spring Boot(자바지기 박재성님 강의)  - 1일 1시간
   2) DB : JPA, SQL
 - 운영, 배포 : AWS, 리눅스, 배포 자동화, 쉘 스크립트
 - 알고리즘 : 백준 알고리즘 기초 동영상 강의 - 1일 1
 - Tool 사용법 : git, intellij, postman 공부

## 1-1강 : Spring boot 로컬 개발환경 세팅
### 1. 로컬 개발환경 세팅
      - 프로젝트 생성 : Spring Starter Project 생성
      - 프로젝트 이름 정하기 : my-slipp
      - Type : maven, package : jar
      - Group : net.slipp
      - Artifact : my-slipp
      - Package : net.slipp
      - 디펜던시 추가 : Web, Mustache(템플릿엔진), devtools --> pom.xml에서 확인이 가능하다.
 
 ### 2. 서버 시작 : application.properties 에서 server.port='포트번호' 변경하고 서버를 구동.
 ### 3. LiveReload
      - 크롬 앱 LiveReload를 설치한다.
      - 역할 : STS에서 변경사항이 생겼을 때, 파일의 변경사항을 자동으로 인식하여 기존의 refresh를 자동으로 해주는 것이다.
      - Enable liveReload : 동그란 화살표 아이콘을 클릭하면 점이 검은색이 되면서 기능이 활성화 된다.


## 1-2강 : Boostrap 활용한 html 페이지 개발
### 1) bootstrap Jar 파일 다운로드 : 인터넷에서 받아올 수도 있지만 프로젝트 내부에 jar파일로 다운하는 방법도 있다
   - jar 파일 찾는 방법 : mvnrepository(메이븐)에서 찾고자 하는 jar 파일을 검색한다.
   - pom.xml dependency 추가 : 메이븐 디펜던시를 pom.xml에 추가한다.
   - 외부 URL을 내부 URL로 경로 변경 : resources에서부터 찾아들어간다.
    ex) resources(생략)/webjars/bootstrap/3.3.7-1/css/파일 명
    
### 2) Bootstrap에서 필요한 Component 끌어다 쓰기
  - form 형태 : https://getbootstrap.com/docs/4.1/components/forms/
  - Navbar 코드 : https://getbootstrap.com/docs/4.1/examples/navbars/
  
## 1-3강 : local 소스코드를 github에 올리기
### 1) 로컬 코드 개발 서버/ 실 서버
      - local --> git/svn(버전관리시스템) --> 개발 서버/ 실 서버.  !로컬 코드가 바로 실 서버로 이동하지 않는다. 중간에 git을 통해 배포
      - local --> 소스트리 --> github.com --> 개발 서버/ 실 서버

### 2) 소스트리 사용하기
      - 1. 소스트리에서 새로운 탭을 하나 생성한다.
      - 2. 
      
## 1-4강 : 원격 서버에 소스코드 배포하기 1단계
### 참고문서 : https://github.com/slipp/jwp-book  챕터3에서 확인하기

### 1) AWS 리눅스 서버 생성하기 : https://jojoldu.tistory.com/259?category=635883
### 2) Windows에서 리눅스 인스턴스로 접속하는 방법(https://opentutorials.org/module/1946/11280)
    - 넷사랑 Xshell 6 다운로드(https://www.netsarang.co.kr/download/main.html) : window 환경에서 리눅스 명령어로 원격 서버에 접속할 수 있게         해주는 프로그램이다.
    - AWS EC2 인스턴스 --> 우클릭 "연결" : SSH에 어떻게 접속하는지에 대한 정보를 알려준다. 
    - Xshell 6 새로만들기 클릭 : 원격 컴퓨터에 접속을 하기 위한 정보를 입력하는 것이다.
      [연결]
      - 이름 : 원격서버의 닉네임을 지어주는 것이다. 어떤 것으로 해도 가능.
      - 프로토콜 : SSH 선택
      - 호스트 : 인스턴스의 "연결" 정보에서 4번의 퍼블릭 DNS를 통해 연결에 해당하는 주소를 붙여넣는다.
     [연결 > 사용자 인증]
      -  방법 : public key
      - 사용자 이름 : ec2-user@ec2-10-18~~~~~ 써 있는 곳에서 @ 앞부분 "ec2-user"에 해당하는 것이 사용자 이름이다.
      - 사용자 키 : pem 파일이 저장되어 있는 곳으로 경로 지정.
      - 암호 : 빈칸으로 놓는다.
     [접속]
      - 닉네임 우클릭 --> 열기 클릭 : 해당 원격 서버에 연결이 된다.
      - SSH 보안경고 : 수락 및 저장 클릭.
      - 접속 끊기 : exit 명령어 입력
    

