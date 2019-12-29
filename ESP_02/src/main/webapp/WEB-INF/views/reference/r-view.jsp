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
<title>취업지원정보 - 정책자료실 세부사항</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<%@ include file="/WEB-INF/views/include/include-title.jspf" %>
<link rel="stylesheet" href="${rootPath}/css/body.css?ver=20191121001" type="text/css">
<link rel="stylesheet" href="${rootPath}/css/table.css?ver=20191121001" type="text/css">
<style>
#rcontent{
	white-space: pre-line;
}

</style>
</head>

<script>
$(function(){
	$("#btn-update").on("click",function(){
		
		document.location.href = "${rootPath}/reference/update?id=${rDTO.d_seq}"
		
	})
	
	$("#btn-delete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			let query = "${rootPath}/reference/delete?d_seq=${rDTO.d_seq}"
			document.location.replace(query)
		}
	})
})

</script>
<body>
	<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
	<%@ include file="/WEB-INF/views/include/include-mainnav.jspf" %>
	
	<section class="news_section">
        <article class="body_title">
            <p> 정책자료실 </p>
        </article>
        <article class="news_detail">
            <table border="1">
                <tr>
                    <th>제목</th>
                    <td colspan="3">${rDTO.d_title}</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>${rDTO.d_writer}</td>
                    <th>등록일</th>
                    <td>${rDTO.d_date}</td>
                </tr>
            </table>
            <div id="rcontent">
				${rDTO.d_content}
            </div>
            <table border="1">
                <tr class="news_detail_file">
                    <th>첨부파일</th>
                    <td>${rDTO.d_file}</td>
                </tr>
            </table>
            <article class="news_page_button">
                <a href="javascript:void(0)" class="btn" id="btn-update"><button>수정</button></a>
                <a href="javascript:void(0)" class="btn" id="btn-delete"><button>삭제</button></a>
                <a href="${rootPath}/reference/rlist?searchField=&search="><button>목록</button></a>
            </article>
        </article>
    </section>
	<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
	
</body>
</html>
