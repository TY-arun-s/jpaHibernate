package com.tyss.jpawithHibernate.ManyToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "jpa_students")
public class Students {

	@Id
	@Column
	private int sid;
	@Column
	private String sname;

	@Exclude
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "jpa_student_course", joinColumns = @JoinColumn(name = "sid"), inverseJoinColumns = @JoinColumn(name = "cid"))
	private List<Courses> courses; // Unidirectional

}
