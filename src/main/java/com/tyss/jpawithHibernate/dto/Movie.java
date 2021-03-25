package com.tyss.jpawithHibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "jpa_movietb")
public class Movie {

	@Id
	@Column(name = "mid")
	private int mid;
	@Column
	private String mname;
	@Column
	private String rating;

}
