package com.tyss.jpawithHibernate.oneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "jpa_adhar")
public class Aadhar {

	@Id
	@Column
	private int aid;
	@Column
	private String address;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "aadhar") // foreign key
	private Person1 person;

}
