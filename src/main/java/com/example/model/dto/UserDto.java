package com.example.model.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * The Class UserDto.
 */
public class UserDto {
	
	/** The id. */
	private Long id;

	/** The user name. */
	private String userName;

	/** The telefon. */
	private String telefon;

	/** The password. */
	private String password;

	/** The roles. */
	private Set<RoleDto> roles = new HashSet<>();

	/** The enabled. */
	private boolean enabled = true;

	
	/**
	 * Instantiates a new user dto.
	 */
	public UserDto() {
		super();
	}

	/**
	 * Instantiates a new user dto.
	 *
	 * @param id the id
	 * @param userName the user name
	 * @param telefon the telefon
	 * @param password the password
	 * @param enabled the enabled
	 */
	public UserDto(Long id, String userName, String telefon, String password, boolean enabled) {
		super();
		this.id = id;
		this.userName = userName;
		this.telefon = telefon;
		this.password = password;
		this.enabled = enabled;
	}

	/**
	 * Instantiates a new user dto.
	 *
	 * @param id the id
	 * @param userName the user name
	 * @param telefon the telefon
	 * @param password the password
	 * @param roles the roles
	 * @param enabled the enabled
	 */
	public UserDto(Long id, String userName, String telefon, String password, Set<RoleDto> roles, boolean enabled) {
		super();
		this.id = id;
		this.userName = userName;
		this.telefon = telefon;
		this.password = password;
		this.roles = roles;
		this.enabled = enabled;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the telefon.
	 *
	 * @return the telefon
	 */
	public String getTelefon() {
		return telefon;
	}

	/**
	 * Sets the telefon.
	 *
	 * @param telefon the new telefon
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public Set<RoleDto> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(Set<RoleDto> roles) {
		this.roles = roles;
	}

	/**
	 * Checks if is enabled.
	 *
	 * @return true, if is enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Sets the enabled.
	 *
	 * @param enabled the new enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
