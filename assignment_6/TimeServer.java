// server side code

package assignment_6;

import java.net.*;
import java.util.Date;
import java.io.*;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        ServerSocket servSocket = null;

        try {
            servSocket = new ServerSocket(1313);
        } catch(IOException e) {
            System.err.println("Could not listen on port 1313");
            System.exit(1);
        }

        Socket clientSocket = null;

        for (;;) {
            try {
                clientSocket = servSocket.accept();
            } catch(IOException e) {
                System.err.println("Accept failed");
                System.exit(1);
            }

            ObjectOutputStream timeOut = new ObjectOutputStream(clientSocket.getOutputStream());
            timeOut.writeObject(new Date());
            timeOut.close();
            clientSocket.close();

            //servSocket.close();
        }
    }
}
