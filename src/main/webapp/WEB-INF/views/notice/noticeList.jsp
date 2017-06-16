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
</head>
<body>
	<h1> Notice List Page </h1>
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
               <td style="text-align: center;"><a href="noticeView?num=${ dto.num }">${ dto.title }</a></td>
               <td>${ dto.writer }</td>
               <td>${ dto.reg_date }</td>
               <td>${ dto.hit }</td>
            </tr>
         </c:forEach>
      </tbody>
     </table>

	<a href="noticeWrite">Write</a>
</body>
</html>