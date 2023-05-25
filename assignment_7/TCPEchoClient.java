// Write a program in Java to implement an echo service
// client side code 

package assignment_7;

import java.net.*;
import java.io.*;

public class TCPEchoClient {
    public static void main(String[] args) throws IOException {
        if (args.length < 2 || args.length > 3) {
            throw new IllegalArgumentException("Parameter(s): <server> <word> [<Port>]");
        }

        String server = args[0];
        byte[] byteBuffer = args[1].getBytes();
        int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

        Socket socket = new Socket(server, servPort);
        System.out.println("Connected to server ... sending echo string");

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        out.write(byteBuffer);
        
        int totalBytesRead = 0;
        int bytesRead;

        while (totalBytesRead < byteBuffer.length) {
            if ((bytesRead = in.read(byteBuffer, totalBytesRead, byteBuffer.length - totalBytesRead)) == -1) {
                throw new SocketException("Connection closed permanently");
            }

            totalBytesRead += bytesRead;
        }

        System.out.println("Received: " + new String(byteBuffer));
        socket.close();
    }
}
