<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="${board.name }" />

<%@ include file="../common/head.jspf"%>

<section class="mt-5">
	<div class="container mx-auto px-3">
		<div class="table-box-type-1">
			<table border=1>
				<thead>
					<tr>
						<th>번호</th>
						<th>작성날짜</th>
						<th>수정날짜</th>
						<th>제목</th>
						<th>작성자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="article" items="${articles }">
						<tr>
							<td>${article.id }</td>
							<td>${article.regDate.substring(2,16) }</td>
							<td>${article.updateDate.substring(2,16) }</td>
							<td><a href="../article/detail?id=${article.id }">${article.title }</a></td>
							<td>${article.writerName }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<c:if test="${rq.loginedMemberId ne '0'}">
			<a class="hover:underline" href="../article/write">게시물 작성</a>
		</c:if>
		<div class="center">
			<c:if test="${page ne '1' }">
				<a class="hover:underline" href="/usr/article/list?page=1">◁</a>&nbsp;
				<a class="hover:underline" href="/usr/article/list?page=${page-1 }">◀</a>&nbsp;
			</c:if>
			${page}&nbsp;&nbsp;/&nbsp;&nbsp;${pageCount }&nbsp;
			<c:if test="${page ne pageCount }">
				<a class="hover:underline" href="/usr/article/list?page=${page+1 }">▶</a>
				<a class="hover:underline"
					href="/usr/article/list?page=${pageCount }">▷</a>
			</c:if>
		</div>
	</div>
</section>




</body>
</html>