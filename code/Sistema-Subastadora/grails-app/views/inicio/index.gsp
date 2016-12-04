<!doctype html>
<html lang="en">
<head>
	<meta name="layout" content="template">

</head>
<body>

		<h4> Subastas abiertas</h4>
        <div class="content">
        	
            <div class="container-fluid">
            	
                <div class="row">
                
                
                <g:each in="${auctionInstanceList}" var="auctionInstance">
                 
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-success text-center">
                                            <i class="ti-wallet"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p> ${fieldValue(bean: auctionInstance, field: "product.name")}</p>
                                          		${fieldValue(bean: auctionInstance, field: "product.price")}
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr />
                                    <div class="stats">
                                        <i class="ti-calendar"></i> ${fieldValue(bean: auctionInstance, field: "winner.name")}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                  </g:each>
                  
                  
                
       </div> 
    </div>
</div>

<script src=" ${request.contextPath}/template/js/bootstrap.min.js"></script>
 
<script type="text/javascript">
	
	document.getElementById('li1').className = "active";

</script>



</body>

	<script type="text/javascript">
    	$(document).ready(function(){

        	demo.initChartist();

        	$.notify({
            	icon: 'ti-gift',
            	message: "Welcome to <b>Paper Dashboard</b> - a beautiful Bootstrap freebie for your next project."

            },{
                type: 'success',
                timer: 4000
            });

    	});
	</script>

</html>