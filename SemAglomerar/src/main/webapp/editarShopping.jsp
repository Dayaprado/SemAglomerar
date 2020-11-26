<%-- 
    Document   : cadastrarShopping
    Created on : 26/11/2020, 00:41:48
    Author     : carol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <title>Sem Aglomerar</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp" /> 
        <h2>Cadastrar Shopping</h2>
        <div class="container">
            <form method="post" action="/SemAglomerar/formulario-EditarShop">
                <div class="row">
                    <label class="label">Shopping:
                        <input name="nome" type="text" value="" />
                    </label>
                </div>
                <div class="row">
                    <label class="label">Razão Social:
                        <input name="social" type="text" value="" />
                    </label>
                </div>
                <div class="row">
                    <label class="label">CNPJ:
                        <input name="cnpj" type="text" value="" />
                    </label>
                </div>
                <div class="row">
                    <label class="label">Responsável:
                        <input name="loja" type="text" value="" />
                    </label>
                </div>
                 <div class="row">
                    <label class="label">Endereço:
                        <input name="endereco" type="text" value="" />
                    </label>
                </div>
                <div class="row">
                    <label class="label">E-mail:
                        <input name="email" type="text" value="" />                
                    </label>
                </div>
                <div class="row">
                    <label class="label">Telefone:
                        <input name="telefone" type="text" value="" />                
                    </label>
                </div>
                <div class="row">
                    <label class="label">Nome Login:
                        <input name="nomeLogin" type="text" value="" />
                    </label>
                </div>
                <div class="row">
                    <label class="label">Senha:
                        <input name="senha" type="password" value="" />
                    </label>
                </div>
                <div class="row">
                    <label class="label">Repetir senha:
                        <input name="repetirSenha" type="password" value="" />
                    </label>
                </div>
                <div class="row">
                    <a href="resultado.jsp">   
                    <button>Salvar</button>
                    </a>
                </div>
            </form>
        </div>
        <jsp:include page="footer-fixed.jsp" />  
    </form>
    </body>
</html>
