package cn.cdu.fang.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.Place;
import cn.cdu.fang.service.PlaceService;

@Transactional
@Service("palceService")
public class PlaceServiceImpl implements PlaceService{
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void save(Place entity) {
		em.persist(entity);
	}

	@Override
	public void update(Place entity) {
		em.merge(entity);
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.getReference(Place.class, id));
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public Place getEntity(Integer id) {
		return em.find(Place.class,id );
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<Place> getEntities() {
		return em.createQuery("select p from Place p", Place.class).getResultList();
	}
	
}
