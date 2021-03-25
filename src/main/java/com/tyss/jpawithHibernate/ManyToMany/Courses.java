package com.tyss.jpawithHibernate.ManyToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "jpa_courses")
public class Courses {

	@Id
	@Column
	private int cid;
	@Column
	private String cname;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
	private List<Students> students;

}
