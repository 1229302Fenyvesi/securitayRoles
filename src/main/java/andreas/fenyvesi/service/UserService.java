package andreas.fenyvesi.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import andreas.fenyvesi.dao.RoleDao;
import andreas.fenyvesi.dao.UserDao;
import andreas.fenyvesi.entity.Role;
import andreas.fenyvesi.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired RoleDao roleDao;
	
	public User registerNewUser(User user) {
		
		return userDao.save(user);
	}
	
	@PostConstruct
	public void initRolesAndUser() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roleDao.save(adminRole);
		
		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for new users");
		roleDao.save(userRole);
		
		User adminUser = new User();
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserName("admin123");
		adminUser.setUserPassword("admin@pass");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		registerNewUser(adminUser);
		
		User user = new User();
		user.setUserFirstName("Andreas");
		user.setUserLastName("Fenyvesi");
		user.setUserName("Andreas123");
		user.setUserPassword("Andreas@pass");
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles);
		registerNewUser(user);
		
	}
}
