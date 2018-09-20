<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
<style>
h3:hover {
	color: blue;
}

span {
	margin: 10px;
	border: 3px solid green;
	border-radius: 15px;
	float: left;
	width: 200px;
	height: 80px;
	text-align: center;
}
</style>
</head>
<body>

	<div>
		<form action="#" method="get">
			<div id="msg"></div>

			아이디 <input type="text" id="id" /><br /> 비밀번호 <input type="password"
				id="pw" /><br /> <input type="submit" value="회원가입" id="idcheck"/>

		</form>

	</div>




	<a href="excel.xls">엑셀로 출력 </a>
	<br />
	<br />
	<a href="data.pdf">pdf로 출력 </a>
	<br />
	<br />
	<a href="jsonview.json">JSON으로 출력 </a>
	<br />
	<br />



	<a href="data.csv">CSV 가져오기</a>
	<br />
	<a href="data.json">JSON 출력</a>
	<br />
	<a href="#" id="ajaxsend">AJAX로 JSON 가져오기</a>
	<br />


	<div id="disp"></div>


	<table align="center" cellpadding="10px">
		<tr style="background: #C98FED">
			<th width="100px">아이템번호</th>
			<th width="100px">아이템이름</th>
			<th width="100px">아이템가격</th>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr style="background: #E8D9FF">
				<td align="right">${item.itemid}</td>
				<td><a href="detail?itemid=${item.itemid}">${item.itemname}</a></td>
				<td align="right">${item.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script>
	document.getElementById("ajaxsend").addEventListener("click", function() {

		$.ajax({
			url : "data.json",
			data : {},
			dataType : "json",
			success : function(data) {
				output = "";
				for (imsi in data) {
					output += "<span><h3>";
					output += data[imsi].name + "</h3>";
					output += "<p>" + data[imsi].group;
					output += "</p></span>";
				}
				document.getElementById("disp").innerHTML = output;
			}
		});
	});

	var ids = document.getElementById("id");
	var msg = document.getElementById("msg");
	ids.addEventListener("blur", function() {
		$.ajax({
			url : "idcheck",
			data : {
				"id" : ids.value
			},
			dataType : "json",
			success : function(data) {
				if (data.result == "true") {
					msg.innerHTML = "사용 가능한 아이디입니다.";
					msg.style.color="blue";
				} else {
					msg.innerHTML = "중복된 아이디입니다. 다시 입력해주세요.";
					msg.style.color="red";
				}

			}
		});
	});
	
	
	
	
	var idcheck = document.getElementById("idcheck");
	
	idcheck.addEventListener("click",function(){
		$.ajax({
			url : "idcheck",
			data : {
				"id" : ids.value
			},
			dataType : "json",
		

				success : function(data) {
					if (data.result == "true") {
						alert("사용가능한 아이디");
					} else {
				alert("중복된 아이디");
					}
			}
		});
	});
</script>
</html>