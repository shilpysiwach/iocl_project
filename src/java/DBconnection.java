/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.HttpJspPage;
import static jdk.nashorn.internal.objects.NativeFunction.function;

/**
 *
 * @author shilpy
 */
public class DBconnection extends HttpServlet {

    private String url;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("variablevalues.jsp").forward(request, response);
        String mode = request.getParameter("mode");
        String tenderType = request.getParameter("tenderType");
     /*   Enumeration key = request.getParameterNames();
          while(key.hasMoreElements()) {
               String Key = (String)key.nextElement();
               String[] paramValues = request.getParameterValues(Key);
                // Read single valued data
             if (paramValues.length == 1) {
             String paramValue = paramValues[0];
           if (paramValue.length() == 0)
             out.println("<i>No Value</i>");
           else
             out.println(paramValue);
         } else {
             // Read multiple valued data
             out.println("<ul>");
             for(int i=0; i < paramValues.length; i++) {
                out.println("<li>" + paramValues[i]);
             }
             out.println("</ul>");
         }
      } 
               
        Enumeration value = request.getParameterNames(); */
      //  String tenderDt = request.getParameter("tenderDt");
      //  tenderDt = "";
       // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
     //   String date= formatter.format("20151231");
        Connection con = null;
        String tenderId = null;
        PreparedStatement pS = null;
        ResultSet rst = null;
        boolean err = false;
        int cnt = 0;
        int cnt1 = 0;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            con = DriverManager.getConnection(url, "tdps", "hr");
            
            if (con != null) {
                String getTenderID = "select TENDER_ID_SEQ.NEXTVAL from dual";
                pS = con.prepareStatement(getTenderID);
                /*
                String getDeptID = "select DEPT_ID from MST_DEPT where DEPT_ID=?";
                pS = con.prepareStatement(getDeptID);
                 */
                rst = pS.executeQuery();
                if (rst.next()) {
                    tenderId = "" + rst.getInt(1);
                }

                String sqlInsert = "INSERT INTO TENDER_BOOK (UNIQUE_ID,DEPT_ID,LOC_ID,"
                        + " TENDER_ID,CREATED_BY,CREATED_ON,TENDER_TYPE,"
                        + " TENDER_MODE) VALUES(?,?,?,?,?,SYSDATE,?,?)";
                pS = con.prepareStatement(sqlInsert);
                cnt = 0;
                pS.setString(++cnt, tenderId);
                pS.setString(++cnt, "12");
                pS.setString(++cnt, "3300");//user.loc_code
                pS.setString(++cnt, tenderId);
               // pS.setString(++cnt, tenderDt);
                pS.setString(++cnt, "00504623");//user.emp_code);
                pS.setString(++cnt, tenderType);
                pS.setString(++cnt, mode);
                pS.executeQuery();
                con.commit();
            }
        } catch (Exception ee) {
            err = true;
            try {
                con.rollback();
            } catch (Exception ign) {

            } finally {
                if (rst != null) {
                    rst = null;
                    try {
                        rst.close();
                    } catch (Exception ex) {

                    }
                }
                if (pS != null) {
                    pS = null;
                    try {
                        pS.close();
                    } catch (Exception ex) {

                    }
                }
                try {
                    con.close();
                } catch (Exception ig) {

                }
            }
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DBconnection</title>");
            out.println("</head>");
            out.println("<body>");
            if (!err) {
                out.println("<h1> Request saved Successfully </h1>");
            } else {
                out.println("<h1> Request Failed</h1>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
