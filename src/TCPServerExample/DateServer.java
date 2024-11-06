package TCPServerExample;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    public static void main(String[] args) throws IOException {
        int port_ecout = 8189;
        ServerSocket socket = new ServerSocket(port_ecout);
        try{
            while(true){
                Socket client =socket.accept();
                try{
                    new DateToClient(client);
                } finally {
                    client.close();
                }}
        }finally{socket.close();}
    }
}
class DateToClient{
    public DateToClient(Socket socket) throws IOException {
        PrintWriter out=new
                PrintWriter(socket.getOutputStream(), true);
        out.println(new Date().toString());
    }
}