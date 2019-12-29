<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">




<link rel="stylesheet" href="${rootPath}/css/header.css?ver=20191121001" type="text/css">
 <link rel="stylesheet" href="${rootPath}/css/mainnav.css?ver=20191121003" type="text/css">
<link rel="stylesheet" href="${rootPath}/css/OBARFooter/footer.css?ver=20191121011" type="text/css">
  <link rel="stylesheet" href="${rootPath}/css/sideMenu/p_sideDistrict.css?ver=20191121009" type="text/css">
    <link rel="stylesheet" href="${rootPath}/css/center/p_allDisSeoulBoard.css?ver=20191121007" type="text/css">

<script>

	var disSideSlideSW = "${disSideSlideSW}"
	var sideColorBold = "${sideColorBold}"
	
	
	

</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src='${rootPath}/js/sideMenu/p_sideDistrict.js?ver=20191121055'></script>
    <script src='${rootPath}/js/center/p_allDisSeoulBoard.js'></script>





<title>취업지원정보 - 지역별 정책</title>
<%@ include file="/WEB-INF/views/include/include-title.jspf" %>
	
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<%@ include file="/WEB-INF/views/include/include-mainnav.jspf" %>
	
	<%@ include file="/WEB-INF/views/include/include-p_sideDistrict.jspf" %>
	<%@ include file="/WEB-INF/views/include/include-p_allDisSeoulBoard.jspf" %>
	
	
	 <%@ include file="/WEB-INF/views/include/include-p_pagination.jspf" %>      
	
	<%@ include file="/WEB-INF/views/include/include-p_footer.jspf" %>
	
</body>
</html>
