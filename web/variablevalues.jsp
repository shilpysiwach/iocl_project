<%-- 
    Document   : variablevalues
    Created on : 24 Nov, 2015, 3:40:40 AM
    Author     : shilpy
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.sql.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <title>Form page 1</title>
        <style>
            table, th, td {
    border: 1px solid black;
}
        </style>
        <SCRIPT language="javascript">
          function AddRows() {
              var table=document.getElementById('data');
              var tbody=document.getElementsByTagName('tbody')[0];
              var row=document.createElement('tr');
              var cell1=document.createElement('td');
              var cell2=document.createElement('td');
              var cell1value='';
              cell1value+='<input type="text" name="one" value="">';
              var cell2value='';
              cell2value+='<input type="text" name="two" value="">';
              cell1.innerHTML=cell1value;
              cell2.innerHTML=cell2value;
              row.appendChild(cell1);
              row.appendChild(cell2);
              tbody.appendChild(row);
              alert(table+' '+row+' ');

          }
        </SCRIPT>
        <script language="javascript">
          
}}      </script>
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
        <div class="col-sm-2 sidenav">
        <ul class="nav nav-pills nav-stacked navbar-inverse" role="tablist">
    <li><a href="">Set values to variables</a></li>
    <li><a href="prequalificationcriteria.jsp">Pre qualification criteria</a></li>
    <li><a href="NITchecklistformat.jsp">NIT checklist format</a></li>
    <li><a href="declaration.jsp">Declaration</a></li>
    <li><a href="specification.jsp">Specification</a></li>  
    <li><a href="termsandconditions.jsp">Terms and conditions</a></li>  
    <li><a href="conditionsofcontract.jsp">Conditions of contract</a></li>  
        </ul><br>
        </div>
        <div class="col-sm-8 text-left well"> 
        <form method="processRequest" action="FormUpload" enctype='multipart/form-data'>
        <h3>File Upload:</h3>
        Select a file to upload: <br><br>
        <input type="file" name="file" size="50" />
        <br><br>
        <input type="submit" name="docs-file" value="Upload File" />
        </form>
       
        </div>
        <div class="col-sm-2 sidenav">
        <ul class="nav nav-pills nav-stacked navbar-inverse" role="dropdown">
      <li><a href="Template File/NIT_format.docx">Aviation</a></li>
      <li><a href="Template File/NIT_format.docx">S & D</a></li>
      <li><a href="Template File/NIT_format.docx">Engg. and projects</a></li>
      <li><a href="Template File/NIT_format.docx">Finance</a></li>
      <li><a href="Template File/NIT_format.docx">Internal audit</a></li>
      <li><a href="Template File/NIT_format.docx">HR</a></li>
      <li><a href="Template File/NIT_format.docx">Information systems</a></li>
      <li><a href="Template File/NIT_format.docx">LPG</a></li>
      <li><a href="Template File/NIT_format.docx">Lubes</a></li>
      <li><a href="Template File/NIT_format.docx">M&I</a></li>
      <li><a href="Template File/NIT_format.docx">Operations</a></li>
      <li><a href="Template File/NIT_format.docx">Planning</a></li>
      <li><a href="Template File/NIT_format.docx">Consumer sales</a></li>
      <li><a href="Template File/NIT_format.docx">Quality control</a></li>
      <li><a href="Template File/NIT_format.docx">H,S&E</a></li>
      <li><a href="Template File/NIT_format.docx">Retail sales</a></li>
      <li><a href="Template File/NIT_format.docx">training and library</a></li>
      <li><a href="Template File/NIT_format.docx">Vigilance</a></li>
      <li><a href="Template File/NIT_format.docx">Law</a></li>
      <li><a href="Template File/NIT_format.docx">Corporate communications</a></li>
     
  </ul>
            </div>
        </div>
        </div>
    </body>
    
    
</html>
