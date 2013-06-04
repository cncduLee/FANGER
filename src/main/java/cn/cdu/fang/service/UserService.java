package cn.cdu.fang.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.entity.User;;

public interface UserService {
	public void save(User entity);
	public void update(User entity);
	public void delete(Integer id);
	public User getEntity(Integer id);
	public List<User> getEntities();
	
	
	public List<User> getUserByEmail(String email);
	public List<User> getUserByName(String name);
	
	
	public Page<User> findAll(Pageable pageable);
	
	public Page<User> findAll(UserStatus status,Role role,Pageable pageable);
	public long count(UserStatus status,Role role);
	public long count();
	
	public User findByEmailAndPassword(String email,String password);
}
