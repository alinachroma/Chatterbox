/*
    @author: Alina Khairullina, Egor Yushchenko
    @version: 2018.04.17 
 */


import java.net.*;
import java.io.*;

public class Client {
	
	public static void main(String[] ar) {
		int serverPort = 8007;
		String address = "127.0.0.1";
		
		try {
			InetAddress ipAddress = InetAddress.getByName(address);
			System.out.println("Let's try to contact the server " + address + " with the port " + serverPort + "!");
			Socket socket = new Socket(ipAddress, serverPort);
			System.out.println("Yeah I did it!");

			InputStream sin = socket.getInputStream();
			OutputStream sout = socket.getOutputStream();

			DataInputStream in = new DataInputStream(sin);
			DataOutputStream out = new DataOutputStream(sout);
			BufferedReader keyboard = new BufferedReader (new InputStreamReader(System.in));
			String line = null;
			System.out.println("Lets type and send someting to our server!");
			System.out.println();
			
			while ((line = keyboard.readLine()) != null) {
				
				System.out.println();
				out.writeUTF(line);
				out.flush();
				System.out.println("I've sent the line to the server...and it just sent me back this: " + line);
				System.out.println();
			}
			
			} catch (Exception x) {
			x.printStackTrace();
			}
		}
	}
