/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleResultSet;
import oracle.sql.BLOB;

/**
 *
 * @author 00504623
 */
public class WriteReadBLOB {

    private static GlobalVariables GV = new GlobalVariables();

  public static void writeBLOBStream(Connection conn, InputStream inputFileInputStream, String sqlText)
          throws IOException, SQLException, ClassNotFoundException {
    //Logger log = LoggerFactory.getLogger(WriteReadBLOB.class);
    //FileInputStream inputFileInputStream = null;
    
    OutputStream blobOutputStream = null;
    Statement stmt = null;
    ResultSet rset = null;
    BLOB uploadFile = null;
    int bufferSize;
    byte[] byteBuffer;
    int bytesRead = 0;
    int totBytesRead = 0;
    int totBytesWritten = 0;
    try {
       Class.forName("oracle.jdbc.OracleDriver");
       String url = "jdbc:oracle:thin:@localhost:1521:XE";
       conn = DriverManager.getConnection(url, "tdps", "hr");
       stmt = conn.createStatement();
       //inputBinaryFile = new File(inputBinaryFileName);
     //  inputFileInputStream = new FileInputStream(inputBinaryFile);
      if (conn != null) {
      sqlText= "SELECT TEMPLATE FROM MST_DEPT WHERE DEPT_ID=101";//modify as per ur rqrmnt
      rset = stmt.executeQuery(sqlText);
      //if (rset != null) {
      rset.next();
      }
      uploadFile = ((OracleResultSet) rset).getBLOB(1);
      bufferSize = uploadFile.getBufferSize();
      // Notice that we are using an array of bytes. This is required 
      // since we will be streaming the content (to either a CLOB or BLOB)
      // as a stream of bytes using an OutputStream Object. This requires
      // that a byte array to be used to temporarily store the contents 
      // that will be sent to the LOB. Note that the use of the byte 
      // array can be used even if we were reading contents from an
      // ASCII text file that would be sent to a CLOB.
      byteBuffer = new byte[bufferSize];
      blobOutputStream = uploadFile.getBinaryOutputStream();
      
      while ((bytesRead = inputFileInputStream.read(byteBuffer)) != -1) {
        // After reading a buffer from the binary file, write the contents
        // of the buffer to the output stream using the write()
        // method.
        blobOutputStream.write(byteBuffer, 0, bytesRead);
        totBytesRead += bytesRead;
        totBytesWritten += bytesRead;
      }
      // Keep in mind that we still have the stream open. Once the stream
      // gets open, you cannot perform any other database operations
      // until that stream has been closed. This even includes a COMMIT
      // statement. It is possible to loose data from the stream if this 
      // rule is not followed. If you were to attempt to put the COMMIT in
      // place before closing the stream, Oracle will raise an 
      // "ORA-22990: LOB locators cannot span transactions" error.
      inputFileInputStream.close();
      blobOutputStream.close();
      //conn.commit();
      rset.close();
      stmt.close();
      //log.info("Wrote file to BLOB column.\n{} bytes read.\n{}bytes written.\n", totBytesRead, totBytesWritten);
    } catch (IOException e) {
      //log.error("Caught I/O Exception: (Write BLOB value - Stream Method).", e);
      //printStackTrace();
    } catch (SQLException e) {
      //log.error("Caught SQL Exception: (Write BLOB value - Stream Method).", e);
      //log.info("SQL: {}\n", sqlText);
      //e.printStackTrace();
    }
  }

