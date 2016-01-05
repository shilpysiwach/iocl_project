/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
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
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author shilpy
 */
@MultipartConfig
public class FormUpload extends HttpServlet {
private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    private static final String UPLOAD_DIRECTORY = "upload";
    // location to store file uploaded
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
        Part filePart = request.getPart("docsfile");
        
         // obtains input stream of the upload file
        inputStream = filePart.getInputStream(); 
      // Create a factory for disk-based file items
       String uid = request.getParameter("uid");//parameter name to be modified 
        uid = "197";
        Connection conn= null;
        PreparedStatement pS = null;
        ResultSet rst= null;
        int cnt = 0;
         try {
             String fileName = "abc";
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            conn = DriverManager.getConnection(url, "tdps", "hr");
            if(conn!= null){
               String uploadform = "SELECT VARIABLE_VALUES FROM TENDER_BOOK WHERE UNIQUE_ID = " + uid + " for update";
              WriteReadBLOB.writeBLOBStream(conn, inputStream, uploadform);
              uploadform = "SELECT VARIABLE_VALUES FROM TENDER_BOOK WHERE UNIQUE_ID = " + uid;
              WriteReadBLOB.downloadBLOBToFile(conn, uploadform, fileName);
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
