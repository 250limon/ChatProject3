package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// 用于与后台程序简历连接的类
public class Connector {
    private static Connector connector=new Connector();
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;
    private Connector()
    {




    }
    public static Connector getInstance()
    {
        return connector;
    }
    public void connect()  {
      try{
          Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
          PrintWriter writer= new PrintWriter(socket.getOutputStream(), true);
          BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));

          PhoneTools.getInstance().setReader(reader);
          PhoneTools.getInstance().setWriter(writer);

      }catch (Exception e)
      {
          e.printStackTrace();
      }



    }
}
