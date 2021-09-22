<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.model.Contato"%>
<%@ page import="java.util.ArrayList"%>
@SuppressWarnings("unchecked")
<% ArrayList<Contato> lista = (ArrayList<Contato>) request.getAttribute("contatos"); %>
<!DOCTYPE html>
<html>
	<head lang="UTF-8">
		<link rel="stylesheet" href="style.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
		<link rel="icon" href="imagens/phone-icon.ico">
		<meta charset="UTF-8">
		<title>Agenda</title>
	</head>
	<body>
		<h1>Agenda de contatos</h1>
		<a href="report" class="w3-button w3-green">Gerar Relatorio</a>
		<div>
		<table class="w3-table-all w3-hoverable">
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Telefone</th>
				<th>Editar</th>
			</tr>
			<%for (int i = 0; i < lista.size(); i++){ %>
			<tr>
				<td><%= lista.get(i).getId() %></td>
  				<td><%= lista.get(i).getNome() %></td>
  				<td><%= lista.get(i).getEmail() %></td>
  				<td><%= lista.get(i).getTelefone() %></td>
  				<td><a href="select?id=<%= lista.get(i).getId() %>" class="w3-button w3-blue">Editar</a></td>
  				<td><a href="delete?id=<%= lista.get(i).getId() %>" class="w3-button w3-red">Deletar</a></td>
  				
			</tr>
			<%} %>
			
		</table>
		<script type="text/javascript" src="script/confirmar.js"></script>
		</div>
		<a href="novo.html" class="w3-button w3-blue">Novo contato</a>
	</body>
</html>