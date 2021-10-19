package com.UserService.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.UserService.Entity.ERole;
import com.UserService.Entity.Role;



public interface RoleRepository extends CrudRepository<Role, Integer> {

	
	Optional<Role> findByName(ERole name);

}
