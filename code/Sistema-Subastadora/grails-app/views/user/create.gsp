
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
		<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
	</head>
	<body>
        <div class="container-fluid">
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Registrarse</strong></h4>
					</div>
					<div class="panel-body">
						<g:form action="save" >
							<fieldset class="form">
								<g:render template="form"/>
							</fieldset>
							<fieldset class="buttons">
								<br>
								<button type="submit" class="btn btn-primary" name="create" value="${message(code: 'default.button.create.label', default: 'Create')}">
  									<i class="fa fa-floppy-o"></i> Crear  
								</button>
							</fieldset>
						</g:form>						
					</div>
				</div>
			</div>
		</div>
		<!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
	</body>
	
	<script language='javascript' type='text/javascript'>
    function verificar(input) {
        if (input.value != document.getElementById('pass1').value) {
            input.setCustomValidity('La contraseña no coincide.');
        } else {
            input.setCustomValidity('');
        }
    }
</script>
</html>