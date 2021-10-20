package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.entity.Role;

/**
 * The Interface RoleRepository.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
