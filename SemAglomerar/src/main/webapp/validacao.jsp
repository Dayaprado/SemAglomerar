<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <title>Login inválido!</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" />  
        </br><h2>Login inválido!</h2>
        
        <div class="container">
            <div class="row">
                <label class="label"><b>Usuário ou Senha inválido.</b>                   
                </label>
                </br></br><a href="login.jsp">   
                    <button>Tente Novamente</button>
                </a>
            </div>
        </div>
        <jsp:include page="footer-fixed.jsp" />
    </body>
</html>
