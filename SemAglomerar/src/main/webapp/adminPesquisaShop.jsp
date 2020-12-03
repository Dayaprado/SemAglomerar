<%-- 
    Document   : admSistema
    Created on : 26/11/2020, 00:21:50
    Author     : carol
--%>

<%@page import="java.util.List"%>
<%@page import="semAglomerar.Model.Shopping"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <title>Sem Aglomerar Administrador do Sistema</title>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <div id="cabecalho">
            <a class="left" href="index.html">
                <img src="img/logo.png" alt="Logotipo da Sem Aglomerar" width=200 height=100>
            </a>
            <form class="search-center" method="post" action="/SemAglomerar/admin-shopping">
                <input class="barra-de-pesquisa" type="text" name="txtPesquisa" placeholder="Pesquisar Shoppings" value=""/>
                <button type="submit">Pesquisar</button>
            </form>
            <h3>Olá Administrador!</h3>
            <a class="right" href="index.html">Sair</a>
        </div>
        <div id="lateral">
            <a class="left" href="/SemAglomerar/cadsatrar-shop">
                <button>Cadastrar Shopping</button>
            </a>
        </div>
        <div class="lista-lojas">
            <h2>Shoppings Cadastrados</h2>
            
            <% List<Shopping> shops = (List<Shopping>) request.getAttribute("shops"); %>
            <% for (Shopping shop : shops) { %>            
                <div class="card">
                    <!-- <img src="img/Shoppings/morumbi.jpg" alt="Logo Shopping Morumbi" style="width:90px"/> -->
                    <p>
                        <span>
                            <a href="/SemAglomerar/admin-loja?shop_id=<%= shop.getId() %>"><%= shop.getNome() %></a>
                        </span>
                    </p>
                    <p><%= shop.getEndereco()%></p>
                    <a class="right" href="editarShopping.jsp">
                        <button>Editar</button>
                    </a>
                    <form method="post" action="/SemAglomerar/admin-shopping">
                        <input type="hidden" name="shop_id" value="<%= shop.getId() %>">
                        <input type="hidden" name="action" value="delete"/>
                        <input type="submit" class="right" value="Excluir"/>
                    </form>
                        
                </div>
            <% }%>
            <!--
            
            <div class="card">
                <img src="img/Shoppings/morumbi.jpg" alt="Logo Shopping Morumbi" style="width:90px"/>
                <p><span><a href="pesquisaLoja.jsp">Shopping Morumbi</a></span></p>
                <p>Endereço:Av. Roque Petroni Júnior, 1089 - Jardim das Acacias, São Paulo - SP, 04707-900</p>
                <a class="right" href="editarShopping.jsp">
                    <button>Editar</button>
                </a>
                <a class="right">
                     <button id="btnExcluir">Excluir</button>
                </a>
            </div>
             <div class="card">
                <img src="img/Shoppings/eldorado.png" alt="Logo Shopping" style="width:90px"/>
                <p><span><a href="pesquisaLoja.jsp">Shopping Eldorado</a></span></p>
                <p>Endereço:Av. Rebouças, 3970 - Pinheiros, São Paulo - SP, 05402-600</p>
                    <a class="right" href="editarShopping.jsp">
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

<script lang="javascript">
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
