<%-- 
    Document   : home
    Created on : 24 Nov, 2015, 2:38:36 AM
    Author     : shilpy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
        <link rel="stylesheet" href="css/bootstrap.theme.min.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <title>Home page</title>
        <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 80%;
      margin: auto;
  }
       </style>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
            <a class="navbar-brand" href="#">TENDER DOCUMENT PREPARATION SYSTEM</a>
            </div>
        <div>
      <ul class="nav navbar-nav">
          <li><a href="#">Home</a></li> 
        <li><a href="about.jsp">About</a></li>
        <li><a href="FAQs.jsp">FAQ's</a></li>
        <li><a href="contact.jsp">Contact</a></li>
      </ul>
       <ul class="nav navbar-nav navbar-right">
       <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
        </div>
        </nav>
     <div class="container-fluid text-center">
        <div class="row-content">
        <div class="col-sm-2 sidenav">
        <ul class="nav nav-pills nav-stacked navbar-inverse" role="tablist">
    <li><a href="tender.jsp">Create tender</a></li>
     <li><a href="tender.jsp">My tenders</a></li>
      <li><a href="tender.jsp">Canceled tenders</a></li>
       <li><a href="tender.jsp">Archived tenders</a></li>
      <li><a href="tender.jsp">Status of tenders</a></li>
      
        </ul>
        </div>
        </div>
       <div id="mycarousel" class="col-sm-8 text-left well carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
    <li data-target="#mycarousel" data-slide-to="1"></li>
    <li data-target="#mycarousel" data-slide-to="2"></li>
    <li data-target="#mycarousel" data-slide-to="3"></li>
    <li data-target="#mycarousel" data-slide-to="4"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="css/DSC_0069.jpg" height="450px" width="850px">
       <div class="carousel-caption">
        <h3>Main Office</h3>
        <p>Indian Oil Corporation, Bhopal.</p>
      </div>
    </div>
      
       <div class="item">
      <img src="css/IMG_20151224_181755.jpg" height="650px" width="850px">
       <h3>Main Office</h3>
        <p>Indian Oil Corporation, Bhopal.</p>
    </div>


    <div class="item">
      <img src="css/40_big.jpg" height="650px" width="850px">
       <h3>Main Office</h3>
        <p>Indian Oil Corporation, Bhopal.</p>
    </div>

    <div class="item">
      <img src="css/Indian-Oil.jpg"height="650px" width="850px" >
       <h3>Main Office</h3>
        <p>Indian Oil Corporation, Bhopal.</p>
    </div>

    <div class="item">
      <img src="css/IOCL1.gif" height="750px" width="850px">
       <h3>Main Office</h3>
        <p>Indian Oil Corporation, Bhopal.</p>
    </div>
  </div>

  <!-- Left and right controls -->
    <a class="left carousel-control" href="#mycarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#mycarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
     </div>
      <script>
$(document).ready(function(){
    // Activate Carousel
    $("#mycarousel").carousel({interval: 2000});
    
    // Enable Carousel Indicators
    $(".item1").click(function(){
        $("#mycarousel").carousel(0);
    });
    $(".item2").click(function(){
        $("#mycarousel").carousel(1);
    });
    $(".item3").click(function(){
        $("#mycarousel").carousel(2);
    });
    $(".item4").click(function(){
        $("#mycarousel").carousel(3);
    });
    
    // Enable Carousel Controls
    $(".left").click(function(){
        $("#mycarousel").carousel("prev");
    });
    $(".right").click(function(){
        $("#mycarousel").carousel("next");
    });
});
</script>
    </body>
   
</html>
