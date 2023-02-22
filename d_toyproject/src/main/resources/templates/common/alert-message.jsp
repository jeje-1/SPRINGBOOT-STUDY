<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- medel attribute에 msgㅇ 속성에 담겨온 값을 alert하고,
	redirect 속성에 담겨온 경로로 redirect -->

<script type="text/javascript">
	
	<c:if test="${msg != null}">
		alert("${msg}");
	</c:if>

	loction.href = "${redirect}";

</script>
</body>
</html>