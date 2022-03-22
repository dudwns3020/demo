<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:set var="pageTitle" value="게시물 작성" />

<%@ include file="../common/head.jspf"%>


<form method="POST" action="../article/doAdd">
	<input type="hidden" name="id" value="${article.id }" />
	<table border="1">
		<tbody>
			<tr>
				<th>작성자</th>
				<td><div>${rq.loginedMemberName.name }</div></td>
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
		<input type="submit" value="작성" /> <a href="../article/list">뒤로가기</a>
	</div>
</form>
</body>
</html>