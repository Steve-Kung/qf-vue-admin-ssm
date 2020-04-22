<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/20
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello jsp</h1>
${msg}
<input type="text" id="hello" value="${msg}">
<script>
    var hello = document.getElementById("hello").value;
    console.log(hello);
    console.log(${msg});

    var one = "支付成功";
    if (one == "支付成功"){
        location.href='./pay_suc.jsp';
        <%--location.href='${pageContext.request.contextPath}/hello';--%>
    } else {
        location.href='./pay_fail.jsp';
    }

</script>
</body>
</html>
