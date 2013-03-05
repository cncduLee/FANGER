package cn.cdu.fang.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.Activity;
import cn.cdu.fang.service.ActivityService;


@Transactional
@Service("activityService")
public class ActivityServiceImpl implements ActivityService{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void save(Activity entity) {
		em.persist(entity);
	}

	@Override
	public void update(Activity entity) {
		em.merge(entity);
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.getReference(Activity.class, id));
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public Activity getEntity(Integer id) {
		return em.find(Activity.class, id);
	}

	@Override
	public List<Activity> getEntities() {
		return em.createQuery("select a from Activity a", Activity.class).getResultList();
	}

}
