package com.cooksys.day_4;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
	
	public static void main (String[] args) {
		
		while (true) {
		try (
			ServerSocket ss = new ServerSocket(8080);
			Socket server = ss.accept();
			InputStream bis = new BufferedInputStream(new DataInputStream(server.getInputStream()));
		) {
			byte[] bytes = new byte[bis.read()];
			bis.read(bytes);
			System.out.println(Arrays.toString(bytes));
		} catch (IOException e) {
			System.out.println("Server was unable to connect to client:");
			e.printStackTrace();
		}
		}
		
	}

}
