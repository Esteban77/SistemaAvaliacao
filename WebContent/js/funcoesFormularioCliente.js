$(document).ready(function(){
	$("#telefone").mask("(99) 99999-9999");
	$("#cpf").mask("999.999.999-99");
	
		$('#cpf').focusout(function(event) {  
			var cpf = $('#cpf').val();
			
			//Chama a URL do Servlet
			$.getJSON("/SistemaAvaliacao/FrontController?acao=ConsultaCpf",	{'cpf': cpf}, 
					//Funcao de callback
					function(data, statusTxt, xhr) { 
						if(statusTxt == "success"){
							 $("#idConsumidor1").val(data.id);
							 $("#cpf").val(data.cpf);
							 $("#login").val(data.login);
							 $("#senha").val(data.senha);
							 $("#nomeConsumidor").val(data.nome);
							 $("#telefone").val(data.telefone);
							 $("#email").val(data.email);							 
						}if(statusTxt == "error"){
							alert("Error: " + xhr.status + ": " + xhr.statusText);
						}
					});

		});	
	
	$(window).load(function(){
        $("#modalConsumidor").modal();
        $('#modalConsumidor').attr("data-backdrop", "static");
//        $('#confirmar').attr("data-dismiss", "modal");
    });
	
	$('#anonimo').click(function(){
	    if (this.checked) {
	    	$(".obrigatorio").attr("required", false);
	        $('#modalCampos').hide();
	    }else{
	    	$(".obrigatorio").attr("required", true);
	    	$('#modalCampos').show();	    	
	    }
	});
	
	 $('#formConsumidor').submit(function(e){
		 $('#modalConsumidor').attr("data-dismiss", "modal");		
		e.preventDefault();
		 $.ajax({
	            type: $(this).attr('method'),
	            url: "/SistemaAvaliacao/FrontController?acao=SalvarConsumidor",
	            data: $(this).serialize(),
	            dataType: "json",
	            success: function (data,status) {
	            	 $("#idRespostaFormulario").val(data.idRespostaFormulario);
	            	 $("#idConsumidor2").val(data.idConsumidor);
	            },
	            error: function (xhr, desc, err){	            
	            	alert("Erro: campo já existente");
	            }
	        });
		 $('#modalConsumidor').modal('toggle');
	 });
	
	$('#enviar').click(function(){
		var data = GetTodayDate();
		var respostas = new Array();
		var idPergunta1;
		var comentario= $('#comentario').val();
		var idResposta = $("#idRespostaFormulario").val();
		
		$('.formulinho').each(function(){
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
				$.getJSON('/SistemaAvaliacao/FrontController?acao=SalvarRespostasFormulario',	{'respostas': JSON.stringify(respostas), 'comentario': comentario, 'data': data, "idResposta":idResposta}, 		
						//Funcao de callback
						function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
//						alert(responseTxt.resposta);
						window.location.replace("http://localhost:8080//SistemaAvaliacao/jsp/Obrigado.jsp");
//						$(location).prop('href', '/jsp/Obrigado.jsp')
					}if(statusTxt == "error"){
						alert("Error: " + xhr.status + ": " + xhr.statusText);
					}
						});
			
		});
}); 

function GetTodayDate() {
	   var tdate = new Date();
	   var dd = tdate.getDate(); //yields day
	   var MM = tdate.getMonth(); //yields month
	   var yyyy = tdate.getFullYear(); //yields year
	   var xxx = dd + "-" +( MM+1) + "-" + yyyy;

	   return xxx;
	}