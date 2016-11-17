<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="formulario" value="${formulario}"/>	
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
	<script src="../SistemaAvaliacao/js/ajax.js"></script>
	<link rel="stylesheet" href="../SistemaAvaliacao/css/estilos.css">
	
</head>
<body id="corpoFormuario">
	
	<div class="container col-md-4 col-md-push-4" id="divForm">
	<h3>Ajude-nos a melhorar nossos produtos</h3>
		<p>Sua opinião é muito importante. Com ela podemos entregar o melhor produto para você</p> 
		<hr>
		<form class="form" id="formularioResposta">
			<c:forEach var="pergunta" items="${formulario}"> 
					<div class="form-group">
						<label class="coltrol-label">${pergunta.nomePergunta}</label>
						<div class="form-group">
							<input type="hidden" name="idPergunta" id="idPergunta" value="${pergunta.id}">
							<label class="radio-inline"><input value="otimo" type="radio" name="opcoes${pergunta.id}">Ótimo</label>
							<label class="radio-inline"><input value="bom" type="radio" name="opcoes${pergunta.id}">Bom</label>
			               	<label class="radio-inline"><input value="ruin" type="radio" name="opcoes${pergunta.id}">Ruim</label>
			               	<label class="radio-inline"><input value="pessimo" type="radio" name="opcoes${pergunta.id}">Péssimo</label>
		               	</div>
					</div>
			</c:forEach>
			<br>
			<div class="from-group">
				<button type="button" class="btn btn-default btn-sm btn-block" id="enviar">Enviar</button>
			</div>
		</form>
	</div>
</body>
</html>