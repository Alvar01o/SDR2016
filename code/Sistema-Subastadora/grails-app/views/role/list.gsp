
<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'role.label', default: 'Role')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
<asset:stylesheet src="application.css" />
<asset:javascript src="application.js" />
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4>
						<strong>Lista Roles</strong>
					</h4>
				</div>
				<div class="panel-body">
					<g:if test="${flash.message}">
						<div class="message" rolee="status">
							${flash.message}
						</div>
					</g:if>
					
					<g:form action="list">
   					<g:textField name="text" />
   					<g:submitButton name="list" value="Buscar" class="btn btn-primary" />
					</g:form>
					
					
					<div class="dataTable_wrapper">
						<div class="row">
							<div class="col-sm-12">
								<table id="list-report"
									class="table table-striped table-bordered" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<g:sortableColumn property="name" title="Role" />
											
											<td>Acciones</td>
										</tr>
									</thead>
									<tbody>
										<g:each in="${roleInstanceList}" status="i"
										
											var="roleInstance">

											<tr>
												<td>
													${fieldValue(bean: roleInstance, field: "name")}
												</td>
												
												
												<%--  <td>${fieldValue(bean: roleInstance, field: "role.id")}</td>		--%>
												<td class="center">
													<g:link action="show" class="btn btn-primary" id="${roleInstance.getId()}">${}<i class="fa fa-eye"></i> Ver Detalle</g:link>
													<g:link action="edit" class="btn btn-success" id="${roleInstance.getId()}">${}<i class="fa fa-pencil"></i> Editar</g:link>

												</td>
											</tr>

										</g:each>

									</tbody>
								</table>
								<div class="pagination"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br/><br/><br/><br/>
	<!-- jQuery -->
	<script src=" ${request.contextPath}/js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src=" ${request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
