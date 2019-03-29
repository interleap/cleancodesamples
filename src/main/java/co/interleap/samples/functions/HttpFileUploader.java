package co.interleap.samples.functions;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HttpFileUploader implements Runnable {
  URL connectURL;
  String params;
  String responseString;
  String fileName;
  byte[] dataToServer;
  HttpFileUploader(String urlString, String params, String fileName ){
    try{
      connectURL = new URL(urlString);
    }catch(Exception ex){
      Logger.getLogger("URL FORMATION").log(Level.WARNING,"MALFORMATED URL");
    }
    this.params = params+"=";
    this.fileName = fileName;
  }
  void doStart(FileInputStream stream){
    fileInputStream = stream;
    thirdTry();
  }
  FileInputStream fileInputStream = null;
  void thirdTry(){
    String exsistingFileName = fileName;
    String lineEnd = "\r\n";
    String twoHyphens = "--";
    String boundary = "*****";
    String Tag="3rd";
    try
    {
      //------------------ CLIENT REQUEST
      Logger.getLogger(Tag).log(Level.WARNING,"Starting to bad things");
      Authenticator.setDefault (new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication ("admin", "admin".toCharArray());
        }
      });
      HttpURLConnection conn = (HttpURLConnection) connectURL.openConnection();
      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setUseCaches(false);
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Connection", "Keep-Alive");
      conn.setRequestProperty("Content-Type", "multipart/form-data;boundary="+boundary);
      conn.setConnectTimeout(10000);
      DataOutputStream dos = new DataOutputStream( conn.getOutputStream() );
      writeFormField("login", "admin", dos);
      writeFormField("password", "admin", dos);
      dos.writeBytes(twoHyphens + boundary + lineEnd);
      dos.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=\"" + exsistingFileName +"\"" + lineEnd);
      dos.writeBytes(lineEnd);
      Logger.getLogger(Tag).log(Level.INFO,"Headers are written");
      int bytesAvailable = fileInputStream.available();
      int maxBufferSize = 1024;
      int bufferSize = Math.min(bytesAvailable, maxBufferSize);
      byte[] buffer = new byte[bufferSize];
      // read file and write it into form...
      int bytesRead = fileInputStream.read(buffer, 0, bufferSize);
      while (bytesRead > 0)
      {
        dos.write(buffer, 0, bufferSize);
        bytesAvailable = fileInputStream.available();
        bufferSize = Math.min(bytesAvailable, maxBufferSize);
        bytesRead = fileInputStream.read(buffer, 0, bufferSize);
      }
      // send multipart form data necesssary after file data...
      dos.writeBytes(lineEnd);
      dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
      // close streams
      Logger.getLogger(Tag).log(Level.INFO,"File is written");
      dos.flush();
      dos.close();
      fileInputStream.close();
      InputStream is = conn.getInputStream();
      // retrieve the response from server
      int ch;
      StringBuffer b =new StringBuffer();
      while( ( ch = is.read() ) != -1 ){
        b.append( (char)ch );
      }
      String s=b.toString();
      Logger.getLogger(Tag).log(Level.INFO,"Response",s);
      System.out.println("File writing is done.Judge the success based on the following response - ");
      System.out.println(s);
    }
    catch (MalformedURLException ex)
    {
      Logger.getLogger(Tag).log(Level.SEVERE, "error: " + ex.getMessage(), ex);
    }
    catch (IOException ioe)
    {
      Logger.getLogger(Tag).log(Level.SEVERE,"error: " + ioe.getMessage(), ioe);
    }
  }
  @Override
  public void run() {
    // TODO Auto-generated method stub
  }
  private void writeFormField(String fieldName, String fieldValue, DataOutputStream dataStream)
  {
    String CRLF = "\r\n";
    String twoHyphens = "--";
    String boundary = "*****";
    String Tag="3rd";
    try
    {
      dataStream.writeBytes(twoHyphens + boundary + CRLF);
      dataStream.writeBytes("Content-Disposition: form-data; name=\"" + fieldName + "\"" + CRLF);
      dataStream.writeBytes(CRLF);
      dataStream.writeBytes(fieldValue);
      dataStream.writeBytes(CRLF);
      System.out.println("Form Field Writing successful");
    }
    catch(Exception e)
    {
      System.out.println("GeoPictureUploader.writeFormField: got: " + e.getMessage());
      //Log.e(TAG, "GeoPictureUploader.writeFormField: got: " + e.getMessage());
    }
  }
}