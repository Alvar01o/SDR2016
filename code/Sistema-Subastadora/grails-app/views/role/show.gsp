
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'role.label', default: 'Role')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<div class="container-fluid">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Información Rol</strong></h4>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<g:if test="${roleInstance?.name}">
								<label>Role<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${roleInstance}"  field="name"/>
							
								</g:if>
							</div>
							
						
						</div>
						<g:form>
							</br>
							<fieldset class="buttons">
							<g:link class="btn btn-success" action="edit" id="${roleInstance?.id}"><i class="fa fa-pencil"></i> Editar</g:link>
							</fieldset>
						</g:form>
					</div>
				</div>
			</div>
		</div>
		<!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>

