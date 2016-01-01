<%-- 
    Document   : tender
    Created on : 24 Nov, 2015, 4:38:41 PM
    Author     : shilpy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.theme.css" type="text/css">
        <link rel="stylesheet" href="css/bootstrap.theme.min.css" type="text/css">
        <title>Tenders</title>
        <script>



        </script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">TENDER DOCUMENT PREPARATION SYSTEM</a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li><a href="home.jsp">Home</a></li> 
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

                <div class="col-sm-12 well">
                    <form action="DBconnection" method="processRequest" enctype='multipart/form-data' >
                        <br><br><br>eTender : <input type="radio" name="mode" id="eTender" value="111"> &emsp;
                        Manual : <input type="radio" name="mode" id="manual" value="112"> <br><br><br><br>
                        Type of tenders : <select name="tenderType" id="tenderType" onchange="">
                            <option value="101">Single tender</option>
                            <option value="102">Limited tender</option>
                            <option value="103">Public tender</option>
                            <option value="104">Global tender</option>
                        </select> <br><br><br><br><br><br>      

                        <input type="submit" value="Save and continue" id="generateID"> &emsp;&emsp;&emsp;&emsp;
                        <a href="home.jsp"><input type="button" value="Cancel"></a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
