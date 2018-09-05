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
      
### 3) ubuntu 계정에서 root 계정으로 활성화 시키기(이게 어려웠다)
    - 참고 블로그 : http://app-developer.tistory.com/94, http://ryanwoo.tistory.com/6, http://lab4109.blogspot.com/2013/10/aws-ec2-root.html
    - $ sudo passwd root : root 계정의 비밀번호를 바꾸는 작업
    - $ sudo vi /etc/ssh/sshd_config : PermitRootLogin을 yes로 바꾸어준다. (:wq! 명령어를 써서 저장하고 나간다)
    - $ sudo cp /home/ubuntu/.ssh/authorized_keys /root/.ssh
    - $ sudo service sshd restart : ubuntu유저의 인증키를 root로 복사하고 sshd를 리스타트한다.
    - ubuntu server 등록정보에 가서 [연결 > 사용자 인증]에서 이름을 "root"로 변경한다.

### 4) adduser 명령어 사용하여 계정 추가하기
    - ~# adduser 추가할 아이디
    - password 2번 입력
    - Full Name[] : 입력, 나머지 Room Number, Work Phone, Home Phone, Other은 Enter키로 스킵할 수 있다.
    - Is the information correct? [Y/n] Y
    - cd /home : home 폴더로 이동
    - cd wwwkang7 : home 폴더의 wwwkang7 계정으로 이동.
### 5) 생성한 계정에 권한 부여하기
    - 주의!! AWS Ubuntu 인스턴스에서는 이미 "ubuntu"라는 계정이 있기 때문에 따로 adduser로 계정을 추가하지 않아도 된다.
    - vi /etc/sudoers : 생성한 계정들의 권한을 부여할 수 있는 창이 뜬다. (단축키 i : insert모드, esc : 입력모드에서 나온다)
    - 권한 추가 : ubuntu ALL=(ALL:ALL) ALL 이렇게 해서 ubuntu에 모든 권한을 부여한다.(주의 : 숫자로 계정 이름을 끝내면 안된다. 문자로 끝내기)
    - 저장하고 나오기 : :wq!를 치면 저장하고 나온다.
    
### 6) 생성한 계정으로 재접속하기 --> 이 부분이 안된다. 암호 입력을 해도 계속 틀리게 나온다.

### 7) 각 계정별 utf-8 인코딩 설정
    - sudo locale-gen ko_KR.EUC-KR ko_KR.UTF-8
    - sudo dpkg-reconfigure locales
    - Home 디렉토리의 .bash_profile에 다음 설정 추가 --> vi .bash_profile 입력하고 enter하면 해당 파일이 생성되고 입력 가능.
      - LANG="ko_KR.UTF-8"
      - LANGUAGE="ko_KR:ko:en_US:en"
    - $ source .bash_profile : 입력한 UTF 설정을 바로 반영할 수 있도록 하는 
    - $ env : 이 명령어를 실행해서 설정을 확인할 수 있다.

## 1-5강 원격 서버에 소스코드 배포하기 2단계
### 참고문서 : https://goo.gl/zuWQ5V
### 1) 자바 설치
    - jdk download로 이동 : Linux x64버전의 jdk 다운로드 URL 링크를 복사한다(http://download.oracle.com/otn-pub/java/jdk/8u181-b13/96a7b8442fe848ef90c96a2fad6ed6d1/jdk-8u181-linux-x64.tar.gz)
    
    - jdk 1.8 인스톨 하는 명령어(https://goo.gl/MKlCv8) : wget --header "Cookie: oraclelicense=accept-securebackup-cookie"
 http://download.oracle.com/otn-pub/java/jdk/8u181-b13/96a7b8442fe848ef90c96a2fad6ed6d1/jdk-8u181-linux-x64.tar.gz
 이게 jdk 다운로드 명령어이다. --header 부분은 라이센스에 동의하는 것을 위한 명령어이다.
 
    - tar.gz 파일 압축 풀기 : $ guzip jdk-8u181-linux-x64.tar.gz 명령어를 입력하여 tar 폴더의 압축을 푼다.
    
    - tar 파일 압축 풀기 : $ tar -xvf jdk-8u181-linux-x64.tar 명령어 입력하여 1개의 tar 파일로 묶여있던 파일들이 모두 압축이 풀린다.
     
    - 심볼릭 링크 지정 : ln -s jdk1.8.0_181/ java  명령어는  jdk 디렉토리를 java라는 별칭을 지어준다는 것으로 보면 됨.
                        결과 : java -> jdk1.8.0_181/
    - 환경변수 추가 : vi .bash_profile에 접속하여 다음의 명령어를 입력하고 저장한다
                     JAVA_HOME=/home/slipp/java    : home의 slipp계정에 java를 설정해준다.
                     PATH=$PATH:$JAVA_HOME/bin     : 기존에 있던 path에 JAVA_HOME이라는 path를 추가해주는 것.
    - bash_profile 반영 : $ source .bash_profile 명령어 입력.
                          $ env로 환경변수 변경된 것 확인 가능
    - java 설치 확인 : $ java -verison 명령어 입력하면 확인 가능.

### 2) git 설치하기
    - Ubuntu에 깃 설치하기 참고 페이지 : https://goo.gl/nM1HSy
    - $ sudo apt-get update : 현재 ubuntu가 관리하고 있는 소프트웨어들의 최신버전들로 업데이터 하는 명령어
    - $ sudo apt-get install git : 시스템 전체 사용자가 깃을 사용할 수 있도록 설치한다.
    - $ git --version : 깃을 설치 후 깃의 버전을 확인할 때 사용하는 명령어
    - $ git clone https://github.com/wwwkang8/spring_boot_jpa.git : 내 원격 서버에 깃의 코드가 복사가 되는 명령어
    - $ ls -al 명령어 -> cd spring_boot_jpa : ls -al 명령어로 클론한 소스폴더에 접근한다.
    - $ chmod +x mvnw : 현재 로그인한 계정에만 실행권한을 부여하는 것(이것을 안하면 permission denied가 뜬다)
    - $ ./mvnw clean package : 지난 시간에 개발한 코드를 그대로 빌드 해준다.
 
### 3) 빌드 이후 서버 띄우기
    - $ cd target : target 폴더로 이동.
    - $ java -jar my-slipp-0.0.1-SNAPSHOT.jar : my-slipp 프로젝트를 서버에 띄워 실행하는 명령어
    - 8080 포트가 기본적으로 막혀있다. 이것을 풀어주는 것을 해야함
    - $ sudo ufw status verbose : 방화벽 상태를 보여주는 명령어. 만약 결과가 "Status: inactive"로 나온다면 $ sudo ufw enable 명령어 입력.
    - 
