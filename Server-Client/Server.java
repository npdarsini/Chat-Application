
import java.io.*;
import java.net.*;
public class Server
{
	public void stopCon(BufferedReader BR, OutputStream OS, ServerSocket S, Socket Soc)
	   {  try
	      {  if (BR!= null)  
				BR.close();
	         if (OS!= null)  
				OS.close();
	         if (S!= null)  
				S.close();
	         if (Soc!= null)
	        	 Soc.close();
	         System.out.println("Connection Closed at the client place");
	      }
	      catch(IOException ioe)
	      {  
			System.out.println("Exception Caught while closing connection");
	      }
	   }
  public static void main(String[] args) throws Exception
  {
      ServerSocket S = new ServerSocket(Integer.parseInt(args[0]));
      System.out.println("Connecting to Client ...");
      Socket Soc = S.accept( );                          
      BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	  OutputStream OS = Soc.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(OS, true);
      InputStream IS = Soc.getInputStream();
      BufferedReader BR2 = new BufferedReader(new InputStreamReader(IS));
 
      String Str1, Str2; 
      boolean flag = false;
      while(!flag)
      {
        if((Str1 = BR2.readLine()) != null)  
        {
           flag = Str1.equals("bye");
           if(!flag)
             System.out.println("Priya :"+Str1);
           else
           {
             flag = Str1.equalsIgnoreCase("quit");
             System.out.println("Connection Closed");
             return;
            
           }
           
        }         
        Str2 = BR.readLine(); 
 
        pwrite.println(Str2);             
        pwrite.flush();
      } 
    }     
  
}