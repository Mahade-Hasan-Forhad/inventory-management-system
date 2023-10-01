package com.forhad.ims.service;

import java.util.List;

import com.forhad.ims.entities.User;
import com.forhad.ims.util.UserRole;

public interface UserService {

	User saveUser(User user);

	User updateUser(User user);

	void deleteUser(User user);

	User getUserById(long id);

	List<User> getUserByEmail(String email);

	List<User> getAllUsers();

	List<User> getManagers();

	void setRole(User user, UserRole role);
}
