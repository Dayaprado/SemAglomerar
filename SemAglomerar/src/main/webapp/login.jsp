<%-- 
    Document   : login.jsp
    Created on : Oct 19, 2020, 2:44:42 PM
    Author     : crisdut
--%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp" />

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
        <title>Sem Aglomerar Login</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" /> 
        <h2>Login:</h2>
        <div class="container">
            <form method="post" action="/SemAglomerar/login">
                <div class="row">
                    <label class="label"> 
                        Login:
                        <input name="login" type="text" value="" />
                    </label>
                </div>
                <div class="row">
                    <label class="label">Senha:
                        <input name="senha" type="password" value="" />
                    </label>
                </div>
                <div class="row">
                    <button type="submit">Entrar</button>
                </div>
            </form>
            
            <div>
                </br></br></br></br></br></br>
                <p>Ainda não é nosso parceiro? </p>
                    <a href="cadastroShopping.jsp"><h5>Cadastre-se </h5></a>
                </p>
            </div>
        </div>
        <jsp:include page="footer-fixed.jsp" />
    </body>
</html>
