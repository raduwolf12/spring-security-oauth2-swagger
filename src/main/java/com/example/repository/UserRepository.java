package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.entity.User;

/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query(nativeQuery = true, value = "select * from users where name=? and password=?")
	public User getByUserNameAndPassword(String name, String password);

	@Query(nativeQuery = true, value = "select * from users where name=?")
	public User findByName(String userId);
}
