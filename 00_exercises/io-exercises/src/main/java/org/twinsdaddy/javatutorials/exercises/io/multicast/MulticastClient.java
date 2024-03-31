package org.twinsdaddy.javatutorials.exercises.io.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created on 2020/2/15
 */
public class MulticastClient {

    public static void main(String[] args) throws IOException {
        InetAddress group = InetAddress.getByName("224.5.6.7");

        MulticastSocket socket = new MulticastSocket(8888);
        socket.joinGroup(group);

        byte[] buff = new byte[256];

        while (true) {
            DatagramPacket udp = new DatagramPacket(buff, buff.length);
            socket.receive(udp);

            String msg = new String(udp.getData());
            System.out.println("Receive Data: " + msg);
        }
    }
}
