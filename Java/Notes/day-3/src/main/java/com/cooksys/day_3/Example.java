package com.cooksys.day_3;

import java.util.ArrayList;
import java.util.List;

public class Example <X> {
	
	private List<X> a = new ArrayList<X>();
	
	public Example (X a) {
		this.a.add(a);
	}

	public List<X> getA() {
		return a;
	}

	public void setA(List<X> a) {
		this.a = a;
	}

}
