package ClientsServerDate;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    public static void main(String[] args) throws IOException {
        int port=8182;
        ServerSocket listener = new ServerSocket(port);
        try{
            while (true){
                Socket socket = listener.accept();
                Runnable client = new ClientHandler(socket);
                Thread thread = new Thread(client);
                thread.start();
            }
        }finally{
            listener.close();
        }
    }
}
class ClientHandler implements Runnable{
    private Socket socket;
    public ClientHandler(Socket socket){this.socket=socket;}
    @Override
    public void run(){
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            out.write(new Date().toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}