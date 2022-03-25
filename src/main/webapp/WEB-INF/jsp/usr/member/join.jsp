<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="pageTitle" value="회원 가입" />

<%@ include file="../common/head.jspf"%>


<form method="POST" action="../member/doJoin">
	<section class="mt-5">
		<div class="container mx-auto px-3">
			<div class="table-box-type-1">
				<table border="1">
					<tbody>
						<tr>
							<th>아이디</th>
							<td><input name="loginId" type="text" /></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input name="loginPw" type="password" /></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><input name="name" type="text" /></td>
						</tr>
					</tbody>
				</table>
				<div>
					<input class="bg-white hover:underline" type="submit" value="회원가입" />
				</div>
				<div>
					<button class="hover:underline" onclick="history.back();">뒤로가기</button>
				</div>
			</div>
		</div>
	</section>
</form>
</body>
</html>