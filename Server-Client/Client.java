import java.io.*;
import java.net.Socket;

public class Client
{
	   public void stopCon(BufferedReader BR, OutputStream OS, Socket S)
	   {  try
	      {  if (BR!= null)  
				BR.close();
	         if (OS!= null)  
				OS.close();
	         if (S!= null)  
				S.close();
	         System.out.println("Connection Closed at the client place");
	      }
	      catch(IOException ioe)
	      {  
			System.out.println("Exception Caught while closing connection");
	      }
	   }
	   
  public static void main(String[] args) throws Exception
  {
     Socket S = new Socket(args[0], Integer.parseInt(args[1]));
     String host = args[0];
     BufferedReader BR1 = new BufferedReader(new InputStreamReader(System.in));
     OutputStream OS = S.getOutputStream(); 
     PrintWriter pwrite = new PrintWriter(OS, true);
     InputStream IS = S.getInputStream();
     BufferedReader BR2 = new BufferedReader(new InputStreamReader(IS));

     System.out.println("Connection Established");
 
     String str1, str2; 
     boolean flag = false;
     while(!flag)
     {
        str2 = BR1.readLine();
        pwrite.println(str2); 
        pwrite.flush();   
        if((str1 = BR2.readLine()) != null) //receive from server
        {
        	if(!str1.equalsIgnoreCase("bye"))
        	{
        		System.out.println(host+" :" +str1); 
        	}
        	else
        	{
        		   flag = str1.equalsIgnoreCase("quit");
                   System.out.println("Connection Closed");
                   return;
                  
             }
                
        	}
        		
          
        } 
     S.close();
    }
}
  

  