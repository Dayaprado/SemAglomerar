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
        <div class="container" style="margin-bottom: 35px;">
            <form method="post" action="/SemAglomerar/cadastrar-shop" novalidate>
                <div class="row">
                    <label class="label">Shop.:
                        <input name="nome" type="text" value="${nome}" />

                        <c:if test="${nomeErro != null}">
                            <p class="erro"><c:out value="${nomeErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">CNPJ:
                        <input name="cnpj" type="text" value="${cnpj}" />

                        <c:if test="${cnpjErro != null}">
                            <p class="erro"><c:out value="${cnpjErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">Endereço:
                        <input name="endereco" type="text" value="${endereco}" />

                        <c:if test="${enderecoErro != null}">
                            <p class="erro"><c:out value="${enderecoErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">Responsável:
                        <input name="loja" type="text" value="${loja}" />

                        <c:if test="${shoppingErro != null}">
                            <p class="erro"><c:out value="${ShoppingErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">Cpf:
                        <input name="cpf" type="text" value="${cpf}" />

                        <c:if test="${cpfErro != null}">
                            <p class="erro"><c:out value="${cpfErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">E-mail:
                        <input name="email" type="text" value="${email}" />

                        <c:if test="${emailErro != null}">
                            <p class="erro"><c:out value="${emailErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">Telefone:
                        <input name="telefone" type="text" value="${telefone}" />       

                        <c:if test="${telefoneErro != null}">
                            <p class="erro"><c:out value="${telefoneErro}" /></p>
                        </c:if> </label>
                </div>
                <div class="row">
                    <label class="label">Nome Login:
                        <input name="nomeLogin" type="text" value="${nomeLogin}" />

                        <c:if test="${nomeLogin != null}">
                            <p class="erro"><c:out value="${nomeLoginErro}" /></p>
                        </c:if> </label>
                </div>
                <div class="row">
                    <label class="label">Senha:
                        <input name="senha" type="password" value="" />
                        <c:if test="${senhaErro != null}">
                            <p class="erro"><c:out value="${senhaErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">Repetir senha:
                        <input name="repetirSenha" type="password" value="" />

                        <c:if test="${repetirSenhaErro != null}">
                            <p class="erro"><c:out value="${repetirSenhaErro}" /></p>
                        </c:if> </label>
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
