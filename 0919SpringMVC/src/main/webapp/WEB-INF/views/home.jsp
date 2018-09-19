<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
</head>
<body>
	<table align="center" cellpadding="10px">
		<tr  style="background:#C98FED">
			<th width="100px">아이템번호</th>
			<th width="100px">아이템이름</th>
			<th width="100px">아이템가격</th>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr style="background:#E8D9FF">
				<td align="right">${item.itemid}</td>
				<td><a href="detail?itemid=${item.itemid}">${item.itemname}</a></td>
				<td align="right">${item.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>