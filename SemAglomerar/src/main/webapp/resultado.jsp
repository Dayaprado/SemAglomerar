<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tela de confirmação de cadastro</title>
    </head>
    <body>
        <h1>Cadastro Efetuado com sucesso!</h1>
        <h2>Nome da loja: <c:out value="${lojas.nome}"/></h2>
        <p>Você iria receber um email de confirmação no seguinte email:<p>
        <p>E-mail: <c:out value="${responsavels.email}"/></p>    
        <p>Para realizar o acesso utilize o usuario:  <c:out value="${logins.usuario}"/></p>
    </body>
</ht    