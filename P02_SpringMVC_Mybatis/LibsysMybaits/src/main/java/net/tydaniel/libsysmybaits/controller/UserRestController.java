package net.tydaniel.libsysmybaits.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.tydaniel.libsysmybaits.model.User;
import net.tydaniel.libsysmybaits.services.IUserService;

public class UserRestController {
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	private IUserService userService;
	
	@RequestMapping(value = UserRestURIConstants.GET_ALL_USER, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUser() {
		logger.info("Start getAllUser");
		List<User> users = this.userService.selectAllUsers();		
		return users;
	}
}
