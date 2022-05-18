package NettyStudy.bio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//Bytebuffer 一个指针
//Bytebuff 两个指针 一个指向写 一个指向读



public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress("2606:50c0:8003::153",8888));
        while(true){
            Socket s = ss.accept();//阻塞方法


            new Thread(() ->{
                handle(s);
            }).start();
        }
    }
    static void handle(Socket s){
        try {
            byte[] bytes = new byte[1024];
            int len = s.getInputStream().read(bytes);
            System.out.println(new String(bytes,0,len));

            s.getOutputStream().write(bytes,0,len);
            s.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
