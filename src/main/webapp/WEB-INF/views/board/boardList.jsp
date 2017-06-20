<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	var m = '${message}';
	if(m != ''){
		alert(m);
	}
</script>
<style type="text/css">
	a{
		text-decoration: none;
		color: black;
	}
</style>
</head>
<body>
	<h1 align="center"> ${board} List </h1>
	
	<div>
		<form action="">
			<select name="search">
				<option value="writer">WRITER</option>
				<option value="title">TITLE</option>
				<option value="contents">CONTENTS</option>
			</select>
			<input type="text" name="find">
			<input type="submit" value="SEARCH" class="btn btn-default">
		</form>
	</div>
	
	<table class="table table-striped">
      <thead>
      	<tr>
         <th width="50px">NUM</th><th style="text-align: center;">TITLE</th><th width="100px">WRITER</th><th width="100px">DATE</th><th width="50px">HIT</th>
         </tr>
       </thead>
       <tbody>
          <c:forEach items="${ boardList }" var="dto">
            <tr>
               <td>${ dto.num }</td>
               <td>
               		<c:catch>
               		<c:forEach begin="1" end="${dto.depth}" var="i">
               			&nbsp;&nbsp;
               			<%-- <c:if test="${i eq 1}"></c:if> --%>
               			<c:if test="${i eq dto.depth}">└RE:</c:if>
               		</c:forEach>
               		
               		</c:catch>
               		<a href="${board}View?num=${ dto.num }" style="color: black; text-decoration: none;">${ dto.title }</a>
               	</td>
               <td>${ dto.writer }</td>
               <td>${ dto.reg_date }</td>
               <td>${ dto.hit }</td>
            </tr>
         </c:forEach>
      </tbody>
     </table>

	<a href="${board}Write" class="btn btn-default">Write</a>
	
</body>
</html>