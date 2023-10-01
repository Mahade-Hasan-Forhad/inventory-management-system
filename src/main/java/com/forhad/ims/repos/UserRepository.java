package com.forhad.ims.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forhad.ims.entities.User;
import com.forhad.ims.util.UserRole;



public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByEmail(String email);

	List<User> findByRole(UserRole manager);


}
