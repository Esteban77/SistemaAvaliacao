<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/estilos.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="Chart.min.js"></script>
<script src="../js/ajax.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu Empresa</title>
</head>
<body>
	<div class="container-fluid">
	<c:set var="empresa" value="${empresa}"/>	
		<nav class="navbar nav navbar-inverse"> <!-- Centered Pills -->
		<ul class="nav nav-pills nav-justified">
			<li><a data-toggle="pill" href="#listaFormularios">Meu
					Formulario</a></li>
			<li class="active"><a data-toggle="pill" href="#meuFormulario" id="meusFormularios">Criar
					Formulário</a></li>
			<li><a data-toggle="pill" href="#estatisticas" id="grafico2">Estatistícas</a></li>
			<li><a data-toggle="pill" href="#meuBeneficio" id="meusBeneficios">Benefícios</a></li>
		</ul>
		</nav>

		<div class="tab-content">
			<div id="listaFormularios" class="tab-pane fade container">
				<h3>Meu Formulario</h3>
				<p>Veja os resultados de seu formulário</p>
			</div>

			<div id="meuFormulario" class="tab-pane fade in active container">
				<div>
					<h2>Meus Formulario</h2>
					<p>Crie seu formulário.</p>
				</div>
				<button type="button" class="btn btn-success" data-toggle="modal" href="#modalFormulario">Novo Formulário</button>
				<br>
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
											<div class="col-sm-4">
												<input class="form-control" type="text" name="nomeFormulario"
													id="nomeFormulario" placeholder="Digite o nome do formulário">
											</div>
										</div>
										<div class="form-group">
									      <label class="col-sm-2 control-label"for="beneficios">Beneficio</label>
									      <div class="col-sm-4">
									      <select class="form-control" id="beneficioLista">
									        <option selected="selected">Todos</option>
<%-- 											<c:forEach var="beneficioUnidade" items="${empresa.tiposDeBeneficio}"> --%>
<%-- 												<option>${beneficioUnidade.nomeBeneficio}</option> --%>
<%-- 											</c:forEach> --%>
 									     </select> 
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
								<div>
									<table id="minhaTabela" class="table">
										<tr>
										
										</tr>
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

			<div id="estatisticas" class="tab-pane fade  container box">
				<h3>Estatisticas</h3>
				<p>Veja suas etatisticas</p>

				<div class="box-chart">
					<canvas id="GraficoPizza" style="width:100%"></canvas>
				</div>
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

<script language="javascript">
        // Função responsável por inserir linhas na tabela
        function inserirLinhaTabela() {

            // Captura a referência da tabela com id “minhaTabela”
            var table = document.getElementById("minhaTabela");
            var pergunta =  document.getElementById("pergunta");
            // Captura a quantidade de linhas já existentes na tabela
            var numOfRows = table.rows.length;
            // Captura a quantidade de colunas da última linha da tabela
            var numOfCols = table.rows[numOfRows-1].cells.length;

            // Insere uma linha no fim da tabela.
            var newRow = table.insertRow(numOfRows);
                 //Insere um conteúdo na coluna
                newRow.innerHTML = "<td style='text-align:left' width='75%'><h4>" + pergunta.value + "</h4>"+
               						"<label class='radio-inline'><input type='radio' name='optradio'>Ótimo</label><label class='radio-inline'> <input type='radio' name='optradio'>Bom</label>"+
               						"<label class='radio-inline'><input type='radio' name='optradio'>Ruin</label><label class='radio-inline'> <input type='radio' name='optradio'>Péssimo</label></td>"+
                					"<td width='25%'><button class='btn btn-info' onClick='removerLinha(this)' >Alterar</button> <button class='btn btn-danger' onClick='removerLinha(this)' >Remover</button><td>";
                					
           
        }
        
        // Função responsável em receber um objeto e extrair as informações necessárias para a remoção da linha.
        function removerLinha(obj) {
 
                // Capturamos a referência da TR (linha) pai do objeto
                var objTR = obj.parentNode.parentNode;
                // Capturamos a referência da TABLE (tabela) pai da linha
                var objTable = objTR.parentNode;
                // Capturamos o índice da linha
                var indexTR = objTR.rowIndex;
                // Chamamos o método de remoção de linha nativo do JavaScript, passando como parâmetro o índice da linha  
                objTable.deleteRow(indexTR);
         } 
        
        var randomnb = function(){ return Math.round(Math.random()*300)};

        var options = {
            responsive:true
        };

        var data = [
            {
                value: randomnb(),
                color:"#F7464A",
                //highlight: "#FF5A5E",
                label: "Péssimo"
            },
            {
                value: randomnb(),
                color: "#32CD32",
                //highlight: "#5AD3D1",
                label: "Muito Bom"
            },
            {
                value: randomnb(),
                color: "#FFFF00",
                //highlight: "#FFC870",
                label: "Ruin"
            },
            {
            	value: randomnb(),
            	color: "#7CFC00",
            	label: "Bom"
            }
        ]
        
        $("#grafico2").on('shown.bs.tab',function (e) {
        	var ctx = document.getElementById("GraficoPizza").getContext("2d");
            var PizzaChart = new Chart(ctx).Doughnut(data, options);
        	});
              	 
</script>

</html>