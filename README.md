# Spring Boot 기술서
## 목차
- 기술 스택
- 기능 설명
	- 메인 페이지
	- 회원
		- 회원 가입
		- 로그인
		- 로그아웃
	- 게시물
		- 리스트
		- 상세보기
		- 게시물 작성
		- 게시물 삭제
		- 게시물 수정
## 기술 스택
- JDK 16.0.1
- Tomcat
- Lombok
- Servlet / JSP
- MariaDB
- JDBC
- JAVA
- HTML
- CSS
- JavaScript

## 개발 툴
- STS
- SQLYog
- Maven
- Git, Github
- Visual Studio Code
- Chrome
- Windows 10
## 기능 설명
### 메인 페이지
- 메인페이지

<img src="https://user-images.githubusercontent.com/68069311/160420021-4bd18d35-4ee5-4135-aefd-6be97227099d.png" width="full" height="full" >

home.jsp

<img src="https://user-images.githubusercontent.com/68069311/160420659-82e84acb-be37-4d40-8a6d-e94669ca523c.png" width="full" height="full" >

head.jsp

<img src="https://user-images.githubusercontent.com/68069311/160420628-373e93b1-2742-4d0f-ad19-3905100bfe07.png" width="full" height="full" >

usrHomeController.java

<img src="https://user-images.githubusercontent.com/68069311/160420700-309a12c3-afd1-4df7-be38-8aa38e8cb2e0.png" width="full" height="full" >


### 회원

member.java

<img src="https://user-images.githubusercontent.com/68069311/160419717-0876dd26-9e34-49ec-9bd5-5876c7c94170.png" width="full" height="full" >

- 회원 가입

<img src="https://user-images.githubusercontent.com/68069311/160420936-0c5d440f-4d3a-4c82-b133-88b44b8c3691.png" width="full" height="full" >

join.jsp

<img src="https://user-images.githubusercontent.com/68069311/160421397-146c8090-c848-4641-be1e-2a442cbfe336.png" width="full" height="full" >

UsrMemberController.java

<img src="https://user-images.githubusercontent.com/68069311/160421457-7f22c72e-f6db-49c0-8395-f243e7fec7e2.png" width="full" height="full" >

memberService.java

<img src="https://user-images.githubusercontent.com/68069311/160421506-c94c75cc-e82d-4f88-8e53-d7fa76a0d4de.png" width="full" height="full" >

memberRepository.java

<img src="https://user-images.githubusercontent.com/68069311/160421545-ec617cb2-9853-4dc1-bc51-af1bcc022eac.png" width="full" height="full" >

- 로그인
 
<img src="https://user-images.githubusercontent.com/68069311/160421589-042d8b8d-0eec-4b4d-8147-b59ad2a91988.png" width="full" height="full" >
<img src="https://user-images.githubusercontent.com/68069311/160421637-c903bf2b-7479-48a4-b898-89ef8885d88c.png" width="full" height="full" >

login.jsp

<img src="https://user-images.githubusercontent.com/68069311/160421664-3d91f693-a49d-4193-9fc0-7c5406de245b.png" width="full" height="full" >

UsrMemberController.java

<img src="https://user-images.githubusercontent.com/68069311/160421708-8cb4de31-bdf7-4ac5-8acf-ac251cfc418d.png" width="full" height="full" >

- 로그아웃

<img src="https://user-images.githubusercontent.com/68069311/160421775-a2c96015-0ccd-4682-b550-74c13b739252.png" width="full" height="full" >
<img src="https://user-images.githubusercontent.com/68069311/160421887-371802a4-380b-4b8f-aa57-565ac103e9cc.png" width="full" height="full" >

UsrMemberController.java

<img src="https://user-images.githubusercontent.com/68069311/160421916-79c8dcfc-8250-462e-ad98-a7e0e7a37ab1.png" width="full" height="full" >


### 게시물

article.java

<img src="https://user-images.githubusercontent.com/68069311/160419575-fcba6b8f-51f6-4f64-90cc-6ff0931628ec.png" width="full" height="full" >

- 리스트

<img src="https://user-images.githubusercontent.com/68069311/160285203-ecec38e8-3dc4-4e32-91ce-ffb9d1a116ac.png" width="full" height="full" >

list.jsp

<img src="https://user-images.githubusercontent.com/68069311/160285021-14814c0e-6b86-4a54-800a-1fe115d96659.png" width="full" height="full" >

UsrArticleController.java

<img src="https://user-images.githubusercontent.com/68069311/160284190-228eb84f-4327-4514-98b8-589a138a4260.png" width="full" height="full" >

articleService.java

<img src="https://user-images.githubusercontent.com/68069311/160285048-35d478a2-edee-495d-b368-c8158ae6e314.png" width="full" height="full" >

articleRepository.java

<img src="https://user-images.githubusercontent.com/68069311/160284912-f36ec471-e864-43ea-9150-ae273c861daa.png" width="full" height="full" >

articleRepository.xml

