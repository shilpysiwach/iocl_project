/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author shilpy
 */
@MultipartConfig
public class FormUpload extends HttpServlet {

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
        request.getRequestDispatcher("prequalificationcriteria.jsp").forward(request, response);
        InputStream inputStream = null; // input stream of the upload file
          // obtains the upload file part in this multipart request
        Part filePart = request.getPart("docs-file");
         // obtains input stream of the upload file
        inputStream = filePart.getInputStream();
    
        Connection conn= null;
        PreparedStatement pS = null;
        ResultSet rst= null;
        int cnt = 0;
         try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            conn = DriverManager.getConnection(url, "tdps", "hr");
            if(conn!= null){
               String uploadform = "select variable_values TENDER_BOOK where condition for update (VARIABLE_VALUES,PQC,NIT_CHECKLIST,DECLARATION,SPECIFICATION,TNC,GCC) values(empty_blob(),empty_blob(),empty_blob(),empty_blob(),empty_blob(),empty_blob(),empty_blob())"; 
               pS = conn.prepareStatement(uploadform);
               rst = pS.executeQuery();
             //  if(rst.next()){
                //   Blob blob = rst.getBlob("docs-file");
             //  }
                cnt = 0;
              if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                pS.setBlob(++cnt, inputStream);
           }
                     // sends the statement to the database server
         //   int row = pS.executeUpdate();
          //  if (row > 0) {
            //    String message = "File uploaded and saved into database";
        //    }
              //  pS.setString(++cnt, "");
                pS.setString(++cnt, "");
                pS.setString(++cnt, "");
                pS.setString(++cnt, "");
                pS.setString(++cnt, "");
                pS.setString(++cnt, "");
                pS.setString(++cnt, "");
                pS.executeQuery();
                conn.commit();
            }
           
         } catch(Exception ee){
            String message = "ERROR: " + ee.getMessage();
            ee.printStackTrace();
         }finally{
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
                    conn.close();
                } catch (Exception ig) {

                
            }
            // sets the message in request scope
         //   request.setAttribute("Message", message);
             
            // forwards to the message page
         //   getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
         }
            
            
            
            
            
            
            
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormUpload</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FormUpload at " + request.getContextPath() + "</h1>");
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
