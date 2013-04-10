package cn.cdu.fang.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.FlowShip;
import cn.cdu.fang.entity.User;
import cn.cdu.fang.repository.ShipDao;
import cn.cdu.fang.service.FlowShipService;

@Service("flowShipService")
@Transactional
public class FlowShipServiceImpl implements FlowShipService {
		
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	ShipDao shipDao;
	
	@Override
	public void save(FlowShip entity) {
		em.persist(entity);
	}

	@Override
	public void update(FlowShip entity) {
		em.merge(entity);
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.getReference(FlowShip.class, id));
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public FlowShip getEntity(Integer id) {
		return em.find(FlowShip.class, id);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<FlowShip> getEntities() {
		return em.createQuery("select f from FlowShip f", FlowShip.class).getResultList();
	}

	@Override
	public List<FlowShip> findByFollowed(User user) {
		return shipDao.findByFollowed(user);
	}

	@Override
	public List<FlowShip> findByTarget(User user) {
		return shipDao.findByTarget(user);
	}

	@Override
	public FlowShip findByFollowedAndTarget(User followed, User target) {
		return shipDao.findByFollowedAndTarget(followed, target);
	}

}
