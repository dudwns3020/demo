<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 상세보기" />

<%@ include file="../common/head.jspf"%>

	<table border=1>
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
				<td>${article.writerName }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${article.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${article.body }</td>
			</tr>
		</tbody>
	</table>
	<div>
		<c:if test="${ article.canDelete }">
			<a
				onclick="if ( confirm('게시물을 삭제하시겠습니까?') == false ) { return false; }"
				href="../article/doDelete?id=${article.id}">게시물 삭제</a>
			<a href="../article/modify?id=${article.id}">게시물 수정</a>
		</c:if>
	</div>
	<div>
		<%--<button type="button" onclick="history.back();">뒤로가기</button>--%>
		<a href="../article/list">뒤로가기</a>
	</div>
</body>
</html>