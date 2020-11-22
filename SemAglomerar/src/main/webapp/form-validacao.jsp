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
            <form method="post" action="form-validacao-salvar" novalidate>
                <div class="row">
                    <label class="label">Nome da loja:</label>
                    <input name="nome" type="text" value="${nome}" required/>
                    <c:if test ="${nomeErro != null}">
                        <span class="erro"><c:out value="${nomeErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">Razão Social: </label>
                    <input name="social" type="text" value="${social}" required/>
                    <c:if test ="${socialErro != null}">
                        <span class="erro"><c:out value="${nomeErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">CNPJ: </label>
                    <input name="cnpj" type="text" value="${cnpj}" required/>
                    <c:if test ="${cnpjErro != null}">
                        <span class="erro"><c:out value="${nomeErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">Piso:
                        <input name="piso" type="text" value="${piso}" required/>  
                        <c:if test ="${pisoErro != null}">
                            <span class="erro"><c:out value="${nomeErro}" /></span>
                        </c:if>
                    </label>

                </div>
                <div class="row">
                    <label class="label">Categoria:
                        <input name="categoria" type="text" value="" />                
                    <c:if test ="${categoriaErro != null}">
                            <span class="erro"><c:out value="${nomeErro}" /></span>
                        </c:if>
                    </label>
                    

                </div>
                <div class="row">
                    <label class="label">Responsável:
                        <input name="loja" type="text" value="${loja}" required/>
                        <c:if test ="${responsavelErro != null}">
                            <span class="erro"><c:out value="${nomeErro}" /></span>
                        </c:if>
                    </label>

                </div>
                         <div class="row">
                    <label class="label">Cpf:
                        <input name="cpf" type="text" value="" required/>
                     <c:if test ="${cpfErro != null}">
                            <span class="erro"><c:out value="${nomeErro}" /></span>
                        </c:if>
                    </label>
                </div>
                        
                <div class="row">
                    <label class="label">E-mail: </label>
                    <input name="email" type="text" value="${email}" required/>                
                    <c:if test ="${emailErro!= null}">
                        <span class="erro"><c:out value="${emailErro}" /></span>
                    </c:if>
                </div>
                <div class="row">
                    <label class="label">Telefone:
                        <input name="telefone" type="text" value="${telefone}" />   
                        <c:if test ="${telefoneErro != null}">
                            <span class="erro"><c:out value="${nomeErro}" /></span>
                        </c:if>
                    </label>
                </div>
                <div class="row">
                    <label class="label">Nome Login:
                        <input name="nomeLogin" type="text" value="${nomeLogin}" required/>
                        <c:if test ="${nomeLoginErro != null}">
                            <span class="erro"><c:out value="${nomeErro}" /></span>
                        </c:if>
                    </label>
                </div>
                <div class="row">
                    <label class="label">Senha:
                        <input name="senha" type="password" value="" required/>
                        <c:if test ="${nomeLoginErro != null}">
                            <span class="erro"><c:out value="${senhaErro}" /></span>
                        </c:if>
                    </label>
                </div>
                <div class="row">
                    <label class="label">Repetir senha:
                        <input name="repetirSenha" type="password" value="" required/> 
                        <c:if test ="${nomeLoginErro != null}">
                            <span class="erro"><c:out value="${senhaErro}" /></span>
                        </c:if>
                    </label>
                </div>
                <div class="row">
                    <button>Salvar</button>
                 </a>
                </div>
            </form>
        </div>
        <jsp:include page="footer-fixed.jsp" />  
    </form>

</body>
</html>