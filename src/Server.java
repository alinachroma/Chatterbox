/*
    @author: Alina Khairullina, Egor Yushchenko
    @version: 2018.04.17 
 */


import java.net.*;
import java.io.*;

public class Server {
	
	public static void main (String[] ar) {
		
		int port = 8007;
		
		try {
			
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Waiting for a client...");
			Socket socket = ss.accept();
			System.out.println("Wow! Looks like the Client is here!");
			System.out.println();
		
			InputStream sin = socket.getInputStream();
			OutputStream sout = socket.getOutputStream();
			DataInputStream in = new DataInputStream(sin);
			DataOutputStream out = new DataOutputStream(sout);
			
			String line = null;
			
			while ((line = in.readUTF()) != null) {
				System.out.println("Got this from Client: " + line);
				System.out.println("I'm an ECHO, so I'm sending all back...");
				out.writeUTF(line); //sending the same String to the Client
				out.flush(); //finishing the sending of all the stuff;
				System.out.println("Give me the next line! Give me give me give me!");
				System.out.println();
			}
			
			sout.close();
			sin.close();
			ss.close();
			} catch(Exception x) { x.printStackTrace(); }
		}
	}
