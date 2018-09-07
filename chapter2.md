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


### 2-4 
