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
						$('#tabelaBeneficio > tbody').append('<tr><td>'+beneficio.id+'</td><td>'+beneficio.nome+'</td></tr>');
					}if(statusTxt == "error"){
//						alert("Error: " + xhr.status + ": " + xhr.statusText);
					}
				});

	});	
		
		$('#removerBeneficio').click(function() { 			
			var idBeneficio = $('#removerBeneficio').val();			
			//Chama a URL do Servlet
			$.getJSON('/SistemaAvaliacao/FrontController?acao=RemoverBeneficio',	{'idBeneficio': idBeneficio}, 		
				//Funcao de callback
				function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
						if(responseTxt=="true"){
//							$(this).parent().parent().remove();
							$('#tabelaBeneficio > tbody').remove(idBeneficio);
						}
					}if(statusTxt == "error"){
//						alert("Error: " + xhr.status + ": " + xhr.statusText);
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
			$.getJSON('/SistemaAvaliacao/FrontController?acao=IncluirFormulario',	{'nomeFormulario': nomeFormulario,'beneficio': beneficio,'perguntas': perguntas}, 		
				//Funcao de callback
				function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
						var formulario = responseTxt;
						$('#tabelaFormulario > tbody').append('<tr><td>'+formulario.id+'</td><td>'+formulario.nome+'</td></tr>');
					}if(statusTxt == "error"){
//						alert("Error: " + xhr.status + ": " + xhr.statusText);
					}
				});

	});	
		
		
		
		
		
		});