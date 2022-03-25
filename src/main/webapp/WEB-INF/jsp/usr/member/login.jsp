<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="로그인" />

<%@ include file="../common/head.jspf"%>


<form method="POST" action="../member/doLogin">
	<section class="mt-5">
		<div class="container mx-auto px-3">
			<div class="table-box-type-1">
				<table>
					<tr>
						<td><input class="w-full" name="loginId" type="text" placeholder="로그인 아이디" /></td>
					</tr>
					<tr>
						<td><input class="w-full" name="loginPw" type="password" placeholder="비밀번호" /></td>
					</tr>
				</table>
				<div>
					<input class="bg-white hover:underline" type="submit" value="로그인" />
				</div>
				<div>
					<button class="hover:underline" type="button" onclick="history.back();">뒤로가기</button>
				</div>
			</div>
		</div>
	</section>
</form>
</body>
</html>