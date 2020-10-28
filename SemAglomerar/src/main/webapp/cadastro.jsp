<%-- 
    Document   : cadastro.jsp
    Created on : Oct 18, 2020, 9:06:26 PM
    Author     : dayaprado
--%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <title>Sem Aglomerar</title>
    </head>
    <body>

        <h2>Cadastrar Loja</h2>
        <div class="container">
            <div class="row">
                <label class="label"> 
                    Nome:
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
                <label class="label">Piso:
                    <input name="piso" type="text" value="" />                
                </label>

            </div>
            <div class="row">
                <label class="label">Loja:
                    <input name="loja" type="text" value="" />
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
                    <input name="senha" type="text" value="" />
                </label>
            </div>
            <div class="row">
                <label class="label">Repetir senha:
                    <input name="repetirSenha" type="text" value="" />
                </label>
            </div>
            <div class="row">
                <button>Salvar</button>
            </div>
            <jsp:include page="footer.jsp" />            
        </div>

    </body>
</html>