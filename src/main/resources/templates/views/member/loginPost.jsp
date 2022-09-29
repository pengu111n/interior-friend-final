<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/header.jspf" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>로그인</title>
</head>
<body>

<script type="text/javascript">
    self.location = "/mypage/member/get?memno=${login.memno}";
</script>

</body>
</html>

<%@ include file="../include/footer.jspf" %>