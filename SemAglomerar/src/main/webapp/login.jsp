<%-- 
    Document   : login.jsp
    Created on : Oct 19, 2020, 2:44:42 PM
    Author     : crisdut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
        <title>Sem Aglomerar Login</title>
    </head>
    <body>
        <h2>Login</h2>
        <div class="container">
            <div class="row">
                <label class="label"> 
                    Login:
                    <input name="login" type="text" value="" />
                </label>
            </div>
            <div class="row">
                <label class="label">Senha:
                    <input name="senha" type="text" value="" />
                </label>
            </div>
            
    </body>
</html>
