package UDPServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) throws IOException{
		
		int portN = 1111;
		byte[] inData = new byte[1024];
		byte[] outData = new byte[1024];
		String msg;
		
		//Socket erzeugen
		DatagramSocket socket = new DatagramSocket();
		
		 //Packet bauen und Adressieren
		InetAddress serverIP = InetAddress.getByName("localhost");
		outData = "Ping".getBytes();
		DatagramPacket out = new DatagramPacket(outData,outData.length,serverIP,portN);
		
		//Packet senden
		socket.send(out);
		
		//Antwort empfangen und ausgeben
		DatagramPacket in = new DatagramPacket(inData,inData.length);
		socket.receive(in);
		msg=new String(in.getData(),0,in.getLength());
		System.out.println("Habe bekommen: " + msg);
		
		//Socket schlieﬂen
		socket.close();
	}
}
