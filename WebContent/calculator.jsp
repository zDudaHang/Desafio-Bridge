<%@ page import="java.util.ArrayList"%>
<%@ page import="java.math.BigInteger"%>

<%@ page import="model.Calculation"%>
<%@ page import="util.Formatting"%>

<%@ include file="calculator.css"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculadora de Fatorial</title>
</head>
<body>
	<div class="grid-container">

		<div class="grid-header">
			<h1>
				Calculadora de Fatorial <span>(n!)</span>
			</h1>
			<p>
				Insira um número natural abaixo e clique em <span
					style="color: #E8175D;">'Calcular'</span> ;)
			</p>
		</div>

		<div class="grid-item-calculator">
			<form action="Calculate" method="post">
				<p>
					<label for="number">Número = </label> <input type="number" min="0"
						id="number" name="number" value="0"> <input type="submit"
						value="Calcular"> <br>
					<br> Resultado = ${result}
				</p>
			</form>
		</div>
		<h2>Histórico de cálculos</h2>
		<table>
			<tr>
				<th>Número</th>
				<th>Resultado</th>
			</tr>
			<% ArrayList<Calculation> history = (ArrayList<Calculation>) request.getAttribute("history"); %>
			<c:if test="${history != null}">
				<c:forEach var="c" items="${history}">
					<tr>
						<td>${c.number}</td>
						
						<!-- Getting the JSTL's var 'c' to use in JSP command to format the result -->
						<% 
						Calculation c = (Calculation)pageContext.getAttribute("c"); 
						BigInteger result = c.getResult();
						%>
						<td title="${c.result}"><%= Formatting.formatResult(result) %></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<p style="text-align: center;">
			Aplicação web feita para o desafio da vaga de Bolsista do laboratório
			Bridge. <br> Maria Eduarda de Melo Hang
		</p>
	</div>
</body>
</html>