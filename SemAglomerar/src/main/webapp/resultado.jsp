<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp" />

        <title>Confirmação de cadastro</title>
    </head>
    <body>
        <div id="cabecalho">
            <a>
                <img src="img/home_img.jpg" alt="Logotipo da Sem Aglomerar" width=200 height=200>
            </a>
        </div>

        <h2>Cadastro Efetuado com sucesso</h2>

        <div class="container">
            <div class="row">
                <label class="label">Nome da loja:<c:out value="${lojas.nome}"/>
                    <input name="nome" type="text" value="" />
                    <c:out value="${lojas.nome}"/>
                </label>
            </div>
            <br/>
            <br/>
            <h3>Lojista irá receber uma confirmaçao no seguinte email:</h3>
            <div class="row">
                <label class="label">Email:<c:out value="${responsavels.email}"/>
                    <input name="email" type="text" value="" />
                    <c:out value="${lojas.nome}"/>
                </label>
            </div>
            <br/>
            <div class="row">
                <h3> Lojista recebeu o email?</h3>                 
                <button style="float: none">Sim</button>
                <button style="float: none">Nao</button>
            </div>
            <br/>            
            <h3>Para realizar o acesso utilize o usuario:</h3>
            <div id="row">
                <a>
                    <img src="img/icon_usuario.png" alt="Imagem de usuario" width=100 height=100>
                </a>
                <div class="row">
                    <label class="label">Usuario:<c:out value="${logins.usuario}"/>
                        <input name="acesso" type="text" value="" />
                        <c:out value="${lojas.nome}"/>

                    </label>
                    <a href="inicioAdmin.jsp">
                        <button style="float: none">Salvar</button>
                    </a>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>  