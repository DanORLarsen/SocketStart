import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SImpleServer {
    public static void main(String[] args) {
        int port = 8000;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("SERVER KØRER!!!");
            Socket socket = server.accept();
            System.out.println("Connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true)
            {
                double tal = in.readDouble();
                if (tal == 0.0){break;}
            System.out.println(tal);
            double arealNumber = Math.pow(tal,2)*Math.PI;
            System.out.println(arealNumber);
            out.writeDouble(arealNumber);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("SERVER CRASHED!!!!");
        }
    }
}
