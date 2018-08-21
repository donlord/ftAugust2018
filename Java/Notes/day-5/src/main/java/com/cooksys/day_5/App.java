package com.cooksys.day_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.cooksys.day_5.ftd.Ftd;
import com.cooksys.day_5.ftd.Instructor;
import com.cooksys.day_5.ftd.Student;
import com.cooksys.day_5.xsd.MySchemaOutputResolver;

/**
 * Hello world!
 *
 */
public class App {

	public static Marshaller createMarshaller(JAXBContext context) {
		try {
			return context.createMarshaller();
		} catch (JAXBException e) {
			System.out.println("Failed to create marshaller");
			e.printStackTrace();
		}
		return null;
	}

	public static Unmarshaller createUnmarshaller(JAXBContext context) {
		try {
			return context.createUnmarshaller();
		} catch (JAXBException e) {
			System.out.println("Failed to create marshaller");
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		JAXBContext context = null;
		try {
			context = JAXBContext.newInstance(Ftd.class, Student.class, Instructor.class);
		} catch (JAXBException e) {
			System.out.println("Failed to create JAXBContext");
			e.printStackTrace();
		}

		Marshaller m = createMarshaller(context);
		Unmarshaller unMarshaller = createUnmarshaller(context);

		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Alex"));
		students.add(new Student("Donny"));
		students.add(new Student("Jacob"));
		students.add(new Student("Jamil"));
		students.add(new Student("Kirk"));
		students.add(new Student("Zac"));

		List<Instructor> instructors = new ArrayList<Instructor>();
		instructors.add(new Instructor("Will"));
		instructors.add(new Instructor("Quinton"));

		Ftd ftd = new Ftd(students, instructors);

		try (Socket client = new Socket("localhost", 8080)) {
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(ftd, client.getOutputStream());
		} catch (JAXBException e) {
			System.out.println("Failed to marshel Ftd Object:");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("File not found:");
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Ftd fastTrackd = (Ftd) unMarshaller.unmarshal(new FileInputStream("ftd.xml"));
			System.out.println(fastTrackd);
		} catch (JAXBException e) {
			System.out.println("Unable to unmarshal xml file:");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("File not found:");
			e.printStackTrace();
		}

		try {
			context.generateSchema(new MySchemaOutputResolver("ftd.xsd"));
		} catch (IOException e) {
			System.out.println("Something when wrong when trying to create xsd File:");
			e.printStackTrace();
		}

	}
}
