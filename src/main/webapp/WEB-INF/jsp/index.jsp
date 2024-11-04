<%@page contentType="text/html;charset=UTF-8"%>

<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="fn" uri="jakarta.tags.functions"%>

<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<h1>Список заметок</h1>
	<ul>
		<%--@elvariable id="notes" type="java.util.List"--%>
		<c:forEach var="note" items="${notes}">
			<%--@elvariable id="note" type="by.vsu.jt_example.domain.Note"--%>
			<c:choose>
				<c:when test="${note.done}">
					<c:set var="cls" value="done"/>
				</c:when>
				<c:otherwise>
					<c:remove var="cls"/>
				</c:otherwise>
			</c:choose>
			<li class="${cls}">
				<span class="date"><fmt:formatDate value="${note.date}" pattern="d MMMM yyyy"/></span>,
				${note.title}
			</li>
		</c:forEach>
	</ul>
	<p>Заметок всего: ${fn:length(notes)} шт.</p>
</body>
</html>