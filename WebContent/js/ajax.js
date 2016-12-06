$(document).ready(function() {   
	
		$('#salvarBeneficio').click(function() { 			
			var beneficio = $('#beneficio').val();			
			//Chama a URL do Servlet
			$.getJSON('/SistemaAvaliacao/FrontController?acao=IncluirTipoDeBeneficio',	{'beneficio': beneficio}, 		
				//Funcao de callback
				function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
						var beneficio = responseTxt;
						$('#tabelaBeneficio > tbody').append('<tr><td>'+beneficio.id+'</td><td>'+beneficio.nome+'</td><td><button type="button" class="btn btn-danger" value= "'+beneficio.id+'" id="removerBeneficio" onclick="removeBeneficio(this)">Remover</button> <button class="btn btn-info" >Alterar</button></td></tr>');
						$('#beneficio').val("");
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
		                    	 $('#tabelaBeneficio > tbody').append('<tr><td>'+value.id+'</td><td>'+value.nome+'</td><td><button type="button" class="btn btn-danger" value= "'+value.id+'" id="removerBeneficio" onclick="removeBeneficio(this)">Remover</button> <button class="btn btn-info" >Alterar</button></td></tr>');
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
		                    	 $('#tabelaFormulario > tbody').append('<tr><td>'+value.id+'</td><td>'+value.nome+'</td><td><button type="button" class="btn btn-danger" value= "'+value.id+'" id="removerFormulario" onclick="removeFormulario(this)">Remover</button> <button class="btn btn-info" >Alterar</button> <button id="visualizar" onclick="visualizarFormulario(this)" value="'+value.id+'"type="button" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-eye-open"></span> Visualizar</button></td></tr>');
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
			$('#tabelaPergunta > tbody').append("<tr><td width='80%' data-nome="+$('#pergunta').val()+"><h4>" +$('#pergunta').val()+ "</h4>"+
						"<label class='radio-inline'><input type='radio' name='optradio'>Ótimo</label><label class='radio-inline'> <input type='radio' name='optradio'>Bom</label>"+
   						"<label class='radio-inline'><input type='radio' name='optradio'>Ruin</label><label class='radio-inline'> <input type='radio' name='optradio'>Péssimo</label></td>"+
    					"<td width='20%'><button class='btn btn-info' >Alterar</button> <button class='btn btn-danger remover-linha'>Remover</button><td><tr>");
			$("#pergunta").val("");
		});	
		
		$('#tabelaPergunta').on('click', '.remover-linha', function(e){
				  e.preventDefault;
				  var removeItem = $(this).parent().parent().find('td').data('nome');
				  var index = perguntas.indexOf(removeItem);
				  perguntas.splice(index, 1);
				  var par = $(this).parent().parent(); //tr
				  par.remove();
		});

		$('#salvarFormulario').click(function() { 			
			var nomeFormulario = $('#nomeFormulario').val();
			//Chama a URL do Servlet
			$.getJSON('/SistemaAvaliacao/FrontController?acao=IncluirFormulario',	{'nomeFormulario': nomeFormulario,'perguntas': JSON.stringify(perguntas)}, 		
				//Funcao de callback
				function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
						var formulario = responseTxt;
						$('#tabelaFormulario > tbody').append('<tr><td>'+formulario.id+'</td><td>'+formulario.nome+'</td><td><button type="button" class="btn btn-danger" value= "'+formulario.id+'" id="removerFormulario" onclick="removeFormulario(this)">Remover</button> <button class="btn btn-info" >Alterar</button> <button type="button" class="btn btn-default btn-sm" value= "'+formulario.id+'"><span class="glyphicon glyphicon-eye-open"></span> Visualizar</button></td></tr>');
						perguntas = new Array();
						var table = $('#tabelaPergunta');

						table.find('tr').each(function(indice){
							var par = $(this).closest('tr'); //tr
							  par.remove();
						});
						$("#nomeFormulario").val("");
						$("#pergunta").val("");
					}if(statusTxt == "error"){
//						alert("Error: " + xhr.status + ": " + xhr.statusText);
					}
					
				});
			
			//perguntas.clear();
	});	
		
		$('#fecharFormulario').click(function() { 
			$("#nomeFormulario").val("");
			$("#pergunta").val("");
		});
		
		var randomnb = function(){ return Math.round(Math.random()*300)};
		var resultadosArray = new Array();
		var ctx;
		var PizzaChart;

		var options = {
		    responsive:true
		};

		var data1 = [
			{
				value: randomnb(),
				color: "#7CFC00",
				label: "Bom"
			},
			{
		        value: 0,
		        color: "#32CD32",
		        //highlight: "#5AD3D1",
		        label: "Ótimo"
		    },
		    {
		        value: 0,
		        color:"#F7464A",
		        //highlight: "#FF5A5E",
		        label: "Péssimo"
		    },    
		    {
		        value: 0,
		        color: "#FFFF00",
		        //highlight: "#FFC870",
		        label: "Ruim"
		    }    
		]

		$("#minhasEstatisticas").on('shown.bs.tab',function (e) {
			ctx = document.getElementById("GraficoPizza").getContext("2d");
		    PizzaChart = new Chart(ctx).Pie(data1, options);
			});

			
		$('#formConsulta').submit(function(e){
			e.preventDefault();
			
			 $.ajax({
		            type: $(this).attr('method'),
		            url: "/SistemaAvaliacao/FrontController?acao=Consultas",
		            data: $(this).serialize(),
		            dataType: "json",
		            success: function (data,status) {
		            	i = 0;
		            	$.each(data, function(key, value) {
		            		resultadosArray.push(value.qtd);
		            		data1[i].value = value.qtd;
		            		i++;
	                    });
		            	PizzaChart.destroy();
		            	PizzaChart= new Chart(ctx).Pie(data1, options);
		   			  resultadosArray = new Array();
		            },
		            error: function (xhr, desc, err){	            
		            	alert("erro no gráfico de Pizza");
		            }
		            
		        });			 
			 
		});
		
		var arrayBom = new Array();
		var arrayOtimo = new Array();
		var arrayPessimo = new Array();
		var arrayRuim = new Array();
		var ctx2;
		var BarChart;
		 var optiones = {
			        responsive:true,
			        showDatasetLabels : true,
			        animation: true,
			        barValueSpacing : 5,
			        barDatasetSpacing : 1,
			        tooltipFillColor: "rgba(0,0,0,0.8)",                
			        multiTooltipTemplate: "<%= datasetLabel %> - <%= value %>"
			    };

			    var data = {
			        labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
			        datasets: [
			           /* {
			                label: "Bom",
			                fillColor: "rgba(220,220,220,0.5)",
			                strokeColor: "rgba(220,220,220,0.8)",
			                highlightFill: "rgba(220,220,220,0.75)",
			                highlightStroke: "rgba(220,220,220,1)",
			                data: []
			            },
			            {
			                label: "Ótimo",
			                fillColor: "rgba(151,187,205,0.5)",
			                strokeColor: "rgba(151,187,205,0.8)",
			                highlightFill: "rgba(151,187,205,0.75)",
			                highlightStroke: "rgba(151,187,205,1)",
			                data: []
			            },
			            {
			                label: "Péssimo",
			                fillColor: "rgba(151,187,205,0.5)",
			                strokeColor: "rgba(151,187,205,0.8)",
			                highlightFill: "rgba(151,187,205,0.75)",
			                highlightStroke: "rgba(151,187,205,1)",
			                data: []
			            },
			            {
			                label: "Ruim",
			                fillColor: "rgba(151,187,205,0.5)",
			                strokeColor: "rgba(151,187,205,0.8)",
			                highlightFill: "rgba(151,187,205,0.75)",
			                highlightStroke: "rgba(151,187,205,1)",
			                data: []
			            }*/
			        {
		                label: "Bom",
		                fillColor: "rgba(124, 252, 0, 1.0)",
		                strokeColor: "rgba(124, 252, 0, 1.3)",
		                highlightFill: "rgba(124, 252, 0, 1.5)",
		                highlightStroke: "rgba(124, 252, 0, 1.8)",
		                data: []
		            },
		            {
		                label: "Ótimo",
		                fillColor: "rgba(50, 205, 50, 1.0)",
		                strokeColor: "rgba(50, 205, 50, 1.3)",
		                highlightFill: "rgba(50, 205, 50, 1.5)",
		                highlightStroke: "rgba(50, 205, 50, 1.8)",
		                data: []
		            },
		            {
		                label: "Péssimo",
		                fillColor: "rgba(247, 70, 74, 1.0)",
		                strokeColor: "rgba(247, 70, 74, 1.3)",
		                highlightFill: "rgba(247, 70, 74, 1.5)",
		                highlightStroke: "rgba(247, 70, 74, 1.8)",
		                data: []
		            },
		            {
		                label: "Ruim",
		                fillColor: "rgba(255, 255, 0, 1.0)",
		                strokeColor: "rgba(255, 255, 0, 1.3)",
		                highlightFill: "rgba(255, 255, 0, 1.5)",
		                highlightStroke: "rgba(255, 255, 0, 1.8)",
		                data: []
		            }
			        ]
			    };                

			    $("#minhasEstatisticas").on('shown.bs.tab',function (e) {
			    	 $.ajax({
				            type: $(this).attr('method'),
				            url: "/SistemaAvaliacao/FrontController?acao=ConsultaGraficoBarras",
				            data: $(this).serialize(),
				            dataType: "json",
				            success: function (resultado,status) {
				            	i = 0;
				            	$.each(resultado, function(key, value) {
				            		if(i==0){
				            			arrayBom = value;
				            			data.datasets[i].data=arrayBom;
				            		}else if(i==1){
				            			arrayOtimo = value;
				            			data.datasets[i].data=arrayOtimo;
				            		}else if(i==2){
				            			arrayPessimo = value;
				            			data.datasets[i].data=arrayPessimo;
				            		}else{
				            			arrayRuim = value;
				            			data.datasets[i].data=arrayRuim;
				            		}
				            		i++;
			                    });
				            	ctx2 = document.getElementById("GraficoBarra").getContext("2d");
				            	BarChart = new Chart(ctx2).Bar(data, optiones);
				            	arrayBom = new Array();
				            	arrayOtimo= new Array();
				            	arrayPessimo= new Array();
				            	arrayRuim= new Array();
				            },
				            error: function (xhr, desc, err){	            
				            	alert("erro no grafico de barras");
				            }				            
				        });			      
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

/*function removeFormulario(handler) {
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
				alert("Não é possível eliminar Formulário já respondido");
			}
			alert("Error: " + xhr.status + ": " + xhr.statusText);
		});
}*/

function removeFormulario(handler) {
	var idFormulario = $(handler).val();	
	var par = $(handler).parent().parent(); //tr
	 $.ajax({
         type: "post",
         url: '/SistemaAvaliacao/FrontController?acao=RemoverTipoDeFormulario',
         data: {"idFormulario":idFormulario},
         dataType: "json",
         success: function (resultado,status) {
        	 if(status == "success"){
 				if(resultado==true){
 					par.remove();
// 					$this.closest('tr').remove();
 				}
        	 }
         },
         error: function (xhr, desc, err){	            
        	 alert("Não é possível eliminar Formulário já respondido");
         }				            
     });
}
function visualizarFormulario(handler) {
	var idFormulario = $(handler).val();	
	var par = $(handler).parent().parent(); //tr
	 $.ajax({
         type: "get",
         url: '/SistemaAvaliacao/FrontController?acao=VisualizarFormulario',
         data: {"idFormulario":idFormulario},
         dataType: "json",
         success: function (responseTxt,status) {
        	 if(status == "success"){
 					$("#modalVisualizarFormulario").modal();
 					alert(idFormulario);
 				
        	 }
         },
         error: function (xhr, desc, err){	            
        	 
         }				            
     });
}





