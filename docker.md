# docker container를 실행하기 위한 환경 

## Docker란 무엇인가?
  - 도커는 로컬 노트북, 데스크탑에 별도의 운영체제를 설치할 수 있는 공간을 만드는 가상화 머신이다. 
    이 가상화 머신은 자기만의 IP 주소를 가지고, 여러 운영체제를 설치할 수 있다.

## 1. Docker Tool Box 설치
   - 링크 : https://docs.docker.com/toolbox/toolbox_install_windows/
   - 설치 : 윈도우 운영체제는 DockerToolbox.exe를 실행한다. 디폴트 설정으로 인스톨 하면된다
            내 노트북에는 D 드라이브->Programfiles 폴더에 Toolbox를 설치하였다.
   - 명령어
      1) docker-machine : 물리적인 가상화 PC를 제어할 때 사용하는 명령어
      2) docker : 해당 가상 머신 안에서 운영체제를 제어할 때 사용하는 명령어
 
 ## 2. Docker machine 사용
    - Terminal에서 docker 사용 : Terminal에서 "docker-machine"이라고 커맨드를 치면 명령어 옵션 목록이 나열된다.
    - docker-machine ls : 생성된 도커 머신의 목록을 보여주는 명령어이다. 없다면 목록에 아무것도 뜨지 않는다.
    - docker-machine create --driver virtualbox 머신이름 : 
      도커 머신을 생성하는 커맨드이다. virtualbox라는 머신을 생성하고 이름은 임의로 작성하면 된다
    - docker-machine ls : 생성된 도커머신 목록이 뜬다.
    - docker-machine ip : 도커머신의 아이피 주소를 확인할 수 있다.
    - docker-machine env 머신이름 : 해당 머신의 환경정보를 확인할 수 있다.
    - docker images : 로컬에 있는 도커 이미지 목록을 보여준다. 없다면 뜨지 않는다.
    - eval $(docker-machine env default) : 도커머신 이미지 목록을 보여줄 수 있게하는 커맨드이다.
    위 명령어는 Windown 터미널에서는 작동하지 않아서 git-bash에서 커맨드를 입력하여 작동시켰다.
 ![eval](https://user-images.githubusercontent.com/26863285/46289401-f5ec5180-c5c3-11e8-951e-f7910820508d.png)
 
    - docker pull ubuntu : 우분투를 관리하는 원격저장소에서 최신 우분투 이미지를 받아오는 커맨드
 ![docker pull ubuntu](https://user-images.githubusercontent.com/26863285/46289465-1fa57880-c5c4-11e8-9322-751aca4e72b5.png)
 
    - docker run --name jwp ubuntu : 우분투 운영체제를 실행시키는 커맨드. 하지만 다른 것을 실행시키면 자동으로 종료된다.
    - docker rm jwp : jwp 이미지 삭제
    - docker run -dit --name jwp ubuntu : 데몬으로 이미지를 실행시킨다. 그래서 다른 프로세스를 실행해도 종료되지 않음
    - docker stop jwp : jwp 이미지 종료.
    - docker start jwp : jwp 이미지 실행.
    - docker exec -it jwp /bin/bash : jwp 우분투에 접속하는 커맨드인데, 윈도우에서는 작동되지 않는다.
      **해결책: $ winpty docker exec -it jwp //bin//sh : 이 명령어를 git bash를 이용해서 입력하면 윈도우에서도 우분투 운영체제에 접속할 수 있다.
      (해결 링크 : https://goo.gl/JgeS31)
 ![default](https://user-images.githubusercontent.com/26863285/46289765-f20cff00-c5c4-11e8-973d-56329d02a156.png)
 
 
 
 
 # docker ubuntu 한글버전 생성 및 자바 설치
  
 ## 1. ubuntu 한글 버전 설치
    - $ vi Dockerfile : Dockerfile 생성.
    - Docker 파일에 코드입력 : https://goo.gl/xd1rz2 이곳에서 도커파일 관련 코드 복사해서 붙여넣고 wq!
    - $ docker-machine restart : 도커 머신을 다시 시작
    - $ docker build --tag ko_ubuntu:latest ./  : 이렇게해서 최신 우분투 버전 가져온다
    - !! 데몬 뭐시기 나오면 : eval $(docker-machine env 이미지이름) 실행
    - $ docker images : 새로 생긴 ko_ubuntu 이미지를 확인할 수 있다.
 ![docker images](https://user-images.githubusercontent.com/26863285/46330525-460ff600-c64e-11e8-9afb-2d357c8020ea.png)
 
    - $ winpty docker run -it --name ko_ubuntu ko_ubuntu //bin//sh : ko_ubuntu 라는 이름의 이미지를 docker 컨테이너에 생성하고
        이것을 실행하여 bash shell에 접속한다는 커맨드
    - # locale : 우분투 운영체제에 접속하여 "locale" 입력하면 한글 설정이 된 것을 확인할 수 있다.
    - # exit : exit 커맨드로 우분투 운영체제 이미지에서 나올 수 있다.
    - $ docker ps -a : 현재 도커 컨테이너의 프로세스 목록 볼 수 있다.
 ![default](https://user-images.githubusercontent.com/26863285/46330480-1d87fc00-c64e-11e8-997c-ba96bdbfb4ba.png)
    
    - $ docker start ko_ubuntu : ko_ubuntu 이미지 실행
    - $ winpty docker exec -it ko_ubuntu //bin//sh : ko_ubuntu에 데몬으로 접속하는 커맨드
![start](https://user-images.githubusercontent.com/26863285/46330482-1e209280-c64e-11e8-88a2-ab17a5e97f0a.png)
    
 ## 2. docker 이미지 삭제 및 다시 생성
    - $ docker stop ko_ubuntu : 기존에 실행되고 있는 ko_ubuntu 이미지를 종료한다.
    - $ docker rm ko_ubuntu : ko_ubuntu 이미지를 삭제한다.
    - $ winpty docker run -dit --name my-slipp ko_ubuntu :
      1) -dit : -dit 옵션은 이미지 생성 후 바로 실행시키는 옵션이다
    - $ winpty docker exec -it my-slipp //bin//sh : 데몬으로 my-slipp 이미지 실행
![ko_ubuntu my-slipp](https://user-images.githubusercontent.com/26863285/46330598-a7d06000-c64e-11e8-93d2-97afccb3ecc1.png)
    
 ## 3. 자바 설치
    - my-slipp 이미지에 접속한 상태에서 해야한다.
    - $ cd usr : usr 폴더로 이동
    - $ mkdir apps : usr 폴더 내부에 apps 라는 폴더 생성
    - $ apt-get install wget : wget 명령어를 설치
    12:50분부터 다시 듣기
 
 
 
 
 
 
 
 
 
 
 
 
    
