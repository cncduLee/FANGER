package cn.cdu.fang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.entity.User;

/**
 * account repository
 * 
 * @author Lee
 */
public interface UserDao extends JpaRepository<User, Integer>{
	
	/**
	 * user 分页
	 * 如需排序，在pageable中设置排序字段即可
	 * 
	 * @param pageable
	 * @return
	 */
	Page<User> findAll(Pageable pageable);
	
	/**
	 * 
	 * 
	 * 
	 * @param status  状态
	 * @param role    权限
	 * @param pageable	
	 * @return
	 */
	
	@Query("select u from User u where u.status = ?1 and u.role = ?2")
	Page<User> findAll(UserStatus status,Role role,Pageable pageable);
	
	@Query("select count(*) from User u where u.status = ?1 and u.role = ?2")
	long count(UserStatus status,Role role);
}
