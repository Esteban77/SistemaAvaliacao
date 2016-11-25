<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
	<script src="../SistemaAvaliacao/js/funcoesFormularioCliente.js"></script>
	<link rel="stylesheet" href="../SistemaAvaliacao/css/estilos.css">
	
</head>
<body id="corpoFormuario">	
<c:set var="formulario" value="${formulario}"/>	
<c:set var="idF" value="${idForm}"/>
	<div class="container col-md-4 col-md-push-4" id="divForm">
	<h3>Ajude-nos a melhorar nossos produtos</h3>
		<p>Sua opinião é muito importante. Com ela podemos entregar o melhor produto para você</p> 
		<hr>
		<form class="formu" id="formularioResposta">
		<input type="hidden" name="idRespostaFormulario" id="idRespostaFormulario" value="">
		<input type="hidden" name="idConsumidor" id="idConsumidor2" value="">
			<c:forEach var="pergunta" items="${formulario}"> 
					<div class="form-group">
						<label class="coltrol-label">${pergunta.nomePergunta}</label>
						<div class="form-group">
							<input type="hidden" name="idPergunta" class="formulinho" id="idPergunta" value="${pergunta.id}">
							<label class="radio-inline"><input class="formulinho" value="OTIMO" type="radio" name="opcoes${pergunta.id}" checked>Ótimo</label>
							<label class="radio-inline"><input class="formulinho" value="BOM" type="radio" name="opcoes${pergunta.id}">Bom</label>
			               	<label class="radio-inline"><input class="formulinho" value="RUIM" type="radio" name="opcoes${pergunta.id}">Ruim</label>
			               	<label class="radio-inline"><input class="formulinho" value="PESSIMO" type="radio" name="opcoes${pergunta.id}">Péssimo</label>
		               	</div>
					</div>
			</c:forEach>
			<div class="form-group">
  				<label for="comment">Comentário:</label>
  			<textarea class="form-control" rows="5" id="comentario"></textarea>
			</div>
			<br>
			<div class="from-group">
				<button type="button" class="btn btn-default btn-sm btn-block" id="enviar">Enviar</button>
			</div>
		</form>
	</div>
	
	<div class="modal fade" id="modalConsumidor" role="dialog" data-backdrop="static">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
			<form role="form" method="post" id="formConsumidor">
			<input type="hidden" name="idTipoFormulario" id="idTipoFormulario" value="${idF}">
			<input type="hidden" name="idConsumidor"  id="idConsumidor1" value="">
				<div class="modal-header" style="padding: 35px 50px;">
				<h5>Entre com seus dados para receber os beneficios da empresa (você deve prencher ALGUNS formulários para receber o cupom de benefício)</h5>
					<p>Selecione a opção "anônimo" se desejar responder ao formulario anônimamente. Nesse caso o formulario nao sera creditado a você</p>
					<div class="checkbox">
						<label class="control-label"><input type="checkbox" id="anonimo" name="anonimo" value="anonimo">anônimo</label>
						<label class="control-label"><input placeholder="Número do pedido" type="text" name="pedido" id="pedido" maxlength="11" required>Número do Pedido</label>
					</div>
				</div>
				<div class="modal-body" id="modalCampos">
						<div class="form-group">
							<label for="Cpf"><span
								class="glyphicon glyphicon-pencil"></span> CPF</label> <input
								name="cpf" type="number" class="form-control obrigatorio" id="cpf"
								placeholder="Digite seu CPF"  maxlength="11" required>
						</div>
						<div class="form-group">
							<label for="login"><span
								class="glyphicon glyphicon-user"></span> Login</label> <input
								name="login" type="text" class="form-control obrigatorio"
								id="login" placeholder="Digite seu login" required>
						</div>
						
						<div class="form-group">
							<label for="senha"><span class="glyphicon glyphicon-lock"></span>
								Senha</label> <input type="password" class="form-control obrigatorio" name="senha"
								id="senha" placeholder="Digite sua senha" max="999999" min="0" required>
						</div>
						
						<div class="form-group">
							<label for="nomeCompleto"><span
								class="glyphicon glyphicon-user"></span> Nome Completo</label> <input
								name="nomeConsumidor" type="text" class="form-control obrigatorio"
								id="nomeConsumidor" placeholder="Digite seu nome completo" pattern="[a-zA-Z]+$" required>
						</div>
						
						<div class="form-group">
							<label for="telefone"><span
								class="glyphicon glyphicon-pencil"></span> Telefone</label> <input
								name="telefone" type="tel" class="form-control obrigatorio" id="telefone"
								placeholder="Digite seu telefone" pattern="^\d{4}-\d{3}-\d{4}$" required>
						</div>
						
						<div class="form-group">
							<label for="email"><span
								class="glyphicon glyphicon-pencil"></span> Email</label> <input
								name="email" type="email" class="form-control obrigatorio" id="email"
								placeholder="Digite seu email" required>
						</div>
					
				</div>
					<div class="modal-footer">
					<button id="confirmar" type="submit" value="Confirmar" class="btn btn-success">Confirmar</button>
					</div>
			</form>
			</div>		
		</div>
	</div>
</body>
</html>