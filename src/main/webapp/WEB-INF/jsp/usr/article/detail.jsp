<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 상세보기</title>
</head>
<body>
	<h1>게시물 상세보기</h1>
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
				<td>${article.memberId }</td>
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
		<a href="../article/list">뒤로가기</a>
	</div>
	<div>
		<c:if test="${ article.canDelete }">
			<a
				onclick="if ( confirm('게시물을 삭제하시겠습니까?') == false ) { return false; }"
				href="../article/doDelete?id=${article.id}">게시물 삭제</a>
			<a href="../article/modify?id=${article.id}">게시물 수정</a>
		</c:if>
	</div>
</body>
</html>