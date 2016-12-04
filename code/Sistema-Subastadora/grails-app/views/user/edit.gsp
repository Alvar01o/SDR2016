
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Editar Informacion</strong>
					</h4>
				</div>
				<div class="panel-body">
					<g:form action="update">
						<fieldset class="form">
							<g:render template="form" />
						</fieldset>
						<fieldset class="buttons">
							<br>
							<div class="col-xs-12" align="center">
									<button type="submit" class="btn btn-primary " name="edit"
										value="${userInstance?.id}">
										<i class="fa fa-primary"></i> Guardar
									</button>
									<a class="btn btn-default" href="/Sistema/user/list"
										role="button"><i class="fa fa-times"></i> Cancelar</a>
							
							</div>
						</fieldset>
					</g:form>
				</div>
			</div>
		</div>
	</div>
	
	 <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
 
<script type="text/javascript">
	window.onload=function() {
		var element = document.getElementById('updater')
		 var selectedValue =  element.options[element.selectedIndex].text; 
		 if (selectedValue == "ROLE_DOCTOR") { 
	    	    document.getElementById('update').style.display = '';
	    }
	};
    
    document.getElementById('li1').onclick = function () {
    	  alert("cambio")
    	};


    	
    </script>
	<script type='text/javascript'>
    function check(input) {
        if (input.value != document.getElementById('pass1').value) {
            input.setCustomValidity('Password Must be Matching.');
        } else {
            input.setCustomValidity('');
        }
    }
</script>

</html>
	