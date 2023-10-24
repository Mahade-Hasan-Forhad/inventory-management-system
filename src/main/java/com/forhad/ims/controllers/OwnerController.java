package com.forhad.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.forhad.ims.entities.User;
import com.forhad.ims.service.UserService;
import com.forhad.ims.util.UserRole;

@Controller
public class OwnerController {

	@Autowired
	private UserService userService;

	// view owner-dashbord
	@RequestMapping("/owner-dashboard")
	public String ownerdashboard() {
		return "owner-dashboard";
	}

	@RequestMapping("/viewManagers")
	public String viewManagers(ModelMap modelMap) {
		if (UserController.isvalidate) {
			List<User> managers = userService.getManagers();
			modelMap.addAttribute("managers", managers);
			return "viewManagers.html";
		} else {
			return "login-register.html";
		}
	}

	@RequestMapping("/deleteManager")
	public String deleteManager(@RequestParam("id") long id, ModelMap modelMap) {
		if (UserController.isvalidate) {
			User manager = userService.getUserById(id);
			if (manager != null && manager.getRole() == UserRole.MANAGER) {
				userService.deleteUser(manager);
				modelMap.addAttribute("msg", "Invalid manager user.");
			}
			return "viewManagers.html";

		} else {
			return "login-register.html";
		}
	}
}
