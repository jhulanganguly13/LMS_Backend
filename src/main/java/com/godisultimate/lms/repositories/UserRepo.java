package com.godisultimate.lms.repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.godisultimate.lms.model.User;

public interface UserRepo extends JpaRepository<User, Long>{

	public static final String select_u_from_users_u_where = "select u.id as id, u.address as address, u.email as email, u.enabled as enabled, u.first_name as firstName, u.last_name as lastName, u.password as password, u.phone_number as phoneNumber, u.user_code as userCode, u.username as username from users u where ";

	@Query(value=select_u_from_users_u_where
			+ "u.user_code =:userCode ", nativeQuery = true)
	Map<String, Object> findByUserCode(String userCode);
	
	public static final String select_u_from_users_u_where_userid = "select u.id as id, u.address as address, u.email as email, u.enabled as enabled, u.first_name as firstName, u.last_name as lastName, u.password as password, u.phone_number as phoneNumber, u.user_code as userCode, u.username as username from users u where ";

	@Query(value=select_u_from_users_u_where_userid
			+ "u.id !=:userId ", nativeQuery = true)
	List<Map<String, Object>> findByUserListByIdNotIn(long userId);

	User findByUsername(String username);

}
