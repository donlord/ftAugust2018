package com.cooksys.day_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File path = new File("tezt.txt");
        System.out.println(Arrays.toString(path.list()));
        System.out.println(path.isDirectory());
        System.out.println(path.getAbsolutePath());
        
        try (
        		InputStream fis = new FileInputStream(path);
                OutputStream fos = new FileOutputStream("newTezt.txt");
        	) {
			byte[] bytes = new byte[fis.available()];
			fis.read(bytes);
			System.out.println(Arrays.toString(bytes));
			fos.write(bytes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			
		}
    }
}
