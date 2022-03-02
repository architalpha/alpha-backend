package com.alpha.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alpha.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "select u from User u where u.username like ?1 AND u.password like ?2")
	User fetchUserByUsernameAndPwd(String username,String password);
	
	@Query(value="select u from User u where u.username like ?1 or u.email like ?1 or u.firstname like ?1 or u.firstname like ?1"
			+ " or u.lastname like ?1 or u.createdby like ?1")
	Page<User> search(Pageable pageable, String searchText_);

	Page<User> findAllByisactive(Pageable pageable, Boolean isactive);

	@Query(value = "select u from User u where u.email= ?1")
	Optional<User> findByEmail(String email);
	
	/*@Modifying
	@Query(value = "Update User u SET u.token = ?1 where u.id = ?2")
	void updateToken(Long id);*/
	
	@Query(value = "select u from User u where u.id= ?1 AND u.email =?2")
	Optional<User> findByUserIdandemail(Long username,String email);
	
	@Query(value = "select u from User u where u.username= ?1 or u.email=?1")
	User findByUsernameOrEmail(String username);

	Optional<User> findByUsername(String username);
	Optional<User> findByUsernameOrEmail(String username, String username1);

	@Query(value = "select u from User u where u.username =?1 AND u.id != ?2")
	Optional<User> isusernametaken(String username, Long userId);

	@Query(value = "select u from User u where u.email =?1 AND u.id != ?2")
	Optional<User> isemailtaken(String email, Long userId);

	@Query(value = "select u from User u where u.username= ?1")
	Optional<User> isusernameexist(String username);
	
	@Query(value="select u from User u where u.username= ?1 and u.id !=2")
	//em.createQuery("select u from User u where u.username= '"+userDB.getUsername()+"' and u.id !="+userDB.getId());
	List<User> isUserExistWithUsernameAndId(String username,Long id);
	//User isUserExistWithUsernameAndId(String username,Long id);
	
	@Query(value="select u from User u where u.email= ?1 and u.id !=2")
	//em.createQuery("select u from User u where u.email= '"+userDB.getEmail()+"' and u.id !="+userDB.getId());
	List<User> isUserExistWithEmailAndId(String email,Long id);
	//User isUserExistWithEmailAndId(String email,Long id);
}