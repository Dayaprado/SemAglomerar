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
        <h2>Login:</h2>
        <div class="container">
            <form method="post" action="/SemAglomerar/formulario-salvar">
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
                <div class="row">
                    <button>Entrar</button>
                </div>
            </form>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>
