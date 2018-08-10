package com.cooksys.day_5.ftd;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Ftd {

	@XmlElementWrapper
	@XmlElement(name="student")
	private List<Student> students;
	
	@XmlElementWrapper
	@XmlElement(name="instructor")
	private List<Instructor> instructors;
	
	public Ftd () {}
	
	public Ftd (List<Student> students, List<Instructor> instructors) {
		this.students = students;
		this.instructors = instructors;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}
	
	@Override
	public String toString() {
		return "Ftd [students=" + students + ", instructors=" + instructors + "]";
	}

}
