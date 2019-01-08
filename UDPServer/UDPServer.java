package UDPServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		int portN = 1111;
		byte[] inData = new byte[1024];
		byte[] outData = new byte[1024];
		String msg;
		
		DatagramSocket socket = new DatagramSocket(portN);
		
		while(true) {
			DatagramPacket in = new DatagramPacket(inData,inData.length);
			socket.receive(in);
			
			//Informationen über Client sammeln
			InetAddress senderIP = in.getAddress(); 
			int senderPort = in.getPort();
			msg = new String(in.getData(),0,in.getLength());
			System.out.println("Habe bekommen " + msg + " von " + senderIP + "," + senderPort);
			
			//Antwort an Client
			outData = "Pong".getBytes();
			DatagramPacket out = new DatagramPacket(outData,outData.length,senderIP,senderPort);
			socket.send(out);
			socket.close();
		}
	}
}
