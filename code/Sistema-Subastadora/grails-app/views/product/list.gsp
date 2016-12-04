<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="template">
<g:set var="entityName" value="${message(code: 'product.label', default: 'Productos')}" />
<title><g:message code="default.create.label" args="[entityName]" /></title>

</head>
<body>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Products</h4>
                                <p class="category">Lista</p>
                                
                                <div class="text-right">
                                
                                		<g:link action="create" class="btn btn-info btn-fill btn-wd" >${}<i class="glyphicon glyphicon-plus"></i> Nuevo Producto</g:link>
                                     	
                                    </div>
                                <div class="clearfix"></div>
                                
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                       <tr> 
                                    	<g:sortableColumn property="name" title="Nombre" />
                                    	<g:sortableColumn property="description" title="Descripcion" />
                                    	<g:sortableColumn property="category" title="Categoria" />
                                    	<g:sortableColumn property="price" title="Precio base" />
                                    	<g:sortableColumn property="shippingInfor" title="Informacion de envio" />
                                    		
                                    	</tr> 
                                    	
                                    	
                                    </thead>
                                    <tbody>
                                    <g:each in="${productInstanceList}" var="productInstance">
                                    
                                        <tr>
                                        	<td>
                                        		${fieldValue(bean: productInstance, field: "name")}
                                        	</td>
                                        	<td>
												${fieldValue(bean: productInstance, field: "description")}
											</td>
											
											<td>
												${fieldValue(bean: productInstance, field: "category")}
											</td>
											
											<td>
												${fieldValue(bean: productInstance, field: "price")}
											
											</td>
												
											<td>
												${fieldValue(bean: productInstance, field: "shippingInfor")}
											</td>
											
											
                                        		
												
												<td class="center">
													<g:link action="show" class="btn btn-primary" id="${productInstance.getId()}">${}<i class="fa fa-eye"></i> Ver Detalle</g:link>
													<g:link action="edit" class="btn btn-success" id="${productInstance.getId()}">${}<i class="fa fa-pencil"></i> Editar</g:link>

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



<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
 
<script type="text/javascript">
	
	document.getElementById('li3').className = "active";

</script>
</body>
 


</html>

