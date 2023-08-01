package farrobinha;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is running on port 8080");
            while (true) {
               Socket socket = server.accept();
               DataInputStream in = new DataInputStream(socket.getInputStream());

                System.out.println("Client connected");
                System.out.println("Client IP: " + socket.getInetAddress().getHostAddress());
                System.out.println("Client Port: " + socket.getPort());

                // receive data from client
                byte[] buffer = new byte[1024];
                in.read(buffer);
                System.out.println("Client says: " + new String(buffer).trim());


               server.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}