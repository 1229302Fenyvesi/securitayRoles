package andreas.fenyvesi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import andreas.fenyvesi.entity.Role;

public interface RoleDao extends JpaRepository<Role, String>{
	

}
