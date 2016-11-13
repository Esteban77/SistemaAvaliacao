<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu Empresa</title>
</head>
<body>
	<div class="container-fluid">

		<nav class="navbar nav navbar-inverse"> <!-- Centered Pills -->
		<ul class="nav nav-pills nav-justified">
			<li><a data-toggle="pill" href="#listaFormularios">Meu
					Formulario</a></li>
			<li class="active"><a data-toggle="pill" href="#meuFormulario">Criar
					Formulário</a></li>
			<li><a data-toggle="pill" href="#estatisticas" id="grafico2">Estatistícas</a></li>
			<li><a data-toggle="pill" href="#meuDesconto">Meu Desconto</a></li>
		</ul>
		</nav>

		<div class="tab-content">
			<div id="listaFormularios" class="tab-pane fade container">
				<h3>Meu Formulario</h3>
				<p>Veja os resultados de seu formulário</p>
			</div>

			<div id="meuFormulario" class="tab-pane fade in active container">
				<div>
					<h2>Meu Formulario</h2>
					<p>Crie seu formulário.</p>
				</div>
				<br>
				<div>
					<form class="form-horizontal" id="formularioPergunta">
						<div class="form-group">
							<label for="pergunta" class="col-sm-2 control-label">Pergunta</label>
							<div class="col-sm-8">
								<input class="form-control" type="text" name="pergunta"
									id="pergunta" placeholder="Digite sua pergunta">
							</div>
							<input type="submit" class="btn btn-success" value="Adicionar"
								onclick="inserirLinhaTabela()" />
						</div>
					</form>
					<table id="minhaTabela" class="table">
						<tr>

						</tr>
					</table>
				</div>
			</div>

			<div id="estatisticas" class="tab-pane fade  container box">
				<h3>Estatisticas</h3>
				<p>Veja suas etatisticas</p>

				<div class="box-chart">
					<canvas id="GraficoPizza" style="width:100%"></canvas>
				</div>
			</div>

			<div id="meuDesconto" class="tab-pane fade container">
				<h3>Meu Desconto</h3>
				<p>Defina o tipo de desconto que deseja oferecer a seus clientes</p>
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
                newRow.innerHTML = "<td><h4 style='text-align:center'>" + pergunta.value + "</h4><td>"+
                					"<td ><button class='btn btn-danger' onClick='removerLinha(this)' >Remover</button><td>";
           
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