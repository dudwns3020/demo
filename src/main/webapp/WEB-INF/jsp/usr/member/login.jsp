<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="로그인" />

<%@ include file="../common/head.jspf"%>


	<form method="POST" action="../member/doLogin">
		<table>
			<tr>
				<td><input name="loginId" type="text" placeholder="로그인 아이디" /></td>
			</tr>
			<tr>
				<td><input name="loginPw" type="text" placeholder="비밀번호" /></td>
			</tr>
		</table>
		<div>
			<input type="submit" value="로그인" />
		</div>
		<hr />
		<div>
			<button type="button" onclick="history.back();">뒤로가기</button>
		</div>
	</form>
</body>
</html>