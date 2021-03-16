## 망치프로젝트 (스프링 RESTful프로젝트) - 채팅기능 

------

### ▶ 프로젝트 PPT

​	[LINK](https://docs.google.com/presentation/d/1DmOVaqESFTq9CG8V9gJBoi3uH0eRIA_U1siTAqJq2-U/edit#slide=id.g9ae78c4272_5_7)

------

### ▶ 주요 기능

- Ajax를 활용한  서버 - 클라이언트 MSA방식의 통신
- 원페이지 방식
- 무한스크롤을 적용한 페이징
- 채팅방 검색, 삭제
- 채팅 메세지 읽음표시, 개별삭제

------

### ▶  사용 기술

- VIEW : JSP, JSTL
- SERVER : JAVA8
- DATABASE : MySQL, MyBatis
- WAS : Tomcat8
- 배포 : AWS
- Framework : Spring Legacy
- Build : Maven

------

### ▶  설계

◎ 전체 ERD

![erd](https://user-images.githubusercontent.com/63032589/111302276-8b95d180-8696-11eb-87c1-b5c0602c0484.png)

◎ 테이블 정의서

![table](https://user-images.githubusercontent.com/63032589/111302157-6608c800-8696-11eb-9dd4-d4159febc819.png)

------

### ▶  클라이언트 소스

- [전체](https://github.com/seongMinS2/Mangchi-Final)
- 채팅 뷰 페이지(chatting3.js) - [LINK](https://github.com/alikwon/Mangchi-Final/tree/master/Mangch_Client/src/main/webapp/WEB-INF/views/chatting)
- 채팅 js 파일
  - 소켓(socket.js) - [LINK](https://github.com/alikwon/Mangchi-Final/blob/master/Mangch_Client/src/main/webapp/resources/js/kjj/socket.js)
  - 기능(kjj.js) - [LINK](https://github.com/alikwon/Mangchi-Final/blob/master/Mangch_Client/src/main/webapp/resources/js/kjj/kjj.js)

------

### ▶ 채팅 소스 

- [컨트롤러](https://github.com/alikwon/BIT_CAMP/blob/master/Spring_project/Mangch-chat/src/main/java/com/aia/mangch/controller/ChatController.java)
- [Dao](https://github.com/alikwon/BIT_CAMP/blob/master/Spring_project/Mangch-chat/src/main/java/com/aia/mangch/dao/ChatDao.java)  -  [mapper](https://github.com/alikwon/BIT_CAMP/blob/master/Spring_project/Mangch-chat/src/main/webapp/WEB-INF/mapper/ChatDao.xml)
- [Model](https://github.com/alikwon/BIT_CAMP/tree/master/Spring_project/Mangch-chat/src/main/java/com/aia/mangch/model)
- [Service](https://github.com/alikwon/BIT_CAMP/tree/master/Spring_project/Mangch-chat/src/main/java/com/aia/mangch/service)
- [소켓Handler](https://github.com/alikwon/BIT_CAMP/blob/master/Spring_project/Mangch-chat/src/main/java/com/aia/mangch/handler/EchoHandler.java)

------

###  ▶ 시연 동영상

[LINK](https://www.youtube.com/watch?v=47HEWiG-Sws&feature=emb_title) - [동영상에서 채팅 파트](https://www.youtube.com/watch?v=47HEWiG-Sws&t=243s)

------

