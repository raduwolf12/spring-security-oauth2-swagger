package com.example.model.dto;

/**
 * The Class RoleDto.
 */
public class RoleDto {
	
	/** The id. */
	private Integer id;

	/** The name. */
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
	 * Instantiates a new role dto.
	 */
	public RoleDto() {
		super();
	}

	/**
	 * Instantiates a new role dto.
	 *
	 * @param id the id
	 * @param name the name
	 */
	public RoleDto(Integer id, String name) {
		super();
		this.id = id;
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

}
