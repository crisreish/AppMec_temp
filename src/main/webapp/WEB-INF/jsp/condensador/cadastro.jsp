<%--
  Created by IntelliJ IDEA.
  User: usuário
  Date: 26/09/2021
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CONDENSADOR - Cadastro!!!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	  <h2>Cadastro de Condensadores</h2>
	  <form action="/condensador/incluir" method="post">

	    <div class="form-group">
	      <label>Descrição:</label>
	      <input type="text" value="Vapor Alta Pressão" class="form-control" placeholder="Entre com a descrição" name="descricao">
	    </div>

	    <div class="form-group">
	      <label>Valor:</label>
	      <input type="text" value="R$100.000,00" class="form-control" placeholder="Entre com o valor" name="valor">
	    </div>
		
	    <div class="form-group">
	      <label>Peso:</label>
	      <input type="text" value="15tn" class="form-control" placeholder="Entre com a peso" name="peso">
	    </div>

	    <div class="form-group">
	      <label>Material:</label>
			<label class="checkbox-inline"><input type="checkbox" name="agua" checked>Agua</label>
			<label class="checkbox-inline"><input type="checkbox" name="gas">Gas</label>
	    </div>

	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>

</body>
</html>