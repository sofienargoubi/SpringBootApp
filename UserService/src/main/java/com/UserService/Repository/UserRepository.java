package com.UserService.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.UserService.Entity.User;



public interface UserRepository  extends CrudRepository<User, Integer>{
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
