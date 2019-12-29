<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>취업지원정보 - 개선의견수렴</title>
<%@ include file="/WEB-INF/views/include/include-title.jspf" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){
	
	$(".news_button").click(function(e){
		alert("등록되었습니다.")
	})
	
	
	
})
</script>
<style>
fieldset div {
	display: flex;
}


fieldset {
	width: 70%;
	border: 1px solid #2f4f4f;
	margin: 20px auto;
}

fieldset div label {
	display: inline-block;
	width: 20%;
	padding: 8px;
	margin: 5px;
	text-align: right;
	vertical-align: center;
}

fieldset div input, fieldset div select, fieldset div textarea {
	display: inline-block;
	width: 70%;
	padding: 8px;
	margin: 5px;
	border: 1px solid #ddd;
}
.news_button_div{
	display:flex;
	justify-content: center;
}

</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-mainnav.jspf" %>
<link rel="stylesheet" href="${rootPath}/css/body.css?ver=20191121001"	type="text/css">
    <section class="news_section">
        <article class="body_title">
            <p>개선의견수렴</p>
        </article>
        <fieldset>
        	<form:form modelAttribute="oDTO">
        	<div>
					<label for="o_title">제목</label>
					<form:input path="o_title" placeholder="제목을 입력해주세요" />
					<br />
				</div>
				<div>
					<label for="o_email">이메일</label>
					<form:input path="o_email" class="in-box"
						placeholder="이메일을 꼭 입력해주세요" />
					<br />
				</div>
				<div>
					<label for="o_content">내용</label>
					<form:textarea path="o_content" rows="20" />
					<br />
				</div>
				<div class="news_button_div">
					<a href="${rootPath}/opinion"><button class="news_button">등록</button></a>
				</div>
				
            </form:form>
            </fieldset>
    </section>
    <%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>