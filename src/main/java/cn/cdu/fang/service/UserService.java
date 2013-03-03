package cn.cdu.fang.service;

import java.util.List;

import cn.cdu.fang.entity.User;;

public interface UserService {
	public void save(User entity);
	public void update(User entity);
	public void delete(Integer id);
	public User getEntity(Integer id);
	public List<User> getEntities();
	
	
	public List<User> getUserByEmail(String email);
	public List<User> getUserByName(String name);
}
