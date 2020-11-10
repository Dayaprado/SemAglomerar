<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp" />

        <title>Confirmação de cadastro</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" />  

        <h2>Cadastro Efetuado com Sucesso!</h2>
        <h5>Agora é só esperar que entraremos em contato para poder validar a conta e você começar a usar a plataforma :)</h5>

        <div class="container-2">
            <div class="row">
                <label class="label"><b>Nome do Shopping:</b>
                    <div class="conteudo"><c:out value="${shoppings.nome}"/></div>
                </label>                
            </div>
            <div class="row">
                <label class="label"><b>Email:</b>
                    <div class="conteudo"><c:out value="${responsavels.email}"/></div>
                </label>                
            </div>
            <div id="row">
                <div class="row">
                    <label class="label"><b>Usuario:</b>
                        <div class="conteudo"><c:out value="${logins.usuario}"/></div>
                    </label>
                </div>
            </div>

            <div class="row">
                <h3> Recebeu o email de confirmação?</h3>  
                
                <a href="login.jsp">   
                    <button style="float: none">Sim</button>
                </a>
            </div>
            <br/>            
        </div>
        <jsp:include page="footer-fixed.jsp" />
    </body>
</html>  