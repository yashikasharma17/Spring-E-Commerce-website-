package com.example.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.buy.User;

@Repository
public interface usersrepo extends JpaRepository<User,Long> {
	public User getByEmail(String email);
	@Transactional
	@Query(value="SELECT setval(pg_get_serial_sequence('users','id'),(SELECT MAX(id) FROM users))",nativeQuery=true)
	void resetUserSequence();
}