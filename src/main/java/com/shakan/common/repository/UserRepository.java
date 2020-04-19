package com.shakan.common.repository;
import java.util.Optional;

import com.shakan.common.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * UserテーブルのJPAインターフェイス
 */
@Repository
public interface  UserRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByUserId(String userId);
    Boolean existsByUserId(String userId);

	Optional<Users> findByPassword(String password);
	Boolean existsByPassword(String password);

}