# spring_boot_jpa
자바지기 박재성님의 유튜브 강좌로 혼자 부트, JPA 독학


## 2강 : Boostrap 활용한 html 페이지 개발
1) bootstrap Jar 파일 다운로드 : 인터넷에서 받아올 수도 있지만 프로젝트 내부에 jar파일로 다운하는 방법도 있다
  - jar 파일 찾는 방법 : mvnrepository(메이븐)에서 찾고자 하는 jar 파일을 검색한다.
  - pom.xml dependency 추가 : 메이븐 디펜던시를 pom.xml에 추가한다.
  - 외부 URL을 내부 URL로 경로 변경 : resources에서부터 찾아들어간다.
    ex) resources(생략)/webjars/bootstrap/3.3.7-1/css/파일 명
    
2) Bootstrap에서 필요한 Component 끌어다 쓰기
   - form 형태 : https://getbootstrap.com/docs/4.1/components/forms/
   - Navbar 코드 : https://getbootstrap.com/docs/4.1/examples/navbars/

