<!doctype html>
<html lang="en">
<head>

	<meta name="layout" content="template">
	<title> Subastadora - Perfil de Usuario </title>

	

 
</head>
<body>



        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-4 col-md-5">
                        <div class="card card-user">
                            <div class="image">
                                <img src="${request.contextPath}/template/assets/img/background.jpg" alt="..."/>
                            </div>
                            <div class="content">
                                <div class="author">
                                  <img class="avatar border-white" src="${request.contextPath}/template/assets/img/faces/personaAnonima2.png" alt="..."/>
                                  <h4 class="title">${userInstance?.name} ${userInstance?.lastName}<br />
                                     <a href="#"><small>@${userInstance?.userName}</small></a>
                                  </h4>
                                </div>
                                <p class="description text-center">
                                    "Aquí va la descripcion del usuario <br>
                                    que todavía no  <br>
                                    tiene"
                                </p>
                            </div>
                            <hr>
                            <div class="text-center">
                                <div class="row">
                                    <div class="col-md-3 col-md-offset-1">
                                        <h5>12<br /><small>Subastas</small></h5>
                                    </div>
                                    <div class="col-md-4">
                                        <h5>10<br /><small>Productos</small></h5>
                                    </div>
                                    <div class="col-md-3">
                                        <h5>40<br /><small>Pujas</small></h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Ultimas subastas</h4>
                            </div>
                            <div class="content">
                                <ul class="list-unstyled team-members">
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <div class="avatar">
                                                            <img src="${request.contextPath}/template/assets/img/products/computadora.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        Computadora
                                                        <br />
                                                        <span class="text-muted"><small>Por iniciar</small></span>
                                                    </div>

                                                    <div class="col-xs-3 text-right">
                                                        <btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <div class="avatar">
                                                            <img src="${request.contextPath}/template/assets/img/products/anteojos.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive border-red">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        Anteojos de sol
                                                        <br />
                                                        <span class="text-success"><small>En subasta</small></span>
                                                    </div>

                                                    <div class="col-xs-3 text-right">
                                                        <btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <div class="avatar">
                                                            <img src="${request.contextPath}/template/assets/img/products/cdmusica.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive avatar border-black">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        CD de música
                                                        <br />
                                                        <span class="text-danger"><small>Vendido</small></span>
                                                    </div>

                                                    <div class="col-xs-3 text-right">
                                                        <btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-7">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Editar Perfil</h4>
                            </div>
                            <div class="content">
                            <g:form action="update2">
                                
                            <div class="row">
                                        
                             <div class="col-md-6">
								<label>Nombre de Usuario</label>
								<div class="form-group">
								<g:textField class="form-control border-input" required="" maxlength="50" name="userName"
									placeholder="Ingrese un Nombre"
									value="${userInstance?.userName}" />
								</div>
							</div>
                              <div class="col-md-6">
									<label>Correo Electrónico</label>
									<div class="form-group">
									<g:textField class="form-control border-input" name="email" maxlength="50"
										placeholder="Ingrese su correo electrónico"
										value="${userInstance?.email}" />
									</div>
								</div>

                                <div class="col-md-6">
									<label>Nombre </label>
									<div class="form-group">
									<g:textField class="form-control border-input" required="" maxlength="50" name="name"
										placeholder="Ingrese un Nombre"
										value="${userInstance?.name}" />
									</div>
								</div>
                                
                                <div class="col-md-6">
									<label>Apellido </label>
									<div class="form-group">
									<g:textField class="form-control border-input" required="" maxlength="50" name="lastName"
										placeholder="Ingrese un Apellido" value="${userInstance?.lastName}" />
									</div>
								</div>
	
							
                                <div class="col-md-6">
									<label>Direccion</label>
									<div class="form-group">
									<g:textField class="form-control border-input" name="address" maxlength="50"
										placeholder="Ingrese una Dirección"
										value="${userInstance?.address}" />
									</div>
								</div>
						
                                    
                                  
									
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Sobre mí</label>
                                                <textarea rows="5" class="form-control border-input" placeholder="Aquí puede ir tu descripcion" value="Mike">Esto todavía no tiene
pero queda lindo, así que quizás le agreguemos en un
futuro.</textarea>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    
                                    
                                    <div class="text-center">
                                     	<button type="submit" class="btn btn-info btn-fill btn-wd " name="edit"
										value="${userInstance?.id}">
										<i class="fa fa-primary"></i>Actualizar Perfil</button>
                                    </div>
                                    <div class="clearfix"></div>
                                
                               	</g:form> 
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>


<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
 
<script type="text/javascript">
	
	document.getElementById('li2').className = "active";

</script>



</body>


</html>
