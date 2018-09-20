<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
</head>
<body>
	<div align="center" class="body">
		<h2>상품 상세보기</h2>
		<table>
			<tr>
			<!-- img 링크 걸 때 앞에 / 하면 서버에서 시작 img/로 시작  -->
				<td><img src="img/${item.pictureurl}" /></td>
				<td align="center">
					<table>
						<tr height="50">
							<th width="80">상품명</th>
							<td width="160">${item.itemname}</td>
						</tr>
						<tr height="50">
							<th width="80">가격</th>
							<td width="160">${item.price}</td>
						</tr>
						<tr height="50">
							<th width="80">비고</th>
							<td width="160">${item.description}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" width="240"><a href="./">목록으로
						돌아가기 </a></td>
			</tr>
		</table>
	</div>
</body>
</html>