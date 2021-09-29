<%--
  Created by IntelliJ IDEA.
  User: usuário
  Date: 25/09/2021
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>APPMEC - Cadastro!!!</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">
    <h3>Java WEB</h3>
    <h4>AT</h4>
    <ul class="list-group">
        <c:forEach var="mapa" items="${totalizacao}">
            <li class="list-group-item">${mapa.key} <span class="badge">${mapa.value}</span></li>
        </c:forEach>
    </ul>
</div>

</body>
</html>