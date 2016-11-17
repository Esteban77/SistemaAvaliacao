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

	});		

	
		$('#enviar').click(function(){
			var respostas = new Array();
			var idPergunta1;
//			var textarea= $('#textarea')
			
			$('input').each(function(){
				if($(this).attr("name")=="idPergunta"){
//					alert($(this).attr("name"));
					idPergunta1 = $(this).val();
				}				
				if($(this).is(':checked')){
//					alert("true");
					respostas.push({
						idPergunta: idPergunta1,
						resposta: $(this).val()
					});
				}
				
			});
					$.getJSON('/SistemaAvaliacao/FrontController?acao=SalvarRespostasFormulario',	{'respostas': JSON.stringify(respostas)/*, 'textarea': textarea*/}, 		
							//Funcao de callback
							function(responseTxt, statusTxt, xhr) { 
						if(statusTxt == "success"){
							var repostas = responseTxt;
						}if(statusTxt == "error"){
//							alert("Error: " + xhr.status + ": " + xhr.statusText);
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

/*	$('#enviar').click(function(){
			
			var respostas = new Array();
			var idPergunta1;
			$('#formularioResposta').each(function(){
				$(this).find('input[id="idPergunta"]').each(function(){
					idPergunta1 = $("#idPergunta").val();
					});				
				if($(this).find('input[type="radio"]:checked').length > 0){
					$(this).find('input[type="radio"]:checked').each(function(){
						respostas.push({
							idPergunta: idPergunta1,
							resposta: $(this).val()
						});
					});
					
					$.getJSON('/SistemaAvaliacao/FrontController?acao=SalvarRespostasFormulario',	{'respostas': JSON.stringify(respostas)}, 		
							//Funcao de callback
							function(responseTxt, statusTxt, xhr) { 
						if(statusTxt == "success"){
							var repostas = responseTxt;
						}if(statusTxt == "error"){
//							alert("Error: " + xhr.status + ": " + xhr.statusText);
						}
							});
				}
			});
		});*/

