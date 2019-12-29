<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>취업지원정보 - 이용약관</title>
<%@ include file="/WEB-INF/views/include/include-title.jspf" %>
	
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-mainnav.jspf" %>
<link rel="stylesheet" href="${rootPath}/css/body.css?ver=20191121001"	type="text/css">
<link rel="stylesheet" href="${rootPath}/css/table.css?ver=20191121001"	type="text/css">
    <section class="news_section">
        <article class="body_title">
            <p>이용안내</p>
        </article>
        <article class="news_info_use">
            <ul>
                <li>지원 브라우저</li>
                <p>익스플로러11, 엣지, 크롬</p>
                <li>화면 해상도</li>
                <p>1200px</p>
                <li>폰트</li>
                <p>맑은 고딕</p>
            </ul>
        </article>          
    </section>
    <%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>