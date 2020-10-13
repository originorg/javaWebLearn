<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%

    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String rememberMe = request.getParameter("rememberMe");
    String message = "错误";
    if("user".equals(userName))
    {
        if("123".equals(password))
        {
            message="登录成功" ;
            if("on".equals(rememberMe))
            {
                //记住登录状态
                Cookie cookie1 = new Cookie("userName", userName);
				cookie1.setMaxAge(7*24*60*60);
				response.addCookie(cookie1);

                Cookie cookie2 = new Cookie("password", password);
				cookie2.setMaxAge(7*24*60*60);
				response.addCookie(cookie2);
                message+="(已记录登录状态)" ;
            }


        }
        else{

          
            message="密码错误";
            
        }
    }else{
            
                message= "用户名错误";

    }
%>


<html>

<head>
    <style>
        body {
            padding: 0;
            margin: 0;
            background-color: #fefefe;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        
        .container {
            width: 340px;
            height: auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid gainsboro;
        }
        
        .container .d1 {
            color: darkgoldenrod;
            font-size: 25px;
            width: 100%;
            margin: 15px 28px;
        }
        
        .container .d2 {
            font-size: 13px;
            width: 100%;
            margin: 15px 28px;
        }
        
        .container .registerForm {
            width: 80%;
            height: auto;
            border: 1px dotted #0e0e0e;
            padding: 0 20px;
            margin: 15px auto;
            padding: 40px 5px;
            padding-top: 5px;
            position: relative;
        }
        
        .registerForm .title {
            font-size: 12px;
            padding: 2px;
            color: #fff;
            background-color: darkgoldenrod;
            width: 100px;
            margin-left: 10px;
            margin-top: -12px;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        
        .registerForm span {
            margin: 10px;
            color: #000;
            display: flex;
            align-items: center;
            justify-content: flex-start;
            flex-wrap: nowrap;
        }
        
        .registerForm span div {
            font-size: 12px;
            width: 50px;
            padding: 0 5px;
            text-align: right;
        }
        
        .registerForm div {
            width: 100%;
            font-size: 12px;
            padding-left: 50px;
            display: flex;
        }
        
        .registerForm .registerBtn {
            background-color: darkgoldenrod;
            border: none;
            border-radius: 5px;
            color: #fff;
            padding: 5px 18px;
            font-size: 12px;
            position: absolute;
            right: 10px;
            bottom: 5px;
        }
    </style>
</head>

<body>
        <div class="container">
            <div class="d1">用户登录</div>
            <div class="d2">欢迎登录</div>
            <form class="registerForm" action="checkLogin.jsp">
                <div class="title">登录</div>
                <span>用户名: <%=userName%></span>
                <span>密码:<%=password%></span>
                <span>状态:<%=message%></span>
                <span>
                <a style="color: goldenrod" href="./login.jsp">返回登录</a>
                </span>
            </form>
        </div>
</body>

</html>



