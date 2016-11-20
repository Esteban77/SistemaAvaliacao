$(document).ready(function(){
	
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
	            	 $("#idConsumidor").val(data.idConsumidor);
	            },
	            error: function (xhr, desc, err){	            
	            	alert("erro");
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
		
		$('.form').each(function(){
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
						var repostas = responseTxt;
					}if(statusTxt == "error"){
//						alert("Error: " + xhr.status + ": " + xhr.statusText);
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