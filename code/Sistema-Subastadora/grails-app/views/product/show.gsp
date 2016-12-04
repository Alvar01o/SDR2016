
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="template">
		<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
	
		<div class="container-fluid">
			<g:if test="${flash.message}">
			<div class="message" product="status">${flash.message}</div>
			</g:if>
        	<div class="row">
            	<div class="panel panel-default">		
                	<div class="panel-heading">
						<h4><strong>Perfil usuario</strong></h4>
					</div>
					<div class="panel-body">
						<div class="row">
							
							
							<div class="col-md-6">
								<g:if test="${productInstance?.name}">
								
								<label>Nombre<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${productInstance}"  field="name"/>
								
								</g:if>
							</div>
							
							
						
							<div class="col-md-6">
								<g:if test="${productInstance?.description}">
								
								
								<label>Descripcion<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${productInstance}"  field="description"/>
								
								</g:if>
							</div>
							
						
							<div class="col-md-6">
								<g:if test="${productInstance?.price}">
								

								<label>Informacion Envio<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${productInstance}"  field="shippingInfor"/>
								
								</g:if>
							</div>
							
						
							<div class="col-md-6">
								<g:if test="${productInstance?.category}">
								
								<label>Categoria<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${productInstance}"  field="category"/>
								
								</g:if>
							</div>
							
							<div class="col-md-6">
								<g:if test="${productInstance?.price}">
								<label>Precio Base<span class="required-indicator">*</span></label>
								<g:fieldValue class="form-control" bean="${productInstance}"  field="price"/>
								
								</g:if>
							</div>
						
						</div>
						<g:form>
							</br>
							<fieldset class="buttons">
							<g:link class="btn btn-success" action="edit" id="${productInstance?.id}"><i class="fa fa-pencil"></i> Editar</g:link>
							</fieldset>
						</g:form>
					</div>
				</div>
			</div>
		</div>
	
	<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
 
<script type="text/javascript">
	
	document.getElementById('li3').className = "active";

</script>
	
	
</body>
</html>



