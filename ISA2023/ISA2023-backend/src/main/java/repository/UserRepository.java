package repository;

import model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findById(Long id);
	User findByEmail(String email);
	User findByUsername(String username);
	User findByPersonalId(String personalId);
	User findByVerification(String verification);

}
