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
            <form method="post" action="/SemAglomerar/formulario-salvarShop" novalidate>
                <div class="row">
                    <label class="label">Shopping:</label>
                        <input name="nome" type="text" value="${nome}" />
                        <c:if test="${nomeErro != null}">
                        <span class="erro"><c:out value="${nomeErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">CNPJ:</label>
                        <input name="cnpj" type="text" value="${cnpj}" />
                      <c:if test="${cnpjErro != null}">
                        <span class="erro"><c:out value="${cnpjErro}" /></span>
                      </c:if>
                </div>
                <div class="row">
                    <label class="label">Endereço:</label>
                    <input name="endereco" type="text" value="${endereco}" />
                    <c:if test="${enderecoErro != null}">
                        <span class="erro"><c:out value="${enderecoErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">Responsável:</label>
                        <input name="loja" type="text" value="${loja}" />
                          <c:if test="${lojaErro != null}">
                        <span class="erro"><c:out value="${lojaErro}" /></span>
                    </c:if>
                </div>
                 <div class="row">
                    <label class="label">Cpf:</label>
                        <input name="cpf" type="text" value="${cpf}" />
                      <c:if test="${cpfErro != null}">
                        <span class="erro"><c:out value="${cpfErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">E-mail:</label>
                        <input name="email" type="text" value="${email}" />                
                      <c:if test="${emailErro != null}">
                        <span class="erro"><c:out value="${emailErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">Telefone:</label>
                        <input name="telefone" type="text" value="${telefone}" />                
                      <c:if test="${telefoneErro != null}">
                        <span class="erro"><c:out value="${telefoneErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">Nome Login:</label>
                        <input name="nomeLogin" type="text" value="${nomeLogin}" />
                      <c:if test="${nomeLogin != null}">
                        <span class="erro"><c:out value="${nomeLoginErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">Senha:</label>
                        <input name="senha" type="password" value="" />
                      <c:if test="${senhaErro != null}">
                        <span class="erro"><c:out value="${senhaErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">Repetir senha:</label>
                        <input name="repetirSenha" type="password" value="" />
                    <c:if test="${repetirSenhaErro != null}">
                        <span class="erro"><c:out value="${repetirSenhaErro}" /></span>
                    </c:if>
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
