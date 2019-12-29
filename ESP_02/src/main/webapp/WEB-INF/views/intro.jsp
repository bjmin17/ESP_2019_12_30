<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>취업지원정보 - 사이트 소개</title>
<%@ include file="/WEB-INF/views/include/include-title.jspf" %>
<link rel="stylesheet" href="${rootPath}/css/body.css?ver=20191121001" type="text/css">
<link rel="stylesheet" href="${rootPath}/css/table.css?ver=20191121001" type="text/css">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<%@ include file="/WEB-INF/views/include/include-mainnav.jspf" %>
	
	<section class="news_section">
        <article class="body_title">
            <p> 사이트 소개 </p>
        </article>
        <div class="body_content">
        	<h2>이 페이지는 취업을 지원하는 정책들을 보여주는 페이지입니다.</h2>
        	<br/><br/>
        	<h2>● 대상별 정책</h2>
        	<p>취업을 지원하는 정책들을 대상에 따라 보여주는 페이지
        	<h2>● 지역별 정책</h2>
        	<p>취업을 지원하는 정책들을 지역에 따라 보여주는 페이지
        	<h2>● 소식</h2>
        	<p>소식들을 보여주는 페이지
        	<h2>● 정책자료실</h2>
        	<p>정책과 관련된 자료들을 보여주는 페이지
        </div>
    </section>
	<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
	
</body>
</html>
