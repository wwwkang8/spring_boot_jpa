# 반복주기 4

## 4-6 War 파일로 원격서버에 배포하기

### 1. Jar 파일 대신 War 파일을 배포하는 이유
    - Jar : Java Archeive. 모바일에서는 웹 자원을 관리하지 않고, 데이터만 웹 서버단에서 제공하기 때문에 Jar로 배포
    - War : Web Archeive. 웹 어플리케이션에서는 image, html이 있어서 jar 파일로 배포하면 문제가 발생할 수 있다.
    
### 2. War 파일 배포 dependency 추가 및 프로젝트 설정변경(별도의 톰캣 서버를 사용하기 위한 목적)
    - 구글에 검색 : "spring boot war deploy tomcat" 검색하여 다음 주소로 접속(https://spring.io/guides/gs/convert-jar-to-war/)
    - Packaging executable jar and war files with Maven : https://goo.gl/bjaHG6
    - pom.xml에서 jar -> war로 변경
      <groupId>net.slipp</groupId>
      <artifactId>my-slipp</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <packaging>war</packaging>  <- 요부분에서 jar로 기입된 것을 war로 변경
      
     - tomcat 디펜던시 추가 : 스프링부트에 내장된 톰캣을 사용하지 않고 별도의 톰캣을 사용하겠다고 지정하는 것.
      <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		  </dependency>
      
     - WebInitializer 클래스 추가
     별도의 톰캣을 사용하려면 추가적인 코드가 필요하다. 그래야 외부의 톰캣이 뜨면서 이 프로젝트를 초기화 할 수 있다.
     현재는 Embedded 톰캣을 사용하여 SpringApplication.run() 메서드를 실행하면 my-slipp프로젝트가 자동으로 초기화 되는데, 
     외부의 톰캣에 war 파일로 배포하면 WebInitializer 클래스가 없으면 초기화할 때 문제가 생긴다.
     그래서 다음과 같이 SpringBootServletInitializer를 상속받고, configure 메서드를 오버라이딩한 후 MyApplication 클래스를 초기화 대상으로 지정.
  ![myweb](https://user-images.githubusercontent.com/26863285/46255744-2789ed80-c4dc-11e8-8144-37e47b399d94.png)
  
    - Commit & push : 변경사항을 원격 리포지토리에 push 한다.

### 3. 원격서버에 외부 톰캣 다운로드
    - 원격 서버에 톰캣 다운로드 : Tomcat 공식 홈페이지에서 version 8에 tar.gz의 다운로드 링크주소를 복사하여 다운한다.
      $ wget http://apache.mirror.cdnetworks.com/tomcat/tomcat-8/v8.5.34/bin/apache-tomcat-8.5.34.tar.gz : 톰캣 다운로드 명령어
    - $ tar -xvf apache-tomcat-8.5.34.tar.gz : 메인경로(최상위 위치)에서 tar 파일의 압축을 해제한다.
    - $ ln -s apache-tomcat-8.5.34 tomcat : 심볼릭을 지정한다. apache-tomcat-8.5.34가 tomcat으로 별칭을 가지게 된다.
    - $ cd tomcat/bin : 외장 톰캣의 bin 폴더로 접속한다.
    - $ ./startup.sh : 톰캣을 키는 쉘 파일이다. 이 명령어를 치면 톰캣이 실행된다.
                        IP주소:8080 입력해서 고양이 페이지가 나오면 성공이다.
    - $ ./shutdown.sh : 톰캣 서버를 죽이는 명령어.

### 4. 프로젝트 war파일로 빌드하기
    - ~/spring-boot-jpa$ git pull origin master : spring-boot-jpa 폴더에서 git pull을 해서 원격으로부터 소스코드를 pull 받는다.
    - ~/spring-boot-jpa$ ./mvnw clean package : maven 패키지를 다시 빌드한다.
    - ~/spring-boot-jpa/target$ ls -al : target 폴더에 war 파일로 빌드된 프로젝트를 확인할 수 있다.
    
### 5. 외장 톰캣에 배포하기
    - ~/tomcat/webapps$ : 메인경로(최상위 위치)에서 톰캣의 webapps 폴더로 이동
    - 1개의 톰캣 서버는 여러개의 어플리케이션을 배포할 수 있다. 아래 사진에서는 총 5개의 어플리케이션이 배포되어 있다.
![22](https://user-images.githubusercontent.com/26863285/46255957-0080eb00-c4df-11e8-9f1f-bb631405c2b9.png)
    
    - ~/tomcat/webapps$ rm -rf ROOT/ : 루트 폴더를 삭제하여 기존에 ROOT 폴더에 있는 코드를 없앤다.
      **중요 : 이 ROOT 디렉토리는 IP주소:8080으로 접속하면 바로 ROOT로 접근할 수 있게하는 폴더이다. 이곳에 플젝을 넣을 것이다.
    - ~/spring_boot_jpa/target$ mv my-slipp-0.0.1-SNAPSHOT ~/tomcat/webapps : target 폴더에서 my-slipp-0.0.1프로젝트를 webapps 폴더로 
                                                                               이동하는 명령어.
    - ~tomcat/webapps$ mv my-slipp-0.0.1-SNAPSHOT/ ROOT : ROOT 폴더를 생성하여 my-slipp-0.0.1-SNAPSHOT 프로젝트를 이동.
    ** 이렇게 되면 IP주소:8080 주소를 입력하면 바로 ROOT 디렉토리로 연결되어 프로젝트가 뜬다.
    

### 6. 로그 확인하기
    - ~/tomcat/logs$ tail catalina.out : 톰캣 서버가 뜰 때의 로그파일을 확인할 수 있다.

### 7. 서버 종료
    - ~/tomcat/bin$ ./shutdown.sh : shutdown 쉘 파일이 실행되면 서버가 종료된다.
    
    
    
    
    
