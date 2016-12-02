<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="${request.contextPath}/template/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${request.contextPath}/template/assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Subastadora-platform</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="${request.contextPath}/template/assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="${request.contextPath}/template/assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="${request.contextPath}/template/assets/css/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="${request.contextPath}/template/assets/css/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="${request.contextPath}/template/assets/css/themify-icons.css" rel="stylesheet">

	<g:layoutHead/>
</head>
<body>

<div class="wrapper">
	<div class="sidebar" data-background-color="white" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a class="simple-text">
                    Subastadora
                </a>
            </div>

            <ul class="nav">
                <li>
                    <a href="${request.contextPath}/inicio/index/">
                        <i class="ti-home"></i>
                        <p>Inicio</p>
                    </a>
                </li>
                <li>
                    <a href="${request.contextPath}/user/show/">
                        <i class="ti-user"></i>
                        <p>Perfil de Usuario</p>
                    </a>
                </li>
                <li>
                    <a href="${request.contextPath}/product/list/1">
                        <i class="ti-view-list-alt"></i>
                        <p>Mis productos</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="ti-package"></i>
                        <p>Mis subastas</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="ti-wallet"></i>
                        <p>Mis pujas</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="ti-shopping-cart"></i>
                        <p>Libros</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="ti-shopping-cart"></i>
                        <p>Deportes</p>
                    </a>
                </li>
                
                <li>
                    <a href="#">
                        <i class="ti-shopping-cart"></i>
                        <p>Indumentaria</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="ti-shopping-cart"></i>
                        <p>Musica</p>
                    </a>
                </li>
                
            </ul>
    	</div>
    </div>

    <div class="main-panel">
		<nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="#">Acciones</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-bar-chart"></i>
								<p>Estadisticas</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="ti-bell"></i>
                                    <p class="notification">5</p>
									<p>Notificaciones</p>
									<b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                              </ul>
                        </li>
						<li>
                            <a href="#">
								<i class="ti-settings"></i>
								<p>Configuraciones</p>
                            </a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>





		<g:layoutBody/>




        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>

                        <li>
                            <a href="#">
                                Subastadora
                            </a>
                        </li>
                        <li>
                            <a href="#">
                               Blog
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Licencias
                            </a>
                        </li>
                    </ul>
                </nav>
				<div class="copyright pull-right">
                    &copy; <script>document.write(new Date().getFullYear())</script>, Sistemas Distribuidos</a>
                </div>
            </div>
        </footer>


    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="${request.contextPath}/template/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="${request.contextPath}/template/assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="assets/js/bootstrap-checkbox-radio.js"></script>

	<!--  Charts Plugin -->
	<script src="${request.contextPath}/template/assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="${request.contextPath}/template/assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="${request.contextPath}/template/assets/js/paper-dashboard.js"></script>

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="${request.contextPath}/template/assets/js/demo.js"></script>


</html>
