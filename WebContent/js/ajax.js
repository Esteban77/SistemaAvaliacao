$(document).ready(function() {   
	
	
/*	$('#cpf').focusout(function(event) {  
		var cpf = $('#cpf').val();
		
		//Chama a URL do Servlet
		$.post('/Projetoweb/ConsultasFront',	{'cpf': cpf}, 
				//Funcao de callback
				function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
						if(responseTxt=="true"){
							$('#cpfFalse').text("CPF já cadastrado. Digite novamente.");
							$('#salvar').prop('disabled',true);
						}else{
							$('#cpfFalse').text("");
							$('#salvar').prop('disabled',false);
						}
//						$('#resultado').text(responseTxt);
//						alert('response: ' + responseTxt + '\nstatusTxt: ' + statusTxt + '\nxhr: ' + xhr);
					}if(statusTxt == "error"){
//						alert("Error: " + xhr.status + ": " + xhr.statusText);
					}
				});

	});	*/	
	
		$('#salvarBeneficio').click(function() { 			
			var beneficio = $('#beneficio').val();			
			//Chama a URL do Servlet
			$.getJSON('/SistemaAvaliacao/FrontController?acao=IncluirTipoDeBeneficio',	{'beneficio': beneficio}, 		
				//Funcao de callback
				function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
						var beneficio = responseTxt;
						$('#tabelaBeneficio > tbody').append('<tr><td>'+beneficio.id+'</td><td>'+beneficio.nome+'</td><td><button type="button" class="btn btn-danger" value= "'+beneficio.id+'" id="removerBeneficio" onclick="removeBeneficio(this)">Remover</button></td></tr>');
					}if(statusTxt == "error"){
//						alert("Error: " + xhr.status + ": " + xhr.statusText);
					}
				});

		});	
		
		$('#selectFormularios').change(function() {
	        var parent = $(this).val();
	        $.getJSON('/SistemaAvaliacao/FrontController?acao=ObterPerguntas', {"idTipoFormulario":parent},	 		
					//Funcao de callback
					function(responseTxt, statusTxt, xhr) { 
						if(statusTxt == "success"){
							$('#selectPerguntas').find('option:not(:first)').remove();
							if(responseTxt.id!="Todos"){
		                     $.each(responseTxt, function(key, value) {
		                    	    $('#selectPerguntas').append($("<option/>", {
		                    	        value: value.id,
		                    	        text: value.nome
		                    	    }));
		                    	});
							}
	 					}if(statusTxt == "error"){
							alert("Error: " + xhr.status + ": " + xhr.statusText);
						}
					});	
	        
		});
		
		$('#minhasEstatisticas').click(function() { 
			$.getJSON('/SistemaAvaliacao/FrontController?acao=ObterTiposDeFormulario',	 		
					//Funcao de callback
					function(responseTxt, statusTxt, xhr) { 
						if(statusTxt == "success"){
							$('#selectFormularios').find('option:not(:first)').remove();
		                     $.each(responseTxt, function(key, value) {
		                    	    $('#selectFormularios').append($("<option/>", {
		                    	        value: value.id,
		                    	        text: value.nome
		                    	    }));
		                    	});
	 					}if(statusTxt == "error"){
							alert("Error: " + xhr.status + ": " + xhr.statusText);
						}
					});		
			
		});
		
		$('#meusBeneficios').click(function() { 
			$.getJSON('/SistemaAvaliacao/FrontController?acao=ObterTiposDeBeneficio',	 		
					//Funcao de callback
					function(responseTxt, statusTxt, xhr) { 
						if(statusTxt == "success"){
							$('#tabelaBeneficio > tbody').empty();
		                     $.each(responseTxt, function(key, value) {
		                    	 $('#tabelaBeneficio > tbody').append('<tr><td>'+value.id+'</td><td>'+value.nome+'</td><td><button type="button" class="btn btn-danger" value= "'+value.id+'" id="removerBeneficio" onclick="removeBeneficio(this)">Remover</button></td></tr>');
		                    	});
	 					}if(statusTxt == "error"){
							alert("Error: " + xhr.status + ": " + xhr.statusText);
						}
					});		
			
		});
		
		$('#meusFormularios').click(function() { 
			$.getJSON('/SistemaAvaliacao/FrontController?acao=ObterTiposDeFormulario',	 		
					//Funcao de callback
					function(responseTxt, statusTxt, xhr) { 
						if(statusTxt == "success"){
							$('#tabelaFormulario > tbody').empty();
		                     $.each(responseTxt, function(key, value) {
		                    	 $('#tabelaFormulario > tbody').append('<tr><td>'+value.id+'</td><td>'+value.nome+'</td><td><button type="button" class="btn btn-danger" value= "'+value.id+'" id="removerFormulario" onclick="removeFormulario(this)">Remover</button></td></tr>');
		                    	});
	 					}if(statusTxt == "error"){
							alert("Error: " + xhr.status + ": " + xhr.statusText);
						}
					});		
			
		});
		
		
		$('#beneficioLista').click(function() { 					
			//Chama a URL do Servlet
			$.getJSON('/SistemaAvaliacao/FrontController?acao=ObterTiposDeBeneficio',	 		
				//Funcao de callback
				function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
						$('#beneficioLista').find('option:not(:first)').remove();
	                     $.each(responseTxt, function(key, value) {
	                    	    $('#beneficioLista').append($("<option/>", {
	                    	        value: value.id,
	                    	        text: value.nome
	                    	    }));
	                    	});
 					}if(statusTxt == "error"){
						alert("Error: " + xhr.status + ": " + xhr.statusText);
					}
				});

	});			

		
	 var perguntas = new Array();		
		
		$('#adicionarPergunta').click(function() { 
			perguntas.push($('#pergunta').val());
		});	


		$('#salvarFormulario').click(function() { 			
			var nomeFormulario = $('#nomeFormulario').val();
			var beneficio = $('#beneficioLista').val();
			//Chama a URL do Servlet
			$.getJSON('/SistemaAvaliacao/FrontController?acao=IncluirFormulario',	{'nomeFormulario': nomeFormulario,'beneficio': beneficio,'perguntas': JSON.stringify(perguntas)}, 		
				//Funcao de callback
				function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
						var formulario = responseTxt;
						$('#tabelaFormulario > tbody').append('<tr><td>'+formulario.id+'</td><td>'+formulario.nome+'</td><td><button type="button" class="btn btn-danger" value= "'+formulario.id+'" id="removerFormulario" onclick="removeFormulario(this)">Remover</button></td></tr>');
					}if(statusTxt == "error"){
//						alert("Error: " + xhr.status + ": " + xhr.statusText);
					}
				});
			perguntas = new Array();
			//perguntas.clear();
	});	
		
		var resultadosArray = new Array();	
		$('#formConsulta').submit(function(e){
			e.preventDefault();
/*			var dataInicial = $('dataInicio').val();
			var dataFinal = $('dataFinal').val();
			var tipoDeForm = $('selectFormularios').val();
			var pergunta = $('selectPerguntas').val();*/
			
			 $.ajax({
		            type: $(this).attr('method'),
		            url: "/SistemaAvaliacao/FrontController?acao=Consultas",
		            data: $(this).serialize(),
		            dataType: "json",
		            success: function (data,status) {
		            	$.each(responseTxt, function(key, value) {
		            		resultadosArray.push(value.id);
	                    });	            	
		            },
		            error: function (xhr, desc, err){	            
		            	alert("erro");
		            }
		        });			 
			  PizzaChart=new Chart(ctx).Doughnut(data, options);
			  resultadosArray = new Array();
		});

	

		
});


