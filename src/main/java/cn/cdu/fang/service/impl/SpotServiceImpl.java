package cn.cdu.fang.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.service.SpotService;

@Transactional
@Service("spotService")
public class SpotServiceImpl implements SpotService{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void save(Spot entity) {
		em.persist(entity);
	}

	@Override
	public void update(Spot entity) {
		em.merge(entity);
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.getReference(Spot.class, id));
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public Spot getEntity(Integer id) {
		return em.find(Spot.class, id);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<Spot> getEntities() {
		return em.createQuery("select s from Spot s", Spot.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<Spot> getEntitiesByPage(int startPosition, int maxResult) {
		Query query = em.createQuery("select s from Spot s",Spot.class);
		
		query.setFirstResult(startPosition);
		query.setMaxResults(maxResult);
		
		return query.getResultList();
	}

}
