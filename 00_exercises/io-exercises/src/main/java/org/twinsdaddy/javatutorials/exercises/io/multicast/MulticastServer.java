package org.twinsdaddy.javatutorials.exercises.io.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020/2/15
 */
public class MulticastServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress group = InetAddress.getByName("244.5.6.7");

        MulticastSocket socket = new MulticastSocket();

        String msg = "This is a multicast message";
        for(int i=0; i< 10; i++) {
            byte[] msgB = msg.getBytes();
            DatagramPacket udp = new DatagramPacket(msgB, msgB.length, group, 8888);

            socket.send(udp);

            TimeUnit.SECONDS.sleep(3);
        }

        socket.close();
    }
}
