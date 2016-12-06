<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/estilos.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="Chart.min.js"></script>
<script src="../js/ajax.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu Empresa</title>
</head>

<nav class="navbar navbar-inverse  navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Sap</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/SistemaAvaliacao/LogOut" data-toggle="modal">Sair <span
						class="glyphicon glyphicon-log-out"></span></a></li>
			</ul>
		</div>
	</nav>	
	
<body id="corpo" style="margin-top:50px">
	<div class="container-fluid">
	<c:set var="empresa" value="${empresa}"/>
	
	<div class="container link">
		 <!-- Centered Pills -->
		<ul class="nav nav-pills nav-justified" >
			<li class="active"><a data-toggle="pill" href="#listaFormularios">Gerenciar
					Formulários Resposta</a></li>
			<li><a data-toggle="pill" href="#meuFormulario" id="meusFormularios">Criar
					Formulário</a></li>
			<li><a  data-toggle="pill" href="#estatisticas" id="minhasEstatisticas">Estatísticas</a></li>
			<li><a  data-toggle="pill" href="#meuBeneficio" id="meusBeneficios">Benefícios</a></li>
		</ul>
	</div>	

		<div class="tab-content">
			<div id="listaFormularios" class="tab-pane fade in active container">
				<h3>Formulários Resposta de Consumidores</h3>
				<p>Veja o resultado das respostas dos seus consumidores, e efetive o Benefício</p>
			</div>

			<div id="meuFormulario" class="tab-pane fade container">
				<div>
					<h2>Meus Formularios</h2>
					<p>Crie seu formulário.</p>
				</div>
				<button type="button" class="btn btn-success" data-toggle="modal" href="#modalFormulario">Novo Formulário</button>
				<hr>
				<br><br>
					<div class="row">
							<table class="table table-bordered" id="tabelaFormulario">
								<thead>
									<th>ID</th>
									<th>Nome do Formulário</th>								
								</thead>
								<tbody> 
