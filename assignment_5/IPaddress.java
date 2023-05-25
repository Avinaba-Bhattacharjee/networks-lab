// Write a program in Java to find the ip address of your local machine or any other machine

package assignment_5;

import java.net.*;

public class IPaddress {
    public static void main(String[] args) {
        InetAddress localAddress = null;

        try {
            localAddress = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("localhost can't be reached");
            System.exit(1);
        }

        System.out.println("localhost address: " + localAddress.getHostAddress());

        try {
        InetAddress address = InetAddress.getByName("qwerqwe131eqwqrgooglexxxx.com");
        System.out.println("IP address: " + address);
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
    }    
}