  public static void downloadBLOBToFile(Connection conn, String sqlText, String fileName)
          throws IOException, SQLException {
    //Logger log = LoggerFactory.getLogger(WriteReadBLOB.class);
    File outputBinaryFile2 = null;
    FileOutputStream outputFileOutputStream = null;
    InputStream blobInputStream = null;
    Statement stmt = null;
    ResultSet rset = null;
    BLOB dnloadFile = null;
    int chunkSize = 8132;
    byte[] binaryBuffer;
    int bytesRead = 0;
    int totBytesRead = 0;
    int totBytesWritten = 0;
    //snConnectionBean snB = null;
    boolean createNewFile = false;
    try {
      //stmt = conn.createStatement();
      //outputBinaryFile2 = new File(outputBinaryFileName2);
      /*
       outputBinaryFile2 = File.createTempFile("myfile-", ".pdf",
       new File(outputBinaryFileNamePath));
       */
      //outputBinaryFile2 = File.createTempFile("myfile-", ".pdf");  
      //String[] fext = fileName.split(".");
      /*
       String fext = ".pdf";
       int t = fileName.lastIndexOf(".");
       if (t > 0) {
       fext = fileName.substring(t);
       fileName = fileName.substring(0, t);
       }
       */
      String filePath = "Template File/NIT_format.docx";//path of file to be read/display
      //outputBinaryFile2 = File.createTempFile(fileName, fext, new File(filePath));
      outputBinaryFile2 = new File(filePath + "/" + "NIT_format.docx");
      //if (outputBinaryFile2.exists() && outputBinaryFile2.isFile()) {
      //blobInputStream = new FileInputStream(outputBinaryFile2);
      //chunkSize = 2048;
      //} else {
      createNewFile = !(outputBinaryFile2.exists() && outputBinaryFile2.isFile());
      if (createNewFile) {
        outputFileOutputStream = new FileOutputStream(outputBinaryFile2);
        if (conn == null) {
          try {
            //snB = new snConnectionBean();
            //conn = snB.setDbConnection();
          } catch (Exception ignore) {
          }
        }
        stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        rset = stmt.executeQuery(sqlText);
        rset.next();
        dnloadFile = ((OracleResultSet) rset).getBLOB(1);
        // Will use a Java InputStream object to read data from a BLOB (can
        // also be used for a CLOB) object. In this example, we will use an
        // InputStream to read data from a BLOB.
        blobInputStream = dnloadFile.getBinaryStream();
        chunkSize = dnloadFile.getChunkSize();
        binaryBuffer = new byte[chunkSize];
        while ((bytesRead = blobInputStream.read(binaryBuffer)) != -1) {
          // Loop through while reading a chunk of data from the BLOB
          // column using an InputStream. This data will be stored
          // in a temporary buffer that will be written to disk.
          outputFileOutputStream.write(binaryBuffer, 0, bytesRead);
          totBytesRead += bytesRead;
          totBytesWritten += bytesRead;
          outputFileOutputStream.flush();
        }
        outputFileOutputStream.flush();
        outputFileOutputStream.close();
        blobInputStream.close();
        try {
          if (rset != null) {
            rset.close();
          }
        } catch (Exception ign) {
        }
        try {
          if (stmt != null) {
            stmt.close();
          }
        } catch (Exception ign) {
        }
        //log.info("Wrote BLOB column data to file {}.\n{} bytes read.\n{} bytes written.\n",                outputBinaryFile2.getName(), totBytesRead, totBytesWritten);
      }
    } catch (IOException e) {
      //log.error("Caught I/O Exception: (Write BLOB value to file - Streams Method)", e);
      //e.printStackTrace();
      //throw e;
    } catch (SQLException e) {
      //log.error("Caught SQL Exception: (Write BLOB value to file - Streams Method).", e);
      //log.info("SQL:{}\n", sqlText);
      //e.printStackTrace();
      //throw e;
    } finally {
        
        /*
      if (snB != null) {
        snB.setCloseConnection(conn);
      }
      
      /*
       if (createNewFile) {
       try {
       FileInputStream fis = new FileInputStream(outputBinaryFile2);
       binaryBuffer = new byte[chunkSize];
       while ((bytesRead = fis.read(binaryBuffer)) != -1);
       fis.close();
       } catch (Exception ign) {
       }
       }
       */
    }
    try {
                    conn.close();
                } catch (Exception ig) {

                }
  }
}
