package nexr.nifi_udp_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class clientLauncher {
	 
    public static void main(String[] args) {
        DatagramSocket socket;
        DatagramPacket packet;
        String text = "hello socketProgramming";
        byte[] buf = text.getBytes();
        String serverIp = "127.0.0.1";
        int port = 10000;
        
        try {
            socket = new DatagramSocket();
            packet = new DatagramPacket(buf, buf.length, 
                    InetAddress.getByName(serverIp), port);
           int i = 0;
            while(i<1000){
            	socket.send(packet);
            	i++;
            }
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}