<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<!-- form 에서 action이 생략되면 현재 URL로 전송  -->
<form method="post">

아이디 <input type="text" name="id"  /><br />
비밀번호 <input type="password" name="pw"   /><br />
<input type="submit"  value="로그인" />
</form>

</body>
</html>