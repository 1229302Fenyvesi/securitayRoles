package andreas.fenyvesi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import andreas.fenyvesi.entity.User;

public interface UserDao extends JpaRepository<User, String>{

}
