package com.cooksys.xsd;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.cooksys.xsd.jacob.Author;
import com.cooksys.xsd.jacob.Book;
import com.cooksys.xsd.jacob.Librarian;
import com.cooksys.xsd.jacob.Library;
import com.cooksys.xsd.jacob.ObjectFactory;

public class App 
{
	
	public static JAXBContext createContext () {
		try {
			return JAXBContext.newInstance(Author.class, Book.class, Librarian.class, Library.class);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    public static void main( String[] args )
    {
    	ObjectFactory of = new ObjectFactory();
    	Library lib = of.createLibrary();
    	lib.setName("Library of FT");
    	Library.Authors authors = of.createLibraryAuthors();
    	Library.Librarians librarians = of.createLibraryLibrarians();
    	for (int i = 0; i < 10; i++) {
    		Author a = of.createAuthor();
    		a.setName("Rando");
    		for (int j = 0; j < 5; j++) {
    			Book b = of.createBook();
    			b.setDate("today");
    			b.setGenre("Fiction");
    			b.setValue("Book Name");
    			a.getBook().add(b);
    		}
    		authors.getAuthor().add(a);
    	}
    	lib.setAuthors(authors);
    	for (int i = 0; i < 3; i++) {
    		Librarian l = of.createLibrarian();
    		l.setAge(50);
    		l.setSalary(23043);
    		l.setValue("Billy Rando Man");
    		librarians.getLibrarian().add(l);
    	}
    	lib.setLibrarians(librarians);
    	JAXBContext context = createContext();
    	try {
			Marshaller m = context.createMarshaller();
			m.setProperty(m.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(of.createLibrary(lib), new FileOutputStream("jacob.xml"));
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}
