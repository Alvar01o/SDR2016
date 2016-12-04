
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<div class="container-fluid">
			<g:if test="${flash.message}">
			<div class="message" user="status">${flash.message}</div>
			</g:if>
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Usuario</strong></h4>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-6">
								<g:if test="${userInstance?.userName}">
								<label>Usuario<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${userInstance}"  field="userName"/>
								
								</g:if>
							</div>
							
					
					
							<div class="col-md-6">
								<g:if test="${userInstance?.name}">
								
								<label>Nombre<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${userInstance}"  field="name"/>
								
								</g:if>
							</div>
							
							
						
							<div class="col-md-6">
								<g:if test="${userInstance?.lastName}">
								
								
								<label>Apellido<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${userInstance}"  field="lastName"/>
								
								</g:if>
							</div>
							
						
							<div class="col-md-6">
								<g:if test="${userInstance?.address}">
								

								<label>Direccion<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${userInstance}"  field="address"/>
								
								</g:if>
							</div>
							
						
							<div class="col-md-6">
								<g:if test="${userInstance?.email}">
								
								<label>Email<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${userInstance}"  field="email"/>
								
								</g:if>
							</div>
							
							
							<div class="col-md-6">
								<g:if test="${userInstance?.role}">
								
								<label>Role<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${userInstance}"  field="role.name"/>
								
								</g:if>
							</div>
							
						
						</div>
						
					</div>
				</div>
			</div>
		</div>
		<!-- Bootstrap Core JavaScript -->
    <script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
</body>
</html>


