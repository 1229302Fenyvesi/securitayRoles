package andreas.fenyvesi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import andreas.fenyvesi.entity.User;
import andreas.fenyvesi.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	@PostMapping({"/registerNewUser"})
	public User registerNewUser(@RequestBody User user) {
		return userService.registerNewUser(user);
	}
	
	public void initRolesAndUser() {
		userService.initRolesAndUser();
	}
	
	@GetMapping({"/forAdmin"})
	public String forAdmin() {
		return "This URL is opnly Acsessable to admin";
	}
	

	@GetMapping({"/forUser"})
	public String forADmin() {
		return "This URL is opnly Acsessable to user";
	}
	
	
}
