# 회원과 질문간의 관계 매핑 및 생성일 추가

## 1. Question 객체와 User 객체 관계 매핑
   -  User 관점: User 1명은 여러개의 Question을 할 수 있다. --> @OneToMany 관계
   -  Question 관점 : 반대로 Question은 여러개이면서 1개의 User와 맵핑된다 --> @ManyToOne
![767](https://user-images.githubusercontent.com/26863285/46417204-15ba7b80-c764-11e8-98db-2d2d24425af8.png)

   - Question 클래스는 User 객체를 멤버변수로 가지면서 @ManyToOne 관계를 맺는다.
   - @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
      : Question에 참조되어 있는 User 아이디를 외래키로 가진다.

## 2. LocalDateTime 이용하여 질문 일시 작성하기
   - LocalDateTime 객체를 다음과 같이 Question 객체의 멤버 변수로 생성한다.
   - LocalDateTime.now() : 현재 시간을 불러오는 함수이다.
![local](https://user-images.githubusercontent.com/26863285/46417548-e0faf400-c764-11e8-8fa4-7f707a8016dd.png)
    
   - 날짜 포맷 정하기 : DateTimeFormatter.ofPattern(내가 원하는 시간 포맷) 으로 원하는 날짜 포맷을 정한다.
![fdfdf](https://user-images.githubusercontent.com/26863285/46417729-3d5e1380-c765-11e8-829e-d43f945c0e9c.png)c7b823.png)

   - Index 페이지에서 날짜 보여주기 : getFormattedCreateDate() 메서드가 index 파일의 formattedCreateDate와 맵핑이 된다.
![indextime](https://user-images.githubusercontent.com/26863285/46417878-81511880-c765-11e8-9f03-7fb7e7b3226e.png)
![getfor](https://user-images.githubusercontent.com/26863285/46417946-ab0a3f80-c765-11e8-9c94-586865321d4a.png)
   
   - 다음과 같이 시간이 나타난다.
![34343434](https://user-images.githubusercontent.com/26863285/46418082-f58bbc00-c765-11e8-9162-9c2bdebf6e71.png)
