/*
 * TCP client: connects to a TCPServer and prints the line it sends back
 * (the server's current date and time).
 *
 *   java TCPClient localhost 6868
 */
import java.net.*;
import java.io.*;

public class TCPClient 
{
	public static void main(String[] args)
	{
        if (args.length < 2) {
            System.out.println("Usage: java TCPClient <host> <port>");
            return;
        }
 
        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
 
        try (Socket socket = new Socket(hostname, port)) {
 
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
            String time = reader.readLine();
 
            System.out.println(time);
 
 
        } catch (UnknownHostException ex) {
 
            System.out.println("Server not found: " + ex.getMessage());
 
        } catch (IOException ex) {
 
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
