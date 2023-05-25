/* Implement a connection-oriented client-server service
 * to send a sentence and receive it in uppercase
 */

// client side code

package assignment_9;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        String sentence;
        String modifiedSentence;
        
        System.out.print("Enter sentence: ");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = null;

        try {
            clientSocket = new Socket("localhost", 2345);
        } catch(UnknownHostException e) {
            System.out.println("Unknown Server");
            System.exit(1);
        }

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + "\n");
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM Server: " + modifiedSentence);

        clientSocket.close();
    }
}
