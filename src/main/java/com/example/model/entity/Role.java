package com.example.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.utils.EntityToBeScanned;

/**
 * The Class Role.
 * 
 * @author Radu
 */
@Entity
@Table(name = "roles")
@EntityToBeScanned 
public class Role {

	/** The id. */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "role_id")
	private Integer id;

	/** The name. */
	@Column(name = "name")
	private String name;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}