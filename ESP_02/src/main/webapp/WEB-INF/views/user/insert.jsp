<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function(){

	// js 함수는 1급함수다 : 함수 = 객체 = 변수
	// 새로운 방식, 함수 = 객체
	// let idcheck = function() {  }
	
	// 새창을 열어서 id를 검사하는 코드를 함수로 선언하기
	// 표준함수 선언 방식
	function idcheck() {
		let top = 500 
		let left = 600 
			
		// alert("Enter 입력")
		let u_id = $("#u_id").val()
		let status = "toolbar=no,"
		status += "scrollbars=yes,"
		status += "resizable=no,"
		status += "top=300,"
		status += "left=400,"
		status += "width=600,"
		status += "height=200"
			
		if(u_id == "") {
			alert("ID를 입력한 후 Enter")
			return false
		}
			
		openWin = window.open("${rootPath}/user/idcheck?u_id=" + u_id,
				"_blank",
				status)
	}
	
	$("#u_id").keypress(function(e){
		if(e.keyCode == 13) {
			// 표준, 일반적으로 함수를 호출하는 방법
			idcheck()	
		}
	})
	
	// event hander에 함수목록을 등록하는 절차
	// 이때는 함수 마치 객체처럼 등록이 되기때문에
	// 함수이름에 ()를 넣지 말아야한다.
	// 함수방식을 call back 함수 등록이다라고 한다.
	$("#id_check").click( idcheck )
	
	$("#btn-save").click(function(){
		let id = $("#u_id").val()
		if(id == ""){
			alert("아이디는 반드시 입력해야합니다")
			$("#u_id").focus()
			return false
		}
		
		let pass = $("#u_password").val()
		if(pass == "") {
			alert("비밀번호는 반드시 입력해야합니다")
			$("#u_password").focus()
			return false
		}
		
		let re_pass = $("#re_password").val()
		if(re_pass == "") {
			alert("비밀번호를 한번 더 입력해 주세요")
			$("#re_password").focus()
			return false
		}
		
		if(pass != re_pass) {
			alert("비밀번호와 비밀번호확인이 일치하지 않습니다\n"
					+ "다시 입력해 주세요")
			$("#u_password").val("")
			$("#re_password").val("")
			$("#u_password").focus()
			return false
		}
		
		let u_name = $("#u_name").val()
		if(u_name == "") {
			alert("이름은 반드시 입력해야 합니다")
			$("#u_name").focus()
			return false;
		}
		
		let mail = $("#email").val()
		if(mail == "") {
			alert("이메일은 반드시 입력해야 합니다")
			$("#email").focus()
			return false;
		}
		// $(form).submit()
		// $(window)
		$("form").submit()
	})
	
})
</script>
  
</head>
<style>
body {
	background-color: rgb(245, 246, 247);
}

.join {
	width: 410px;
	position: absolute;
	left: 50%;
	top: 45%;
	transform: translate(-50%, -50%);
}


.join h4 {
	margin-bottom: 4px;
}

.join input {
	width: 90%;
	height: 30px;
	font-size: 14px;
	padding: 0 15px;
	margin-top: 3px;
}

#btn-save {
	background-color: rgb(47, 79, 79);
	color: white;
	width: 98.8%;
	height: 30px;
	margin-top: 10px;
	cursor: pointer;
	font-size: 12px;
	padding: 0px 15px;
}

#btn-save:hover {
	font-weight: bold;
}
.idc{
	margin-top:3px;
	padding:5px;
	background-color: rgb(47, 79, 79);
	color:white; 
}
</style>
<body>
<section class="join">
	<form:form modelAttribute="userDTO" autocomplete="on" class="user-form">

		<h4>아이디 <strong style="color:red">*</strong></h4>
		<form:input type="text" path="u_id" id="u_id" class="in-box" placeholder="아이디를 입력하세요" />
		<button type="button" id="id_check" class="idc">아이디검사</button>
		<br/>

		<h4>비밀번호 <strong style="color:red">*</strong></h4>
		<form:input type="password" path="u_password" id="u_password" class="in-box"
			placeholder="비밀번호를 입력하세요" />
		<br />
		
		<input type="password" id="re_password" placeholder="비밀번호를 한번더 입력하세요">
		<br />
		
		<h4>이름 <strong style="color:red">*</strong></h4>
		<form:input path="u_name" class="in-box" id="u_name" placeholder="이름을 입력하세요" />
		<br />
		
		<h4>이메일 <strong style="color:red">*</strong></h4>
		<form:input type="email" path="u_email" id="email" class="in-box"
			placeholder="이메일을 입력하세요" />
		<br />

		<h4>주소</h4>
		<form:input path="u_addr" class="in-box" placeholder="주소를 입력하세요" />
		<br />

		<h4>전화번호</h4>
		<form:input path="u_tel" type="tel" class="in-box"
			placeholder="전화번호를 입력하세요" />
		<br />
		<button type="button" id="btn-save">저장</button>
	</form:form>
</section>
</body>
</html>