<img src="https://user-images.githubusercontent.com/68069311/160284956-ce8ff21d-0998-4b33-b161-19861dcf9d1a.png" width="full" height="full" >

- 상세보기

detail.jsp

<img src="https://user-images.githubusercontent.com/68069311/160410141-d5c9cb7a-6b99-4b3d-b31e-805a7c10f1f6.png" width="full" height="full" >

UsrArticleController.java

<img src="https://user-images.githubusercontent.com/68069311/160410207-4cd5f097-073c-4084-a451-f09a13877a35.png" width="full" height="full" >

articleService.java

<img src="https://user-images.githubusercontent.com/68069311/160410259-39c73c09-fe01-416c-9d50-6676cf621726.png" width="full" height="full" >

articleRepository.java

<img src="https://user-images.githubusercontent.com/68069311/160412045-b808bcf5-748d-443f-b842-e593ecaacff1.png" width="full" height="full" >

articleRepository.xml

<img src="https://user-images.githubusercontent.com/68069311/160412118-6dbd2970-540d-4bc9-bf51-f183ff6e02f4.png" height="full" >

   
- 게시물 작성

<img src="https://user-images.githubusercontent.com/68069311/160415104-ee314040-a239-43c8-9ea3-352e08174a9f.png" width="full" height="full" >
<img src="https://user-images.githubusercontent.com/68069311/160422879-2ac89cd2-26c5-44ad-8cd9-e8e09d038a27.png" width="full" height="full" >

write.jsp

<img src="https://user-images.githubusercontent.com/68069311/160414150-efc21756-f917-4199-8f2f-523b1e48ca62.png" width="full" height="full" >

UsrArticleController.java

<img src="https://user-images.githubusercontent.com/68069311/160414097-c0b3471e-2b4d-4436-9542-afc861a4d6ef.png" width="full" height="full" >

articleService.java

<img src="https://user-images.githubusercontent.com/68069311/160414183-8fb1e3ec-855f-4023-a5ec-0ed7fcb064de.png" width="full" height="full" >

articleRepository.java

<img src="https://user-images.githubusercontent.com/68069311/160414350-3e1eba26-96ae-4c8b-8c97-d8124aa2570f.png" width="full" height="full" >

articleRepository.xml

<img src="https://user-images.githubusercontent.com/68069311/160414391-ae3f194f-2f65-48d9-b803-93e18eeac986.png" height="full" >

- 게시물 삭제

<img src="https://user-images.githubusercontent.com/68069311/160412415-1529f24b-8ea2-4f6c-b9bd-40cc46b6d341.png" width="full" height="full" >
<img src="https://user-images.githubusercontent.com/68069311/160412776-29197627-bcb0-47bc-94a8-e3dc0fee92ca.png" width="full" height="full" >

UsrArticleController.java

<img src="https://user-images.githubusercontent.com/68069311/160413002-fba6acab-eba5-4087-9c19-efe35841e13c.png" width="full" height="full" >

articleService.java

<img src="https://user-images.githubusercontent.com/68069311/160413045-bc8a7368-4868-4a1e-a508-b18550c9d3c6.png" width="full" height="full" >

articleRepository.java

<img src="https://user-images.githubusercontent.com/68069311/160413097-e2de5940-1472-40a1-b927-1f4ea725fcb6.png" width="full" height="full" >

articleRepository.xml

<img src="https://user-images.githubusercontent.com/68069311/160413135-80d18e0a-2811-4f78-9d8b-83175c8b2ed5.png" height="full" >

- 게시물 수정

<img src="https://user-images.githubusercontent.com/68069311/160413267-16b1b2c9-87cb-45ed-ac9a-2c179ca4b60c.png" width="full" height="full" >
<img src="https://user-images.githubusercontent.com/68069311/160422884-18c2371e-cd19-4952-b8bf-81a24c2bbbab.png" width="full" height="full" >

modify.jsp

<img src="https://user-images.githubusercontent.com/68069311/160413331-8fd6ee80-581d-4766-8a0c-125181fd96b8.png" width="full" height="full" >

UsrArticleController.java

<img src="https://user-images.githubusercontent.com/68069311/160413287-84382d2d-991b-4289-bcf1-f3a97ef20715.png" width="full" height="full" >

<img src="https://user-images.githubusercontent.com/68069311/160413467-99cf54d1-3777-4662-a482-d9dd82e9575e.png" width="full" height="full" >

articleService.java

<img src="https://user-images.githubusercontent.com/68069311/160413549-8e6a67d5-a802-44af-a763-fd1528f6fe56.png" width="full" height="full" >

articleRepository.java

<img src="https://user-images.githubusercontent.com/68069311/160413587-1a9d1a1a-d071-47f4-b412-efb460024d84.png" width="full" height="full" >

articleRepository.xml

<img src="https://user-images.githubusercontent.com/68069311/160413626-cefeb992-efda-475d-9254-f846aa9472c4.png" height="full" >