<%-- 									<c:forEach var="tipoDeFormulario" items="${empresa.tiposDeFormulario}"> --%>
<%--  										<tr id="${tipoDeFormulario.id}"> --%>
<%-- 											<td>${tipoDeFormulario.id}</td> --%>
<%-- 											<td>${tipoDeFormulario.nomeFormulario}</td> --%>
<%-- 											<td><button type="button" class="btn btn-danger" value= "${tipoDeFormulario.id}" id="removerFormulario${tipoDeFormulario.id}"">Remover</button></td> --%>
<%-- 											<td><a href="/SistemaAvaliacao/FrontController?acao=ObterFormulario&idFormulario=${tipoDeFormulario.id}"class="btn btn-info" role="button" ><span class="glyphicon glyphicon-retweet"></span> Alterar</a></td> --%>
<!-- 										</tr>  -->
<%-- 									</c:forEach>  --%>
 								</tbody> 
							</table>
					</div>
				<!-- Inicio modal -->
				<div class="modal fade" id="modalFormulario" role="dialog" data-backdrop="static">
					<div class="modal-dialog modal-lg">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header" style="padding: 35px 50px;">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Crie seu Formulário</h4>
									<br><br>
									<div class="form-group">
										<div class="form-group">
											<label class="col-sm-2 control-label" for="nomeFormulario" name="nomeFormulario">Nome do Formulário</label>
											<div class="col-sm-10">
												<input class="form-control" type="text" name="nomeFormulario"
													id="nomeFormulario" placeholder="Digite o nome do formulário">
											</div>
										</div>
									 </div>
								</div>
								<div class="modal-body">
									<form class="form-horizontal" id="formularioPergunta">
										<div class="form-group">
											<label for="pergunta" class="col-sm-2 control-label">Pergunta</label>
											<div class="col-sm-8">
												<input class="form-control" type="text" name="pergunta"
													id="pergunta" placeholder="Digite sua pergunta">
											</div>
											<button id="adicionarPergunta" type="button" class="btn btn-success">Adicionar</button>
										</div>
										<hr>
									</form>
								</div>
								<div id="tabelaAddPergunta">
									<table id="tabelaPergunta">
											<tbody> 
												
			 								</tbody> 
									</table>
								</div>
								<div class="modal-footer">
									<button id="salvarFormulario" type="button" data-dismiss="modal" class="btn btn-success">Salvar</button>
									<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
					<!-- Fim do modal -->
			</div>
			
			<div>
			
			<!-- Inicio visualizar formulario -->
				<div class="modal fade" id="modalVisualizarFormulario" role="dialog" data-backdrop="static">
					<div class="modal-dialog modal-lg">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header" style="padding: 35px 50px;">
									
									<h4 class="modal-title">Crie seu Formulário</h4>
									<br><br>
									<div class="form-group">
										<div class="form-group">
											<label class="col-sm-2 control-label" for="nomeFormularioVisualizar" name="nomeFormularioVisualizar">Nome do Formulário</label>
											<div class="col-sm-10">
												<input class="form-control" type="text" name="nomeFormularioVisualizar"
													id="nomeFormularioVisualizar">
											</div>
										</div>
									 </div>
								</div>
								<div class="modal-body">
									<form class="form-horizontal" id="visualizarPerguntas">
										<div class="form-group">
											<label for="pergunta" class="col-sm-2 control-label">Pergunta</label>
					
										</div>
										<hr>
									</form>
								</div>
								<div id="tabelaVerPerguntas">
									<table id="tabelaVerPergunta">
											<tbody> 
												
			 								</tbody> 
									</table>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
					<!-- Fim do modal visualizar formulario-->
			</div>

			<div id="estatisticas" class="tab-pane fade box">
				<h3>Estatísticas</h3>
				<p>Veja suas estatísticas</p>

				<div class="formPesquisa">
					<fieldset>
					<form class="form-inline" role="form" method="post" id="formConsulta">
						<label class="control-label">Data Inicial</label>
						<div  class="input-group date" data-provide="datepicker">
							<input name="dataInicio" id="dataInicio" type="date" class="form-control"pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1950-01-01" max="2016-12-31" required>
									
						</div>
						<label class="control-label">Data Final</label>
						<div  class="input-group date" data-provide="datepicker">
							<input name="dataFinal" id="dataFinal" type="date" class="form-control"pattern="[0-9]{2}\/[0-9]{2}\/[0-9]{4}$" min="1950-01-01" max="2016-12-31" required>
				
						</div>
						
						<div class="form-group">
							<label class="control-label">Formulário</label>
							<div class="form-group">
							<select class="form-control" id="selectFormularios" name="Formularios">							    
							   <option selected="selected">Todos</option>							    
 							 </select>
 							 </div>
						</div>
						
						<div class="form-group">
							<label class="control-label">Perguntas</label>
							<div class="form-group">
							<select class="form-control" id="selectPerguntas" name="selectPerguntas">
							  <option selected="selected">Todos</option>					
 							 </select>
 							 </div>
						</div>
						<div class="form-group">
							<button class="btn btn-info" type="submit" name="buscar" id="buscar">Buscar</button>
						</div>
					</form>
					</fieldset>
				</div>
				<br><br>
				<fieldset>
				<div class="box-chart">
					<canvas id="GraficoPizza" style="width:100%"></canvas>
				</div>
				</fieldset>
				<br><br>
				<fieldset>
				<div class="box-chart">
					<canvas id="GraficoBarra" style="width:100%;"></canvas>
				</div>
				</fieldset>
			</div>

			<div id="meuBeneficio" class="tab-pane fade container">
				<h3>Benefícios</h3>
				<p>Defina o tipo de beneficio que deseja oferecer a seus clientes</p>
						
						<form class="form-horizontal" id="formularioPergunta">
							<div class="form-group">
									<label for="beneficio" class="col-sm-2 control-label">Benefício</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" name="beneficio"
										id="beneficio" placeholder="Digite o nome do beneficio que deseja conceder a seus clientes">
									</div>
								<button type="button" class="btn btn-success" value="salvar" id="salvarBeneficio">Salvar</button>
							</div>
							<hr>
							<br><br>
					<div class="row">
							<table class="table table-bordered" id="tabelaBeneficio">
								<thead>
									<th>ID</th>
									<th>Tipo de Benefício</th>								
								</thead>
								<tbody> 
<%-- 									<c:forEach var="tipoDeBeneficio" items="${empresa.tiposDeBeneficio}"> --%>
<%--  										<tr id="${tipoDeBeneficio.id}"> --%>
<%-- 											<td>${tipoDeBeneficio.id}</td> --%>
<%-- 											<td>${tipoDeBeneficio.nomeBeneficio}</td> --%>
<%-- 											<td><button type="button" class="btn btn-danger" value= "${tipoDeBeneficio.id}" id="removerBeneficio" onclick="removeBeneficio(this)">Remover</button></td> --%>
<%-- 											<td><a href="/SistemaAvaliacao/FrontController?acao=ObterBeneficio&idBeneficio=${tipoDeBeneficio.id}"class="btn btn-info" role="button" ><span class="glyphicon glyphicon-retweet"></span> Alterar</a></td> --%>
<!-- 										</tr>  -->
<%-- 									</c:forEach>  --%>
 								</tbody> 
							</table>
					</div>
						</form>	
			</div>
		</div>

	</div>
</body>
</html>