<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName"
	value="${message(code: 'user.label', default: 'Role')}" />
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
                                <h4 class="title">Users</h4>
                                <p class="category">Lista</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                       <tr> 
                                    	<g:sortableColumn property="userName" title="Nombre de Usuario" />
                                    	<g:sortableColumn property="name" title="Nombre" />
                                    	<g:sortableColumn property="lastName" title="Apellido" />
                                    	<g:sortableColumn property="address" title="Direccion" />
                                    	<g:sortableColumn property="email" title="Email" />
											
                                    	</tr> 
                                    	
                                    	<tr> 
                                    	
                                    	</tr> 
                                    </thead>
                                    <tbody>
                                    
                                    
                                        <tr>
                                        	<td>
                                        		${fieldValue(bean: userInstance, field: "userName")}
												${fieldValue(bean: userInstance, field: "name")}
												${fieldValue(bean: userInstance, field: "lastName")}
												${fieldValue(bean: userInstance, field: "address")}
												${fieldValue(bean: userInstance, field: "email")}
											</td>
											
                                        		
												
												<td class="center">
													<g:link action="show" class="btn btn-primary" id="${userInstance.getId()}">${}<i class="fa fa-eye"></i> Ver Detalle</g:link>
													<g:link action="edit" class="btn btn-success" id="${userInstance.getId()}">${}<i class="fa fa-pencil"></i> Editar</g:link>

												</td>
                                        	
                                        </tr>
                                       
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

