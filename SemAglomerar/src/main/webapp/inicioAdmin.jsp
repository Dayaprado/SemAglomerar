<%-- 
    Document   : inicioAdmin
    Created on : 26/10/2020, 18:02:12
    Author     : carolina Almeida
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <title>Sem Aglomerar Administrador</title>
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
        <div id="lateral">
            <a class="left" href="cadastro.jsp">
                <button>Cadastrar Loja</button>
            </a>
            <fieldset class="filtro">
                <legend>Escolha por Categorias</legend>
                <div>
                    <input type="checkbox" id ="artigosDoLar" name="artigosDoLar">
                    <label for="artigosDoLar">Artigos do Lar</label>
                </div>
                <div>
                    <input type="checkbox" id ="alimentacao" name="alimentacao">
                    <label for="alimentacao">Alimentação</label>
                </div>
                <div>
                    <input type="checkbox" id ="vestuario" name="vestuario">
                    <label for="vestuario">Vestuário</label>
                </div>
                <div>
                    <input type="checkbox" id ="calcados" name="calcados">
                    <label for="calcados">Calçados</label>
                </div>
                <div>
                    <input type="checkbox" id ="servicosEssenciais" name="servicosEssenciais">
                    <label for="servicosEssenciais">Serviços Essenciais</label>
                </div>
                <div>
                    <input type="checkbox" id ="beleza" name="beleza">
                    <label for="beleza">Beleza</label>
                </div>
                <div>
                    <input type="checkbox" id ="outros" name="outros">
                    <label for="outros">Outros</label>
                </div>
            </fieldset>
        </div>
        <div id="lojas">
            <h2>Lista de Lojas</h2>
            
        </div>
        <jsp:include page="footer-fixed.jsp" />
    </body>
</html>