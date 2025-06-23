package com.example.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.buy.Admins;

@Repository
public interface Adminrepo extends JpaRepository<Admins,Long> {
	public Admins getByEmail(String email);
@Transactional
@Query(value="SELECT setval(pg_get_serial_sequence('admins','id'),(SELECT MAX(id) FROM admins))",nativeQuery=true)
void resetAdminSequence();

}
