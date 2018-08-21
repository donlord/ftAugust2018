package com.cooksys.day_9;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotatedClassProcessor {

	public void processClass(AnnotatedClass ac) throws NoSuchFieldException, SecurityException {
		System.out.println("------Class Processing Begin---------");

		System.out.println("Class: " + ac.getClass().getName());
		if (ac.getClass().isAnnotationPresent(Position.class)) {
			// process the annotation, "ac" being the instance of the object we are
			// inspecting
			Position anno = ac.getClass().getAnnotation(Position.class);
			System.out.println("Positions: " + anno.positions() );

			System.out.println("------Field Processing---------");
			Field[] fields = ac.getClass().getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(ThemeSong.class)) {
					ThemeSong fAnno = field.getAnnotation(ThemeSong.class);
					System.out.println("Field: " + field.getName());
					System.out.println("Theme Song:" + fAnno.song());
				}
			}

			System.out.println("------Method Processing---------");
			Method[] methods = ac.getClass().getMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(DoItWithABaseballBat.class)) {
					DoItWithABaseballBat mAnno = method.getAnnotation(DoItWithABaseballBat.class);
					System.out.println("Use Baseball Bat? " + mAnno.shouldDoItWithABaseballBat());
					System.out.println("Which BaseballBat? " + mAnno.batType());
				}
			}

		}
		System.out.println("------Class Processing End---------");
		
		Class c = ac.getClass();
		Field f = c.getDeclaredField("name");
		f.setAccessible(true);
		System.out.println(f.isAccessible());
		
	}
}