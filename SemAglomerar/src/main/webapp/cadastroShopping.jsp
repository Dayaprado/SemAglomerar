<%-- 
    Document   : cadastroShop
    Created on : 09/11/2020, 23:21:58
    Author     : talmeida
--%>

<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <form method="post" action="/SemAglomerar/formulario-salvarShop">
                <div class="row">
                    <label class="label">Shopping:
                        <input name="nome" type="text" value="" />
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
                    <label class="label">Cpf:
                        <input name="cpf" type="text" value="" />
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
                    <a href="resultadoShop.jsp">   
                    <button>Salvar</button>
                    </a>
                </div>
            </form>
        </div>
        <jsp:include page="footer-fixed.jsp" />  
    </form>
</body>
</html>
