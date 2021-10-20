package com.example.config;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.entity.Role;
import com.example.model.entity.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

/**
 * The Class DatabasePopulator.
 */
@Component
public class DatabasePopulator {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;

	/** The role repository. */
	@Autowired
	private RoleRepository roleRepository;

	/**
	 * Populate database.
	 */
	@PostConstruct
	public void populateDatabase() {
		if (this.roleRepository.count() == 0) {

		}
		if (this.userRepository.count() == 0) {

			Role admin = new Role();
			admin.setName("ADMIN");

			Role user = new Role();
			user.setName("USER");

			User adminUser = new User("admin", "admin", "");
			Set<Role> roles = new HashSet<Role>();
			roles.add(admin);
			adminUser.setRoles(roles);

			userRepository.save(adminUser);
			roleRepository.save(admin);

			User userUser = new User("user", "user", "");
			Set<Role> roles1 = new HashSet<Role>();
			roles.add(user);
			userUser.setRoles(roles1);

			userRepository.save(userUser);
			roleRepository.save(user);

		}

	}

}
