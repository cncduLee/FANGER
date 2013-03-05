package cn.cdu.fang.service.impl;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.WithSpot;
import cn.cdu.fang.service.WithSpotService;

@Service("withSpotService")
@Transactional
public class WithSpotServiceImpl implements WithSpotService {
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void save(WithSpot entity) {
		em.persist(entity);
	}

	@Override
	public void update(WithSpot entity) {
		em.merge(entity);
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.getReference(WithSpot.class, id));
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public WithSpot getEntity(Integer id) {
		return em.find(WithSpot.class, id);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<WithSpot> getEntities() {
		return em.createQuery("select w from WithSpot w", WithSpot.class).getResultList();
	}

}
