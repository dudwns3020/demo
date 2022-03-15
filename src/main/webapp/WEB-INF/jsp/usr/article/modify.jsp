<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 수정" />

<%@ include file="../common/head.jspf"%>


	<form method="POST" action="../article/doModify">
		<input type="hidden" name="id" value="${article.id }" />
		<table border="1">
			<tbody>
				<tr>
					<th>번호</th>
					<td>${article.id }</td>
				</tr>
				<tr>
					<th>작성날짜</th>
					<td>${article.regDate.substring(2,16) }</td>
				</tr>
				<tr>
					<th>수정날짜</th>
					<td>${article.updateDate.substring(2,16) }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${article.memberId }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input name="title" type="text" value="${article.title }"
						placeholder="제목을 입력해주세요" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><input name="body" type="text" value="${article.body }"
						placeholder="내용을 입력해주세요" /></td>
				</tr>
			</tbody>
		</table>
		<div>
			<input type="submit" value="수정" />
			<%--<button type="button" onclick="history.back();">뒤로가기</button>--%>
			<a href="../article/detail?id=${article.id }">뒤로가기</a>
		</div>
	</form>
</body>
</html>