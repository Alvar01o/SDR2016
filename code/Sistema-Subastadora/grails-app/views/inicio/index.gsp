<!DOCTYPE HTML>
<html>
<head>
<title>Subastadora</title>
<link href="${request.contextPath}/css/plugins/bootstrap.css"
	rel="stylesheet">

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${request.contextPath}/js/jquery-1.11.1.min.js"></script>
<!-- Custom Theme files -->
<link href="${request.contextPath}/css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--${request.contextPath}font-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300,700' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!-- Add fancyBox main JS and CSS files -->
		<script src="${request.contextPath}/js/jquery.magnific-popup.js" type="text/javascript"></script>
		<link href="${request.contextPath}/css/magnific-popup.css" rel="stylesheet" type="text/css">
		<script>
			$(document).ready(function() {
				$('.popup-with-zoom-anim').magnificPopup({
					type: 'inline',
					fixedContentPos: false,
					fixedBgPos: true,
					overflowY: 'auto',
					closeBtnInside: true,
					preloader: false,
					midClick: true,
					removalDelay: 300,
					mainClass: 'my-mfp-zoom-in'
			});
		});
		</script>
<script type="text/javascript" src="${request.contextPath}/js/move-top.js"></script>
<script type="text/javascript" src="${request.contextPath}/js/easing.js"></script>
</head>
<body>
	<div class="header_top">	
	  <div class="container">
		  <div class="logo">
			 <a href="index.html"><img src="${request.contextPath}/images/logo.png" alt=""></a>
		  </div>
		  <div class="cssmenu">
				<ul id="nav">
					 <li class="current"><a href="#section-1">Home</a></li>
					 <li><a href="#section-2">About Us</a></li>
					 <li><a href="#section-3">Latest Collection</a></li>
					 <li><a href="#section-4">Latest Video</a></li>
				     <li><a href="#section-5">Contact Us</a></li>
				</ul>
		    </div>
			<div class="clearfix"> </div>
	  	 </div>
	 </div>
	 <div class="wmuSlider example1 section" id="section-1">
			   <article style="position: absolute; width: 100%; opacity: 0;"> 
			   	   <div class="banner-wrap">
			   	   	 <h1>Welcome to</h1>
					 <span></span>
					 <h2>Spring 2014</h2>
				   </div>
				</article>
				<article style="position: absolute; width: 100%; opacity: 0;"> 
				   <div class="banner-wrap">
			   	   	 <h1>Duis autem</h1>
					 <span></span>
					 <h2>Nam libe 2014</h2>
				   </div>
				</article>
				<article style="position: absolute; width: 100%; opacity: 0;"> 
				   <div class="banner-wrap">
			   	   	 <h1> litterarum</h1>
					 <span></span>
					 <h2>Claritas 2014</h2>
				   </div>
				</article>
				<ul class="wmuSliderPagination">
                	<li><a href="#" class="">0</a></li>
                	<li><a href="#" class="">1</a></li>
                	<li><a href="#" class="">2</a></li>
                </ul>
		  </div>
          <script src="${request.contextPath}/js/jquery.wmuSlider.js"></script> 
			<script>
       			$('.example1').wmuSlider();         
   		    </script> 
   	<div class="main">
   	   	  <div class="about section" id="section-2">
   	   	    <div class="container">
   	   	  	 <div class="col-md-8 about_left">
   	   	  	 	<h3>About Fashion</h3>
   	   	  	 	<p class="m_1">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet</p>
   	   	  	    <p class="m_2">Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Typi non habent claritatem insitam; est usus legentis in iis qui facit eorum claritatem. Investigationes demonstraverunt lectores legere me lius quod ii legunt saepius. Claritas est etiam processus dynamicus, qui sequitur mutationem consuetudium lectorum</p>
   	   	  	    	<a href="#" class="btn1 btn-1 btn1-1b">Read More</a>
   	   	  	 </div>
   	   	  	 <div class="col-md-4 about_right">
   	   	  	 	<img src="${request.contextPath}/images/about.png" alt=""/>
   	   	  	 </div>
   	   	  	</div>
   	   	 </div>
   	   	 <div class="portfolio section" id="section-3">
   	   	   <ul class="portfolio_grids">
	  	  	<li>
	  	  		<div class="view view-fifth">
                   <img src="${request.contextPath}/images/p1.jpg" class="img-responsive" alt=""/>
                    <div class="mask">
                      <div class="mask1">
                        <h3>Latest</h3>
                        <h4>Fashion</h4>
                         <a class="popup-with-zoom-anim" href="#small-dialog1"> <div class="info">Next</div></a>
		                     <div id="small-dialog1" class="mfp-hide">
							   <div class="pop_up1">
							   	 <h3>Duis autem vel </h3>
								 <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie.</p>
								 <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie.</p>
								</div>
							 </div>
                        </div>
                     </div>
                  </div>
	  	  	</li>
	  	  	<li>
	  	  		<div class="view view-fifth">
                   <img src="${request.contextPath}/images/p2.jpg" class="img-responsive" alt=""/>
                    <div class="mask">
                      <div class="mask1">
                        <h3>Latest</h3>
                        <h4>Fashion</h4>
                         <a class="popup-with-zoom-anim" href="#small-dialog1"> <div class="info">Next</div></a>
		              </div>
                     </div>
                  </div>
	  	  	</li>
	  	  	<li>
	  	  		<div class="view view-fifth">
                   <img src="${request.contextPath}/images/p3.jpg" class="img-responsive" alt=""/>
                    <div class="mask">
                      <div class="mask1">
                        <h3>Latest</h3>
                        <h4>Fashion</h4>
                         <a class="popup-with-zoom-anim" href="#small-dialog1"> <div class="info">Next</div></a>
		              </div>
                     </div>
                  </div>
	  	  	</li>
	  	  	<li>
	  	  		<div class="view view-fifth">
                   <img src="${request.contextPath}/images/p4.jpg" class="img-responsive" alt=""/>
                    <div class="mask">
                      <div class="mask1">
                        <h3>Latest</h3>
                        <h4>Fashion</h4>
                         <a class="popup-with-zoom-anim" href="#small-dialog1"> <div class="info">Next</div></a>
		              </div>
                     </div>
                  </div>
	  	  	</li>
	  	  	<li>
	  	  		<div class="view view-fifth">
                   <img src="${request.contextPath}/images/p5.jpg" class="img-responsive" alt=""/>
                    <div class="mask">
                      <div class="mask1">
                        <h3>Latest</h3>
                        <h4>Fashion</h4>
                         <a class="popup-with-zoom-anim" href="#small-dialog1"> <div class="info">Next</div></a>
		              </div>
                     </div>
                  </div>
	  	  	</li>
	  	  	<div class="clearfix"></div>
	  	   </ul>
	  	   <ul class="portfolio_grids">
	  	  	<li>
	  	  		<div class="view view-fifth">
                   <img src="${request.contextPath}/images/p6.jpg" class="img-responsive" alt=""/>
                    <div class="mask">
                      <div class="mask1">
                        <h3>Latest</h3>
                        <h4>Fashion</h4>
                         <a class="popup-with-zoom-anim" href="#small-dialog1"> <div class="info">Next</div></a>
		              </div>
                     </div>
                  </div>
	  	  	</li>
	  	  	<li>
	  	  		<div class="view view-fifth">
                   <img src="${request.contextPath}/images/p7.jpg" class="img-responsive" alt=""/>
                    <div class="mask">
                      <div class="mask1">
                        <h3>Latest</h3>
                        <h4>Fashion</h4>
                         <a class="popup-with-zoom-anim" href="#small-dialog1"> <div class="info">Next</div></a>
		              </div>
                     </div>
                  </div>
	  	  	</li>
	  	  	<li>
	  	  		<div class="view view-fifth">
                   <img src="${request.contextPath}/images/p8.jpg" class="img-responsive" alt=""/>
                    <div class="mask">
                      <div class="mask1">
                        <h3>Latest</h3>
                        <h4>Fashion</h4>
                         <a class="popup-with-zoom-anim" href="#small-dialog1"> <div class="info">Next</div></a>
		              </div>
                     </div>
                  </div>
	  	  	</li>
	  	  	<li>
	  	  		<div class="view view-fifth">
                   <img src="${request.contextPath}/images/p9.jpg" class="img-responsive" alt=""/>
                    <div class="mask">
                      <div class="mask1">
                        <h3>Latest</h3>
                        <h4>Fashion</h4>
                         <a class="popup-with-zoom-anim" href="#small-dialog1"> <div class="info">Next</div></a>
		              </div>
                     </div>
                  </div>
	  	  	</li>
	  	    <li>
	  	  		<div class="view view-fifth">
                   <img src="${request.contextPath}/images/p10.jpg" class="img-responsive" alt=""/>
                    <div class="mask">
                      <div class="mask1">
                        <h3>Latest</h3>
                        <h4>Fashion</h4>
                         <a class="popup-with-zoom-anim" href="#small-dialog1"> <div class="info">Next</div></a>
		              </div>
                     </div>
                  </div>
	  	  	</li>
	  	  	<div class="clearfix"></div>
	  	  </ul>
	  	  
		  </div>
		  <div class="video section" id="section-4">
		  	<div class="container">
		  		<div class="row">
		  			<div class="col-md-6 video_frame">
		  				<iframe width="100%" height="350" src="//www.youtube.com/embed/OCSp2RMHbes" frameborder="0" allowfullscreen></iframe>
		  			</div>
		  			<div class="col-md-6 about_left">
		  				<h4 class="m_3">Watch Fashion Latest</h4>
		  				<h5 class="m_4">Videos</h5>
		  			    <div class="video_btn">
		  				  <a href="#" class="btn1 btn-1 btn1-1b">More Videos</a>
		  				</div>
		  			</div>
		  		</div>
		  	</div>
		  </div>
     </div>	
     <div class="contact section" id="section-5">
     	<div class="container">
     		<h3 class="head">Contact Us</h3>
     		<div class="row">
     			<div class="col-md-6">
     				<ul class="list">
     					<li class="list1">
     						<i class="icon1"> </i><p class="address"><span class="phone">Phone :</span> 650)253-0000</p>
     						<div class="clearfix"> </div>
     					</li>
     					<li class="list1">
     						<i class="icon2"> </i><p class="address"><span class="phone">Email :</span><span class="email"><a href="mailto:info(at)fashion.com"> info(at)fashion.com</a></span></p>
     						<div class="clearfix"> </div>
     					</li>
     					<li class="list1">
     						<i class="icon3"> </i><p class="address"><span class="phone">Fax :</span> 650)253-0000</p>
     						<div class="clearfix"> </div>
     					</li>
     					<li class="list1 last">
     						<i class="icon4"> </i><p class="address"><span class="phone">Address :</span> 123 Some Street, Lorem Ipsum</p>
     						<div class="clearfix"> </div>
     					</li>
     				</ul>
     			</div>
     			<div class="col-md-6">
     				<div class="contact-form">
							<form method="post" action="contact-post.html">
								<input type="text" class="textbox" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}">
								<input type="text" class="textbox" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}">
								<textarea value="Message" onfocus="this.value= '';" onblur="if (this.value == '') {this.value = 'Message';}">Message</textarea>
								<label class="btn2 btn-2 btn2-1b"><input type="submit" value="Send"></label>
							</form>
						</div>
     			</div>
     		</div>
     	</div>
     </div> 
     <div class="footer_bottom">
         <div class="container">
           	 <p class="copy">&copy; 2014 Template by <a href="http://w3layouts.com" target="_blank"> w3layouts</a></p>
           	 <ul class="social">
				<li><a href=""> <i class="fb"> </i> </a></li>
				<li><a href=""><i class="rss"> </i> </a></li>
				<li><a href=""><i class="tw"> </i> </a></li>
			</ul>
		 </div>
     </div> 
    <script src="${request.contextPath}/js/jquery.scrollTo.js"></script>
	<script src="${request.contextPath}/js/jquery.nav.js"></script>
	<script>
	$(document).ready(function() {
		$('#nav').onePageNav({
			begin: function() {
			console.log('start')
			},
			end: function() {
			console.log('stop')
			}
		});
	});
	</script>
	<script type="text/javascript">
						$(document).ready(function() {
							/*
							var defaults = {
					  			containerID: 'toTop', // fading element id
								containerHoverID: 'toTopHover', // fading element hover id
								scrollSpeed: 1200,
								easingType: 'linear' 
					 		};
							*/
							
							$().UItoTop({ easingType: 'easeOutQuart' });
							
						});
					</script>
				<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
</body>
</html>		
