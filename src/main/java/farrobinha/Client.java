package farrobinha;

import java.io.DataOutputStream;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {

            Socket client = new Socket("127.0.0.1", 8080);
            System.out.println("Client connected");
            System.out.println("Client IP: " + client.getInetAddress().getHostAddress());
            System.out.println("Client Port: " + client.getLocalPort());

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeBytes("Hello from client");

            client.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
}
