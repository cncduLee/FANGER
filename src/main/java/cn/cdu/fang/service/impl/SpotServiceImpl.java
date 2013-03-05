package cn.cdu.fang.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
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

	@Override
	public Spot getEntity(Integer id) {
		return em.find(Spot.class, id);
	}

	@Override
	public List<Spot> getEntities() {
		return em.createQuery("select s from Spot s", Spot.class).getResultList();
	}

}
