<%-- 
Document   : cadastro.jsp
Created on : Oct 18, 2020, 9:06:26 PM
Author     : dayaprado
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
        <h2>Cadastrar Loja</h2>
        <div class="container">
            <form method="post" action="/SemAglomerar/cadastrar-loja" novalidate>
                <div class="row">
                    <label class="label">Nome da loja:
                        <input name="nome" type="text" value="${nome}" />
                        <c:if test="${nomeErro != null}">
                            <p class="erro"><c:out value="${nomeErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">Raz�o Social:
                        <input name="social" type="text" value="${social}" />
                        <c:if test="${socialErro != null}">
                            <p class="erro"><c:out value="${socialErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">CNPJ:
                        <input name="cnpj" type="text" value="${cnpj}" />
                        <c:if test="${cnpjErro != null}">
                            <p class="erro"><c:out value="${cnpjErro}" /></p>
                        </c:if>
                </div>
                <div class="row">
                    <label class="label">localiza��o:
                        <input name="piso" type="text" value="${localizacao}" />                
                        <c:if test="${localizacaoErro != null}">
                            <p class="erro"><c:out value="${localizacaoErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">Categoria:
                        <input name="categoria" type="text" value="${categoria}" />                
                        <c:if test="${categoriaErro != null}">
                            <p class="erro"><c:out value="${categoriaErro}" /></p>
                        </c:if>
                    </label>
                </div>
                <div class="row">
                    <label class="label">Respons�vel:
                        <input name="loja" type="text" value="${loja}" />
                        <c:if test="${lojaErro != null}">
                            <p class="erro"><c:out value="${lojaErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">Cpf:
                        <input name="cpf" type="text" value="${cpf}" />
                        <c:if test="${cpf != null}">
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
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">Nome Login:
                        <input name="nomeLogin" type="text" value="${nomeLogin}" />
                        <c:if test="${nomeLoginErro != null}">
                            <p class="erro"><c:out value="${nomeLoginErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">Senha:
                        <input name="senha" type="password" value="${senha}" />
                        <c:if test="${senhaErro != null}">
                            <p class="erro"><c:out value="${senhaErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <label class="label">Repetir senha:
                        <input name="repetirSenha" type="password" value="${repetirSenha}" />
                        <c:if test="${repetirSenhaErro != null}">
                            <p class="erro"><c:out value="${repetirSenhaErro}" /></p>
                        </c:if></label>
                </div>
                <div class="row">
                    <a href="resultado.jsp">   
                        <button>Salvar</button>
                    </a>
                </div>
                <input name="shop_id" type="hidden" value="${shop_id}" />
            </form>
        </div>
        <jsp:include page="footer-fixed.jsp" />  
    </form>

</body>
</html>
