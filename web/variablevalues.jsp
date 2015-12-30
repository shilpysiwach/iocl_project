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
    <li><a href="prequalificationcriteria.jsp">Prequalification criteria</a></li>
    <li><a href="NITchecklistformat.jsp">NIT checklist format</a></li>
    <li><a href="declaration.jsp">Declaration</a></li>
    <li><a href="specification.jsp">Specification</a></li>  
    <li><a href="termsandconditions.jsp">Terms and conditions</a></li>  
    <li><a href="conditionsofcontract.jsp">Conditions of contract</a></li>  
        </ul><br>
        </div>
        <div class="col-sm-8 text-left well"> 
    <form method="Post" action="DBconnection">
   
    <table id="data" >
        
        <caption><h2>TABLE</h2></caption>
        <tbody>
        <tr>
            <th>KEY</th> 
            <th>VALUES</th>
        </tr>
        </tbody>
        <%
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Connection con = DriverManager.getConnection(url, "tdps", "hr");
            if (con != null) {
                Statement st = con.createStatement();
                ResultSet result = st.executeQuery("SELECT * FROM TEMPLATE_SHEET");
                while(result.next()){
                    out.println("<tr>");
                    out.println("<td>");
                     out.println(result.getObject("KEY").toString());
                    out.println("</td>");
                    
                    out.println("<td contenteditable='true'>");
                     out.println(result.getObject("VALUE").toString());
                    out.println("</td>");
                    out.println("</tr>");
                }
            }
        
        %>
        
    </table>
            
</form>
        <form method="processRequest" action="DBconnection" enctype='multipart/form-data'>
            <tr>  <input type="Button" value="Add more rows" onClick="AddRows()"> 
            <button type="submit" style="margin-left:550px" onClick="GetID()">Save and continue</button></tr>
            
        </form>
    </div>
            <div class="col-sm-2 sidenav">
                 <ul class="nav nav-pills nav-stacked navbar-inverse" role="dropdown">
    <li src="NIT_format.docx"><a href="">Aviation</a></li>
    <li><a href="">S & D</a></li>
     <li><a href="">Engg. and projects</a></li>
     <li><a href="">Finance</a></li>
     <li><a href="">Internal audit</a></li>
     <li><a href="">HR</a></li>
     <li><a href="">Information systems</a></li>
     <li><a href="">LPG</a></li>
     <li><a href="">Lubes</a></li>
     <li><a href="">M&I</a></li>
     <li><a href="">Operations</a></li>
     <li><a href="">Planning</a></li>
     <li><a href="">Consumer sales</a></li>
     <li><a href="">Quality control</a></li>
     <li><a href="">H,S&E</a></li>
     <li><a href="">Retail sales</a></li>
     <li><a href="">training and library</a></li>
     <li><a href="">Vigilance</a></li>
     <li><a href="">Law</a></li>
     <li><a href="">Corporate communications</a></li>
     
  </ul>
            </div>
        </div>
        </div>
    </body>
    
    
</html>