function removeBeneficio(handler) {
	var idBeneficio = $(handler).val();	
	var par = $(handler).parent().parent(); //tr
	//Chama a URL do Servlet
	$.getJSON('/SistemaAvaliacao/FrontController?acao=RemoverBeneficio',	{'idBeneficio': idBeneficio}, 		
		//Funcao de callback
		function(responseTxt, statusTxt, xhr) { 
			if(statusTxt == "success"){
				if(responseTxt==true){
					par.remove();
//					$this.closest('tr').remove();
				}
			}if(statusTxt == "error"){
//				alert("Error: " + xhr.status + ": " + xhr.statusText);
			}
		});
}

function removeFormulario(handler) {
	var idFormulario = $(handler).val();	
	var par = $(handler).parent().parent(); //tr
	//Chama a URL do Servlet
	$.getJSON('/SistemaAvaliacao/FrontController?acao=RemoverTipoDeFormulario',	{'idFormulario': idFormulario}, 		
		//Funcao de callback
		function(responseTxt, statusTxt, xhr) { 
			if(statusTxt == "success"){
				if(responseTxt==true){
					par.remove();
//					$this.closest('tr').remove();
				}
			}if(statusTxt == "error"){
//				alert("Error: " + xhr.status + ": " + xhr.statusText);
			}
		});
}

var randomnb = function(){ return Math.round(Math.random()*300)};
var numBom;
var numOtimo;
var numPessimo;
var numRuim;
var ctx;
var PizzaChart;

var options = {
    responsive:true
};

var data = [
	{
		value: resultadosArray[0],
		color: "#7CFC00",
		label: "Bom"
	},
	{
        value: resultadosArray[1],
        color: "#32CD32",
        //highlight: "#5AD3D1",
        label: "Otimo"
    },
    {
        value: resultadosArray[2],
        color:"#F7464A",
        //highlight: "#FF5A5E",
        label: "Péssimo"
    },    
    {
        value: resultadosArray[3],
        color: "#FFFF00",
        //highlight: "#FFC870",
        label: "Ruim"
    }    
]

$("#minhasEstatisticas").on('shown.bs.tab',function (e) {
	var ctx = document.getElementById("GraficoPizza").getContext("2d");
    var PizzaChart = new Chart(ctx).Doughnut(data, options);
	});


