<%-- 
    Document   : inicioAdmin
    Created on : 26/10/2020, 18:02:12
    Author     : carolina Almeida
--%>

<%@page import="java.util.List"%>
<%@page import="semAglomerar.Model.Loja"%>
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
            <form class="search-center" method="post" action="/SemAglomerar/admin-loja">
                <input type="text" name="txtPesquisa" class= "barra-de-pesquisa" placeholder="Pesquisar Lojas" value=""/>
                <% String shop = (String)request.getAttribute("shop_id"); %>
                <input type="hidden" name="shop_id" value="<%= shop %>"/>                
                <button type="submit">Pesquisar</button>
            </form>
            <h3>Olá!</h3>
            <a class="right" href="index.html">Sair</a>
        </div>
        <div id="lateral">
            <a class="left" href="/SemAglomerar/cadastrar-loja?shop_id=<%= shop %>">
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
        <div class="lista-lojas">
            <h2>Lojas</h2>
            <% List<Loja> lojas = (List<Loja>) request.getAttribute("lojas"); %>
            <% for (Loja loja : lojas) { %>
                <div class="card">
                    <!-- <img src="img/lojas/renner.png" alt="Logo Renner" style="width:90px"/> -->
                    <p>
                        <span><%= loja.getNome() %></span> 
                        - <%= loja.getCategoria() %>
                    </p>
                    <p><%= loja.getLocalizacao() %></p>
                    <a class="default-bottom right" href="/SemAglomerar/relatorio?loja_id=<%= loja.getId() %>">                        
                        Movimentação da Loja
                    </a>
                    <a class="right" href="cadastro.jsp">
                        <button>Editar</button>
                    </a>
                    <form method="post" action="/SemAglomerar/admin-loja">
                        <input type="hidden" name="shop_id" value="${shop_id}">
                        <input type="hidden" name="loja_id" value="<%= loja.getId() %>">
                        <input type="hidden" name="action" value="delete"/>
                        <button class="right" id="btnExcluir">Excluir</button>
                    </form>
                </div>
            <% }%>
            <!--
            <div class="card">
                <img src="img/lojas/renner.png" alt="Logo Renner" style="width:90px"/>
                <p><span>Lojas Renner</span> - Vestuário</p>
                <p>Piso Térreo, Loja 02</p>
                <a class="right" href="cadastro.jsp">
                    <button>Editar</button>
                </a>
                <a class="right">
                     <button id="btnExcluir">Excluir</button>
                </a>

            </div>
            <div class="card">
                <img src="img/lojas/cea.png" alt="Logo C&A" style="width:90px"/>
                <p><span>Lojas C&A</span> - Vestuário</p>
                <p>Piso L1, Loja 01</p>
                <a class="right" href="cadastro.jsp">
                    <button>Editar</button>
                </a>
                <a class="right">
                    <button id="btnExcluir">Excluir</button>
                </a>
            </div>
            -->
        </div>
    </div>
    <div id="modalExcluir" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <p>Tem certeza que deseja excluir a loja?</p>
            <a class="right">
                <button id="btnConfirm">Sim</button>
            </a>
            <a class="right">
                <button id="btnCancel">Cancelar</button>
            </a>
        </div>
    </div>
    <jsp:include page="footer-fixed.jsp" />
</body>

<script>
// Get the modal
    var modal = document.getElementById("modalExcluir");

// Get the button that opens the modal
    var btn = document.getElementById("btnExcluir");
    var btnConfirm = document.getElementById("btnConfirm");
    var btnCancel = document.getElementById("btnCancel");

// Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
    btn.onclick = function () {
        modal.style.display = "block";
    }
    btnConfirm.onclick = function () {
        modal.style.display = "none";
        //funcao de exclusao
    }
    btnCancel.onclick = function () {
        modal.style.display = "none";
    }
// When the user clicks on <span> (x), close the modal
    span.onclick = function () {
        modal.style.display = "none";
    }

// When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>

</html>