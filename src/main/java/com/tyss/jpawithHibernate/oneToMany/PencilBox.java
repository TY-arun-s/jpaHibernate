package com.tyss.jpawithHibernate.oneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "jpa_PencilBox")
public class PencilBox {

	@Id
	@Column
	private int bid;
	@Column
	private String bname;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "box")
	private List<Pencils> pencils; // Bidirectional

}
