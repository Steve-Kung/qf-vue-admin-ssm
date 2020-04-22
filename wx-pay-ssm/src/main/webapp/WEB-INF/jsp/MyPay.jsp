<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/20
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>支付页面</title>
</head>
<body>
    <h1>支付页面</h1>
    <img src="/doPay" alt="图片没找到">

    <input type="hidden" id="my_channel" value="${my_channel}">

    <%--引入goeasy.js--%>
    <script type="text/javascript" src="https://cdn.goeasy.io/goeasy-1.0.6.js"></script>
    <script>
        <%--console.log(${my_channel});--%>
        var my_channel = document.getElementById("my_channel").value;
        console.log(my_channel); // 2020042100334900001
        console.log(${my_channel});// 2020042100334900000 有点问题
        var goEasy = new GoEasy({
            host:'hangzhou.goeasy.io', //应用所在的区域地址: 【hangzhou.goeasy.io |singapore.goeasy.io】
            appkey: "BC-b5e939205b4146e08f46c49e3f44a5a9", //替换为您的应用appkey
        });
        // 接收消息
        goEasy.subscribe({
            channel: my_channel, //替换为您自己的channel
            onMessage: function (message) {
//                alert("Channel:" + message.channel + " content:" + message.content);
                var result = eval("("+message.content+")");
                console.log(result.msg);
//                console.log(typeof result.msg); // string
                if (result.msg == "支付成功"){
                    location.href='./pay_suc.jsp';
                } else {
                    location.href='./pay_fail.jsp';
                }

            }
        });

    </script>
</body>
</html>
