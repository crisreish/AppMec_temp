<%--
  Created by IntelliJ IDEA.
  User: usuário
  Date: 25/09/2021
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>APPMEC - Confirmação!</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

    <form action="/pedido" method="get">
        <button type="submit" class="btn btn-link">Incluir</button>
    </form>

    <hr>

    <c:if test="${not empty msg}">
        <div class="alert alert-success">
            <strong>Sucesso!</strong> ${msg}
        </div>
    </c:if>

    <c:if test="${not empty lista}">
        <h4>Quantidade de pedidos existentes: ${lista.size()}!!!</h4>

        <hr>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Descrição</th>
                <th>Solicitante</th>
                <th>Equipamentos</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${lista}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.descricao}</td>
                    <td>${p.solicitante.nome}</td>
                    <td>${p.equipamentos.size()}</td>
                    <td><a href="/pedido/${p.id}/excluir">Excluir</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <c:if test="${empty lista}">
        <h4>Não existem pedidos cadastrados!!!</h4>
    </c:if>
</div>
</body>
</html>