package cn.cdu.fang.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.Resource;
import cn.cdu.fang.service.ResourceService;

@Service("resourceService")
@Transactional
public class ResourceServiceImpl implements ResourceService{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void save(Resource entity) {
		em.persist(entity);
	}

	@Override
	public void update(Resource entity) {
		em.merge(entity);
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.getReference(Resource.class, id));
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public Resource getEntity(Integer id) {
		return em.find(Resource.class,id );
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<Resource> getEntities() {
		return em.createQuery("select p from Resource p", Resource.class).getResultList();
	}
	
}
