<%@ page language="Java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>标题</title>        
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">    
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
 </head>
<form name="form1" action="register.do" method="post">
    <table width="200" border="0">
        <tr>
            <td colspan="2">
                <div id="status">注册新用户</div>
            </td>
        <tr>
            <td>*用户名</td>
            <td><input type="text" name="username" size="10" id="username"></td>
        </tr>
        <tr>
            <td>*密码</td>
            <td><input type="password" name="password1" size="10"></td>
        </tr>
        <tr>
            <td>*确认密码</td>
            <td><input type="password" name="password2" size="10"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" size="10"></td>
        </tr>
        <tr>
            <td colspan="2"><a href="login.jsp">返回登录页</a> <input
                    type="submit" name="submit" value="提交注册"></td>
        </tr>
    </table>
</form>
</html>