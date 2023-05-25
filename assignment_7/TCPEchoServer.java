// server side code

package assignment_7;

import java.net.*;
import java.io.*;

public class TCPEchoServer {
    private static final int BUFSIZE = 80;
    
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Parameter(s): <Port>");
        }

        int servPort = Integer.parseInt(args[0]);
        ServerSocket servSocket = new ServerSocket(servPort);

        int recvMsgSize;
        byte[] byteBuffer = new byte[BUFSIZE];

        for (;;) {
            Socket clientSocket = servSocket.accept();
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();

            while ((recvMsgSize = in.read(byteBuffer)) != -1) {
                out.write(byteBuffer, 0, recvMsgSize);
            }

            clientSocket.close();
        }
    }
}
