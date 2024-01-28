package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findById(long id);
	User findByEmail(String email);
	User findByUsername(String username);
	User findByPersonalId(String personalId);
	User findByVerification(String verification);

}
