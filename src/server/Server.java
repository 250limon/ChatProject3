package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static final int PORT = 12345;
    private static Map<String, PrintWriter> clientWriters = new HashMap<>();

    //只要知道客户端的名字，就可以获得相应的printwriter对象，然后向客户端发送消息。
    public static void main(String[] args) {//不断接受新的连接
        System.out.println("服务器启动，等待客户端连接...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            //初始化serverSocket，监听端口
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
                //在线新建的线程中进行连接处理，线程设置为内部类
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        //每个线程都拥有自己的一个socket，out,in对象，实现与特定客户端的交流
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;

        }

        public void run() {
            try {
                //in用来接收该客户所发送出的所有信息
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //读取数据，该数据第一行为客户端的名字，第二行及以后为要发送的信息。
                out = new PrintWriter(socket.getOutputStream(), true);
                //发送数据
                //由服务端向客户端发送信息
                //  out.println("请输入你的用户名:");
                clientName = in.readLine();
                //获取用户名
                clientWriters.put(clientName, out);
                //将用户名和PrintWriter对象存入Map中
                System.out.println(clientName + " 已连接");

                String message;
                //客户端发送的消息以@开头，后面跟接收者的用户名和消息。
                //一行只向一个用户发送信息
                while ((message = in.readLine()) != null)//一行一行读取信息
                {
                    System.out.println("收到消息: " + message);
                    if (message.startsWith("@")) {//向某一个人发送消息
                        int spaceIndex = message.indexOf(' ');
                        if (spaceIndex != -1) {
                            String recipient = message.substring(1, spaceIndex);//获取接受者的用户名
                            String content = message.substring(spaceIndex + 1);//获取发给该用户的信息
                            if (clientWriters.containsKey(recipient)) {//如果含有该键值，获取对应的printwriter对象
                                clientWriters.get(recipient).println(content);
                                System.out.println(content);
                            } else {
                                out.println("用户 " + recipient + " 不存在");
                            }
                        }
                    }else {//向所有已连接的人发送消息
                        for (Map.Entry<String, PrintWriter> entry : clientWriters.entrySet()) {
                            if (!entry.getKey().equals(clientName)) {
                                entry.getValue().println(message);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clientWriters.remove(clientName);
                System.out.println(clientName + " 已断开连接");
            }
        }
    }
}