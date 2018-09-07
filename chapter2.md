#Mustache 템플릿 엔진을 이용한 HTML 동적 생성.

### 2-1  mustache 활용한 동적인 HTML과 MVC 설명
     - Controller 생성 : net.slipp.web 패키지 아래 WelcomeController.java 생성.
        - @Controller : 이 클래스가 Controller로서의 역할을 할 수 있도록 권한 부여
     - WelcomeController 메서드 : GetMapping("/helloworld") 맵핑이 되는 메서드 생성한다.
        - View : return "welcome" 으로 하여 welcome.html로 연결될 수 있게 한다.
     - templates 폴더 : Spring Boot는 기본적으로 templates 폴더에서 View 파일을 찾는다.
        - welcome.html : welcome 뷰페이지를 생성한다.
     - 클라이언트 요청 전송(파라미터 포함) : localhost:9090/helloworld?name=javajigi&age=30
        - Controller : model.addAttribute("name",name) 으로 파라메터 저장.
        - welcome.html: {{name}}으로 파라메터를 받는다.
        
### 2-2 회원가입 기능 구현
     - @GetMapping, @PostMapping의 차이
        - @GetMapping : 주로 조회를 할 때 사용한다. URL에 파라메터가 보인다
        - @PostMapping : 서버에 데이터를 변경할 때 사용한다.
     - input tage과 VO의 파라메터 맵핑 : input 태그의 name과 VO의 set 메서드의 이름이 동일해야 파라메터가 맵핑이된다.
        - !! private String name 처럼 인스턴스 변수에 맵핑이 되는 것이 아니다.

### 2-3 사용자 목록 기능 구현


### 2-4 회원가입, 사용자 목록 기능을 원격 서버에 배포하기
     - 서버에 접속하여 변경된 파일들을 pull 받고 다시 빌드 후 배포를 한다.
     - $ cd spring-boot-jpa : 프로젝트가 저장되어 있는 폴더로 이동
     - $ git pull : Github에 최신화된 프로젝트 코드를 서버컴퓨터에서 pull 받아서 최신화 한다.
     - $ ./mvnw clean package : maven을 다시 빌드한다. 
          -프로젝트를 빌드하면 빌드 결과물이 target이라는 디렉토리에서 메이븐으로 관리하게 되어있다.
          - ./mvnw clean : 이 명령어가 기존 target 폴더를 날린다 
          - ./mvnw package : 이 명령어는 maven을 다시 패키징하는 명령어.
          
     - $ java -jar myslipp-0.0.1-SNAPSHOT : 프로젝트를 서버에 띄운다.
     - $ ps -ef : 현재 돌아가는 프로세스의 목록을 나타낸다
     - $ ps -ef | grep java : java 라는 단어를 가지는 프로세스를 찾는다.
     - !! EC2 보안그룹에 9090 포트를 설정했는데 안되고 8080포트만 되는 이유는 무엇일까?
