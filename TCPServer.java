/*
 * TCP server: listens on the given port and sends the current date and time
 * to every client that connects, then closes that connection.
 *
 *   java TCPServer 6868
 */
import java.io.*;
import java.net.*;
import java.util.Date;

public class TCPServer 
{
	public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java TCPServer <port>");
            return;
        }
 
        int port = Integer.parseInt(args[0]);
 
        try (ServerSocket serverSocket = new ServerSocket(port)) {
 
            System.out.println("Server is listening on port " + port);
 
            while (true) {
                try (Socket socket = serverSocket.accept()) {     // closed after each reply
                    System.out.println("New client connected");
 
                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
 
                    writer.println(new Date().toString());
                }
            }
 
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
