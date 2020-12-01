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
            <form method="post" action="/SemAglomerar/formulario-EditarLoja" novalidate>
                <div class="row">
                    <label class="label">Nome da loja:</label>
                    <input name="nome" type="text" value="${nome}" />
                    <c:if test="${nomeErro != null}">
                        <span class="erro"><c:out value="${nomeErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">Razão Social: </label>
                    <input name="social" type="text" value="${social}" />
                    <c:if test="${socialErro != null}">
                        <span class="erro"><c:out value="${socialErro}" /></span>
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
                    <label class="label">Localização:</label>
                    <input name="piso" type="text" value="${piso}" />                
                    <c:if test="${pisoErro != null}">
                        <span class="erro"><c:out value="${pisoErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">Categoria:</label>
                    <input name="categoria" type="text" value="${categoria}" />                
                    <c:if test="${categoriaErro != null}">
                        <span class="erro"><c:out value="${categoriaErro}" /></span>
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
                    <c:if test="${cpf != null}">
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
                    <c:if test="${nomeLoginErro != null}">
                        <span class="erro"><c:out value="${nomeLoginErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">Senha:</label>
                    <input name="senha" type="password" value="${senha}" />
                    <c:if test="${senhaErro != null}">
                        <span class="erro"><c:out value="${senhaErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">Repetir senha:</label>
                    <input name="repetirSenha" type="password" value="${repetirSenha}" />
                    <c:if test="${repetirSenhaErro != null}">
                        <span class="erro"><c:out value="${repetirSenhaErro}" /></span>
                    </c:if>
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
