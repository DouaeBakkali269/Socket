import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client {
    public static void main(String[] args) {
        String g = "GET / HTTP/1.1\n" + "Host: www.ensias.ma\n\n";
        try {
            Socket socket = new Socket("www.ensias.ma", 80);
            OutputStream out = socket.getOutputStream();
            out.write(g.getBytes());
            InputStream in = socket.getInputStream();
            byte[] b = new byte[1000]; //pour les données renvoyées
            int nbBitsRecus = in.read(b); //effectivementrecues
            if(nbBitsRecus>0) {
                System.out.println(nbBitsRecus + " bits recus.");
                System.out.println("Recu: "+ new String(b,0,nbBitsRecus)); }

            socket.close();
        } catch (IOException ex) { System.err.println(ex);}
    }

}