<%@ page import="java.util.ArrayList"%>
<%@ page import="java.math.BigInteger"%>

<%@ page import="model.Calculation"%>
<%@ page import="service.CalculatorService"%>

<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.text.DecimalFormatSymbols"%>
<%@ page import="java.text.NumberFormat"%>
<%@ page import="java.util.Locale"%>
<%@ include file="calculator.css"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
						value="Calcular"> <br><br>
					Resultado = ${result}
				</p>
			</form>
		</div>
		<h2>Histórico de cálculos</h2>
		<table>
			<tr>
				<th>Número</th>
				<th>Resultado</th>
			</tr>
			<%
			if (request.getAttribute("history") != null) {
				ArrayList<Calculation> history = (ArrayList<Calculation>) request.getAttribute("history");
					for (Calculation c : history) {
						String formattedResult=CalculatorService.formatResult(c.getResult());
			%>
			<tr>
				<td> <%=c.getNumber()%></td>
				<td title=<%=c.getResult()%>><%=formattedResult%></td>
			</tr>
			<%	} 
			}
			%>
		</table>
		<p style="text-align: center;">
			Aplicação web feita para o desafio da vaga de Bolsista do laboratório
			Bridge. <br> Maria Eduarda de Melo Hang
		</p>
	</div>
</body>
</html>