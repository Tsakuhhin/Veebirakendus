
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="windows-1252">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
    
    <script type="text/javascript" charset="utf-8" src="js/kuupaev.js"></script> 
	<script type="text/javascript" charset="utf-8" src="js/jquery.js"></script>
	<script type="text/javascript" charset="utf-8" src="js/lisamine.js"></script>
	<script type="text/javascript" src="js/facebook.js"></script>

    <title>S�ndmuse lisamine</title>


  </head>

  <body>
  
  <!-- HEADER -->
  <div class="container">
  		<div class="navbar">
        	<%@include file='logo.jsp'%>
        	<div class="nav" role="navigation">
        		<div class="navbar navbar-inverse" role="navigation">
					<div class="navbar-inner"></div>
            	<%@include file='header.jsp'%>
        		</div>
    		</div>
		</div>
	</div>
	
	<!-- BODY -->
    <div class="container">
		
      <div class="row row-offcanvas row-offcanvas-right">
		<div class="col-6 col-sm-6 col-lg-8">
            <h2>Lisa uus s�ndmus</h2>
			<%@include file='lisa_sundmus_data.jsp'%>	  
		</div><!--/span-->
       </div><!--/span-->



    </div><!--/.container-->
	
		<!-- FOOTER -->
	<div class="container">
		<div class="col-6 col-sm-6 col-lg-12">
	      <footer>
	        <%@include file='footer.jsp'%>
	      </footer>
	    </div>
	</div><!--/.container-->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="offcanvas.js"></script>	
	
  </body>
</html>
