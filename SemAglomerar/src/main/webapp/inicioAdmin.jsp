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
    </head>

    <body>
        <div id="cabecalho">
            <a href="index.html">
                <img src="img/logo.png" alt="Logotipo da Sem Aglomerar" width=200 height=100>
            </a>
            <p>Olá, Administrador!</p>
            <a href="index.html">Sair</a>
        </div>

        <fieldset>
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

        <div id="conteudo">
             <form>
                <input type="text" id="txtPesquisa" placeholder="Pesquisar Shoppings" value=""/>
                <button type="submit">Pesquisar</button>
            </form>
            <a href="cadastro.jsp">
                <button>Cadastrar Loja</button>
            </a>
        </div>
        <div id="lojas">
            <h2>Lojas Renner</h2>
            
        </div>
        <div id="rodape">
            <p>© Todos os direitos reservados | contato@semaglomerar | Termos de Serviço| Política de Privacidade</p>
        </div>        
    </body>
</html>