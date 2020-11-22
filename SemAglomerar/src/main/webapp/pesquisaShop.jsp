<%-- 
    Document   : pesquisaShop
    Created on : 22/11/2020, 16:37:00
    Author     : carol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <title>Sem Aglomerar - Resultado de Pesquisa</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="cabecalho">
            <a class="left" href="index.html">
                <img src="img/logo.png" alt="Logotipo da Sem Aglomerar" width=200 height=100>
            </a>
            <form class="search-center">
                <input class="barra-de-pesquisa" type="text" id="txtPesquisa" placeholder="Pesquisar Shoppings" value=""/>
                <button type="submit">Pesquisar</button>
            </form>
            <h3>Olá!</h3>
            <a class="right" href="index.html">Sair</a>
        </div>
        </div>
        <div class="lista-shopping">
            <h2>Shoppings</h2>
            <div class="card">
                <img src="img/Shoppings/morumbi.jpg" alt="Logo Shopping Morumbi" style="width:90px"/>
                <p><span><a href="pesquisaLoja.jsp">Shopping Morumbi</a></span></p>
                <p>Endereço:Av. Roque Petroni Júnior, 1089 - Jardim das Acacias, São Paulo - SP, 04707-900</p>
            </div>
            <div class="card"> 
                    <img src="img/Shoppings/eldorado.png" alt="Logo Shopping Eldorado" style="width:90px"/>
                <p><span><a href="pesquisaLoja.jsp">Shopping Eldorado</a></span></p>
                <p>Endereço:Av. Rebouças, 3970 - Pinheiros, São Paulo - SP, 05402-600</p>
            </div>
        </div>
    </div>
    <jsp:include page="footer-fixed.jsp" />
</body>
</html>