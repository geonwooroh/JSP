<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "join_db.jsp" name = "joinForm" method = "post">
		<p id = "text">사용할 수 있는 아이디입니다.</p>
		<p>
			<label>
				아이디: <input type = "text" name = "userid"/>
				 <input type = "button" value = "중복확인" onclick=""/>
			</label>
		</p>
		<p>
			<label>
				비밀번호:<input type = "password" name = "userpw"/>
			</label>
		</p>
		<p>
			<label>
				비밀번호 확인 :<input type = "password" name = "userpw_re"/>
			</label>
		</p>
		<p>
			<label>
				이름 :<input type = "password" name = "username"/>
			</label>
		</p>
		<p>
			성별<br/>
			<label>남자<input type = "radio" name = "usergender" value = "M" checked></label>
			<label>여자<input type = "radio" name = "usergender" value = "W"></label>
		</p>
		<p>
			<label>
				휴대폰번호 :<input type = "password" name = "userphone"/>
			</label>
		</p>
		<P>
			우편번호
		</P>
		<P>
			주소
		</P>
		<P>
			상세주소
		</P>
		<P>
			참고항목
		</P>
		<P>
			<input type = "button" value = "가입완료" onclick = "sendit();"/>
		</P>
	</form>
	<script src = "user.js"></script>
</body>
</html>