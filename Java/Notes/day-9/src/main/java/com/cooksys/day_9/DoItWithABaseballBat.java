package com.cooksys.day_9;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DoItWithABaseballBat {

	BaseballBat batType() default BaseballBat.WOODEN;
	
	boolean shouldDoItWithABaseballBat() default false;
	
}
