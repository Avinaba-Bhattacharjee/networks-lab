package assignment_6;

import java.net.*;
import java.util.Date;
import java.io.*;

public class TimeClient {
    public static void main(String[] args) throws IOException {
        Socket timeSocket = null;
        ObjectInputStream timeIn = null;

        try {
            timeSocket = new Socket("localhost", 1313);
            timeIn = new ObjectInputStream(timeSocket.getInputStream());
        } catch(UnknownHostException e) {
            System.err.println("Server localhost can't be reached");
            System.exit(1);
        } catch(IOException e) {
            System.err.println("Error during connection to localhost");
            System.exit(1);
        }
        
        try {
            Date serverDate = (Date)timeIn.readObject();
            System.err.println("Current server time: " + serverDate);
        } catch(ClassNotFoundException e) {
            System.err.println("Not a Date object returned");
            System.exit(1);
        }

        timeIn.close();
        timeSocket.close();
    }
}