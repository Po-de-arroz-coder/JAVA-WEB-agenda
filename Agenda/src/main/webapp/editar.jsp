<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="imagens/phone-icon.ico">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> 
	<title>Editar</title>
</head>
<body>
	<h1>Editar contato:</h1>
		<form action="update" name="fmAtualizar" method="get">
			<table>
				<tr>
					<td>
						<label class="w3-text-red">Id</label>
						<br>
						<input type="text" name="Id" class="w3-input w3-border w3-round-large" value="<%out.print(request.getAttribute("id")); %>" required readonly>
					</td>
				</tr>
				<tr>
					<td>
						<label class="w3-text-blue ">Digite seu nome</label>
						<br>
						<input type="text" name="Nome" class="w3-input w3-border w3-round-large" required value="<%out.print(request.getAttribute("nome")); %>">
					</td>
				</tr>
				<tr>
					<td>
						<label class="w3-text-blue">Digite seu telefone</label>
						<input type="text" name="Telefone" class="w3-input w3-border w3-round-large" required value="<%out.print(request.getAttribute("telefone")); %>">
					</td>
				</tr>
				<tr>
					<td>
						<label class="w3-text-blue">Digite seu email</label>
						<input type="text" name="Email" class="w3-input w3-border w3-round-large" required value="<%out.print(request.getAttribute("email")); %>">
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Atualizar" class="w3-button w3-blue w3-round-large">
			</form>
			<br>
			<a href="index.html" class="w3-button w3-blue w3-round-large">Voltar</a>
</body>
</html>