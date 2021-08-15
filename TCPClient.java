package lesson2;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClient {
    public static void main(String[] args){
        Socket socket=null;
        OutputStream os=null;
        try{
            InetAddress serverIP=InetAddress.getByName("127.0.0.1");//服务器端口和地址
            int port=9999;
            socket=new Socket(serverIP,port);
            os=socket.getOutputStream();
            os.write("投诉皇家洗衣机！".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (os!=null){
                try{
                    os.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
