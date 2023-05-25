// server side code

package assignment_9;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws Exception { 
        String sentence, modifiedSentence;

        ServerSocket serverSocket = new ServerSocket(2345);

        while(true) {
            Socket connectionSocket = serverSocket.accept();
            BufferedReader inFromUser = new  BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            sentence = inFromUser.readLine();
            modifiedSentence = sentence.toUpperCase();
            outToClient.writeBytes(modifiedSentence);
            connectionSocket.close();
        }
    }
}
