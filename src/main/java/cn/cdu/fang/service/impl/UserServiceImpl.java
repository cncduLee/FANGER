package cn.cdu.fang.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.repository.UserDao;
import cn.cdu.fang.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService, Serializable{
	private static final long serialVersionUID = -2578927194612330917L;
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public void save(User entity) {
		em.persist(entity);
	}
	@Override
	public void update(User entity) {
		em.merge(entity);
	}
	@Override
	public void delete(Integer id) {
		em.remove(em.getReference(User.class,id));
	}
	
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public User getEntity(Integer id) {
		return em.find(User.class, id);
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<User> getEntities() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<User> getUserByEmail(String email) {
		Query query = em.createQuery("select u from User u where u.email=:email", User.class);
		query = query.setParameter("email", email);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<User> getUserByName(String name) {
		Query query = em.createQuery("select u from User u where u.name=:name", User.class);
		query = query.setParameter("name", name);
		return query.getResultList();
	}
	
	
	@Override
	public Page<User> findAll(Pageable pageable) {
		return userDao.findAll(pageable);
	}
	@Override
	public long count() {
		return userDao.count();
	}
	@Override
	public Page<User> findAll(UserStatus status, Role role, Pageable pageable) {
		return userDao.findAll(status, role, pageable);
	}
	@Override
	public long count(UserStatus status, Role role) {
		return userDao.count(status, role);
	}
	
	
}
