package com.tyss.jpawithHibernate.oneToMany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "jpa_Pencils")
public class Pencils {

	@Id
	@Column
	private int pid;
	@Column
	private String pcolor;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bid")
	private PencilBox box; // Unidirectional

}
