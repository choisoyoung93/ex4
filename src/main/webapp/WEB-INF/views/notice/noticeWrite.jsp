<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Notice Write Page </h1>
	<form action="notice${path}" method="post">
		<input type="hidden" name="num" value="${boardDTO.num}">
		<p>WRITER: <input type="text" name="writer" value="${boardDTO.writer}"></p>
		<p>TITLE: <input type="text" name="title" value="${boardDTO.title}"></p>
		<p>CONTENTS: <input type="text" name="contents" value="${boardDTO.contents}"></p>
		<button>SUBMIT</button>
	</form>
</body>
</html>