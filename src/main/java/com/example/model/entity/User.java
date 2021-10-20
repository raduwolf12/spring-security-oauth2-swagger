package com.example.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.utils.EntityToBeScanned;

/**
 * The Class User.
 * 
 * @author Radu
 */
@Entity
@Table(name = "users")
@EntityToBeScanned
public class User {

	/** The id. */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	private Long id;

	/** The user name. */
	@Column(name = "user_name", length = 100)
	private String userName;

	/** The telefon. */
	@Column(name = "telefon", length = 100)
	private String telefon;

	/** The password. */
	@Column(name = "password", length = 100)
	private String password;

	/** The roles. */
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	/** The enabled. */
	@Column(name = "enabled", length = 100)
	private boolean enabled = true;

	/**
	 * Instantiates a new user.
	 */
	public User() {

	}

	/**
	 * Instantiates a new user.
	 *
	 * @param userName the user name
	 */
	public User(String userName) {
		super();
		this.userName = userName;
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @param telefon the telefon
	 */
	public User(String userName, String password, String telefon) {
		super();
		this.userName = userName;
		this.password = password;
		this.telefon = telefon;
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
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(Set<Role> roles) {
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
