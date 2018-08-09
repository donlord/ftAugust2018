package com.cooksys.day_4;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Client {
	
	public static void main (String[] args) {
		
		try (
			Socket client = new Socket("localhost", 8080);
			OutputStream bos = new BufferedOutputStream(new DataOutputStream(client.getOutputStream()));
			InputStream fis = new FileInputStream("tezt.txt");
		) {
			byte[] bytes = new byte[fis.available()];
			fis.read(bytes);
			System.out.println(Arrays.toString(bytes));
			bos.write(bytes.length);
			bos.write(bytes);
			bos.flush();
			
		} catch (IOException e) {
			System.out.println("Failed to connect to localhost on port 8080");
			e.printStackTrace();
		}
	}

}
