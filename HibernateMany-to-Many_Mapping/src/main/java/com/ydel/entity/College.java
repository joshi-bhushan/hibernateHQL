package com.ydel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="college")
public class College {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String collageName;
	@ManyToMany(targetEntity=Student.class,cascade={CascadeType.ALL})
	@JoinTable(name="student",joinColumns={@JoinColumn(name="college_id")},
	
			inverseJoinColumns={@JoinColumn(name="student_id")})
	
	private List<Student> student;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCollageName() {
		return collageName;
	}
	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	
	

}
