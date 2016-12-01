<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'role.label', default: 'Role')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>

</head>
<body>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Roles</h4>
                                <p class="category">Lista</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                       <tr> 
                                    	<g:sortableColumn property="name" title="Nombre" />
											
                                    	</tr> 
                                    	
                                    	<tr> 
                                    	
                                    	</tr> 
                                    </thead>
                                    <tbody>
                                    <g:each in="${roleInstanceList}" var="roleInstance">
                                    
                                        <tr>
                                        	<td>
												${fieldValue(bean: roleInstance, field: "name")}
											</td>
											
                                        		
												
												<td class="center">
													<g:link action="show" class="btn btn-primary" id="${roleInstance.getId()}">${}<i class="fa fa-eye"></i> Ver Detalle</g:link>
													<g:link action="edit" class="btn btn-success" id="${roleInstance.getId()}">${}<i class="fa fa-pencil"></i> Editar</g:link>

												</td>
                                        	
                                        </tr>
                                        </g:each>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>


                    

                </div>
            </div>
        </div>



    </div>
</div>


</body>



</html>
