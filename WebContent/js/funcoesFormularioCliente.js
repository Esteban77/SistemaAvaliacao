$(document).ready(function(){
	$(windown).load(function(){
        $("#modalConsumidor").modal();
        $('confrimar').attr("data-dismiss", "modal");
    });
	
	$('#enviar').click(function(){
		var respostas = new Array();
		var idPergunta1;
		var comentario= $('#comentario').val();
		
		$('input').each(function(){
			if($(this).attr("name")=="idPergunta"){
//				alert($(this).attr("name"));
				idPergunta1 = $(this).val();
			}				
			if($(this).is(':checked')){
//				alert("true");
				respostas.push({
					idPergunta: idPergunta1,
					resposta: $(this).val()
				});
			}
			
		});
				$.getJSON('/SistemaAvaliacao/FrontController?acao=SalvarRespostasFormulario',	{'respostas': JSON.stringify(respostas), 'comentario': comentario}, 		
						//Funcao de callback
						function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
						var repostas = responseTxt;
					}if(statusTxt == "error"){
//						alert("Error: " + xhr.status + ": " + xhr.statusText);
					}
						});
			
		});
}); 