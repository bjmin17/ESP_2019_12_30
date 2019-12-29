<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>취업정책지원사이트</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="${rootPath}/css/main.css?ver=2019-11-30-002">
<script>
$(function(){
	$(".ntitle-list").click(function(){
		let id = $(this).attr("data-id")
		document.location.href = "${rootPath}/news/view?id=" +id
	})
	$(".rtitle-list").click(function(){
		let id = $(this).attr("data-id")
		document.location.href = "${rootPath}/reference/view?id=" +id
	})
})
</script>
</head>
<style>
@charset "UTF-8";
@media screen and (max-width: 978px) {

    html{   
        margin: 0;
        padding: 0;
    }
    ul.notice{
        padding-left: 0 !important;
    }
    article{
        flex-flow: column;
    }
    video{
        margin: 2rem 0 !important;
        width: 100% !important;
        height: 10%;
    }
    #main-menu{
        padding-left: 0 !important;
    }
    table{
      padding: 0 !important;
    }

}


ul.notice {
    margin: 0 ;
    padding-left: 8.5%;    
}
article{
    height: 100%;
    width: 100%;
    display: flex;;
}

video{
    width: 37.5%;
    padding: 1px;
    margin: 0 2rem;
    margin-right: 6.5rem;
    display: inline-block;
    border-radius: 2px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}

/* 공지사항 , 소식 */

body {
	font-family: Arial;
	width: 1200px;
  	margin: 0 auto;
  	
	}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
  background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
  background-color: rgb(47,79,79);
  color: white;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 15px 15px;
  border: 1px solid #ccc;
  border-top: none;
  list-style: none;
  
  width:500px;
  height: 200px;
  text-align: left;
  font-size: 15px;
}
.tabcontent td{
    padding: 0.6rem;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}
.table-box{
	border-collapse: collapse;
	table-layout: fixed;
}
.insert-date{
	width:90px;
}
.ntitle-list{
	text-align: left;
}
.rtitle-list{
	text-align: left;
}
.tabcontent span{
	margin: 0 2rem;
    font-size: 11px;
}
.tabcontent a{
    text-decoration: none;
}

image{
    margin: 10px 0;
}




/* 한번에 보는 정책 정보 */
table{
  margin: 10px 0;
  width: 100%;
}
table,tr {
    padding: 10px 100px;
    font-family: "Malgun gothic","맑은고딕",sans-serif;
}
td {
    text-align: center;
    font-family: "Malgun gothic","맑은고딕",sans-serif;
    padding: 1rem;
    
}
.tr1 #simple-info {
    background-color: darkslategray;
    color: white;
    border: none;
    border-radius: 3px;
}
.tr2 {
    background-color: rgb(209,216,232);
    border-radius: 3px;
}
.tr3 > td {
    width: 1rem;
    background-color: rgb(233,237,247);
    border-radius: 3px;
}
.tr4 > td {
    height: 8rem;
    border: 1px solid grey;
    border-radius: 3px;
    cursor: pointer;
}

</style>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<%@ include file="/WEB-INF/views/include/include-mainnav.jspf" %>
<article>
    <ul class="notice">
        
        <div class="tab">
            <button class="tablinks" onclick="openCity(event, 'noti')" id="defaultOpen">공지사항</button>
            <button class="tablinks" onclick="openCity(event, 'news')">정책소식</button>
            
            
        </div>
        
        <div id="noti" class="tabcontent">
        	<c:choose>
				<c:when test="${empty NLIST}">
					<tr><td colspan="5">정책 자료가 없음</td></tr>
				</c:when>
				<c:otherwise>
					<table class="table-box" border="0">		
						<c:forEach items="${NLIST}" begin="0" end="4" step="1" var="vo">
		                	<tr>
								<td class="ntitle-list" data-id="${vo.n_seq}"><a href="#">${vo.n_title}</a></td>
								<td class="insert-date">${vo.n_date}</td>
							<tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>

        </div>
        
        <div id="news" class="tabcontent">
            <c:choose>
				<c:when test="${empty RLIST}">
					<tr><td colspan="5">정책 자료가 없음</td></tr>
				</c:when>
				<c:otherwise>
					<table class="table-box" border="0">		
						<c:forEach items="${RLIST}" begin="0" end="4" step="1" var="vo">
		                	<tr>
								<td class="rtitle-list" data-id="${vo.d_seq}"><a href="#">${vo.d_title}</a></td>
								<td class="insert-date">${vo.d_date}</td>
							<tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
        </div>
    </ul>
  
  <script>
  function openCity(evt, infoName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(infoName).style.display = "block";
    evt.currentTarget.className += " active";
  }
  
  // Get the element with id="defaultOpen" and click on it
  document.getElementById("defaultOpen").click();
  </script>

<div style="margin-left:10px">
	<iframe width="452" height="281" src="https://www.youtube.com/embed/CmpO6FY2oXo" frameborder="0" allow="accelerometer; autoplay=1; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</div>
	
</article>



<table>
    <tr class="tr1">
        <td id="simple-info" colspan="7">한번에 찾는 정책 정보</td>
    </tr>
    <tr class="tr2">
        <td colspan="5">대상별 정책</td>
        <td colspan="2">지역별 정책</td>
        

    </tr>
    <tr class="tr3">
        <td>청년</td>
        <td>여성</td>
        <td>중장년</td>
        <td>장애인</td>
        <td>외국인</td>
        <td>광역시별</td>
        <td>도시별</td>

    </tr>
    <tr class="tr4">
        <td onClick="location.href='${rootPath}/esp/object'"><img style="height: 3rem;" src="${rootPath}/images/policy_humen1.png"></td>
        <td onClick="location.href='${rootPath}/esp/object/fmmain'"><img style="height: 3rem;" src="${rootPath}/images/policy_humen2.png"></td>
        <td onClick="location.href='${rootPath}/esp/object/mdmain'"><img style="height: 3rem;" src="${rootPath}/images/policy_humen3.png"></td>
        <td onClick="location.href='${rootPath}/esp/object/damain'"><img style="height: 3rem;" src="${rootPath}/images/policy_humen4.png"></td>
        <td onClick="location.href='${rootPath}/esp/object/frmain'"><img style="height: 3rem;" src="${rootPath}/images/policy_humen5.png"></td>
        <td onClick="location.href='${rootPath}/esp/area/seoul'"><img style="height: 100px;" src="${rootPath}/images/g.png"></td>
        <td onClick="location.href='${rootPath}/esp/area/gyeonggi'"><img style="height: 100px;" src="${rootPath}/images/d.png"></td>
    </tr>
</table>
<%@ include file="/WEB-INF/views/include/include-footer.jspf"%>

</body>
</html>