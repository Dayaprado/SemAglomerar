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
            <form class="search-center" method="post" action="/SemAglomerar/pesquisa-shopping">
                <input type="text" name="txtPesquisa" class= "barra-de-pesquisa" placeholder="Pesquisar Shoppings" value=""/>
                <a href="pesquisaShop.jsp">   
                    <img src="img/036-zoom.png" alt="Procurar" width=15 height=15 />
                </a>
            </form>
            <a class="right" href="index.html">Sair</a>
        </div>
        </div>
        <div class="lista-shopping">
            <h2>Shoppings</h2>
            <div class="card">
                <p><span><c:out value="${shopping.nome}"/></span></p>
            </div>
        </div>
    </div>
    <jsp:include page="footer-fixed.jsp" />
</body>
</html>