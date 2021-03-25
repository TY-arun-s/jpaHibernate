package com.tyss.jpawithHibernate.oneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name = "jpa_person")
public class Person1 {

	@Id
	@Column
	private int pid;
	@Column
	private String name;

	@Exclude
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aid")
	private Aadhar aadhar;

}
