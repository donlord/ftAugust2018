package com.cooksys.day_5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.cooksys.day_5.ftd.Ftd;
import com.cooksys.day_5.ftd.Instructor;
import com.cooksys.day_5.ftd.Student;

public class Server {
	
	public static void main (String[] args) {
		try (
				ServerSocket ss = new ServerSocket(8080);
				Socket server = ss.accept();
			) {
			JAXBContext context = JAXBContext.newInstance(Ftd.class, Student.class, Instructor.class);
			Unmarshaller um = context.createUnmarshaller();
			Ftd ftd = (Ftd) um.unmarshal(server.getInputStream());
			
			System.out.println("Server recieved: " + ftd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
