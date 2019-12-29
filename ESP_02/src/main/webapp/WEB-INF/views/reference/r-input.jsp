<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>취업정보모음 - 정책자료실 - 추가</title>
<link rel="stylesheet" href="${rootPath}/css/body.css?ver=20191121001" type="text/css">
<%@ include file="/WEB-INF/views/include/include-title.jspf"%>
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

</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
	<%@ include file="/WEB-INF/views/include/include-mainnav.jspf"%>
	<section class="news_section">
		<article class="body_title">
			<p>정책자료실</p>
		</article>
		<fieldset>
			<form:form modelAttribute="referenceDTO" class="ref-form">
				<div>
					<label for="d_title">제목</label>
					<form:input path="d_title" class="in-box" placeholder="제목을 입력해주세요" />
					<br />
				</div>
				<div>
					<label for="d_file">첨부파일</label>
					<form:input path="d_file" class="in-box"
						type="file"
						placeholder="첨부파일 있으면 추가해주세요" />
					<br />
				</div>
				<div>
					<label for="d_content">내용</label>
					<form:textarea path="d_content" rows="20" />
					<br />
				</div>
				<div class="news_button_div">
					<button class="news_button">저장</button>
				</div>
			</form:form>
		</fieldset>
	</section>

	<%@ include file="/WEB-INF/views/include/include-footer.jspf"%>
</body>
</html>