package cn.cdu.fang.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.repository.SpotDao;
import cn.cdu.fang.service.SpotService;

@Transactional
@Service("spotService")
public class SpotServiceImpl implements SpotService{
	
	@PersistenceContext
	EntityManager em;
	@Autowired
	SpotDao spotDao;
	
	@Override
	public void save(Spot entity) {
		spotDao.save(entity);
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
		return spotDao.findOne(id);
	}

	@Override
	public List<Spot> getEntities() {
		return spotDao.findAll();
	}

	@Override
	public Page<Spot> findAll(Pageable pageable) {
		return spotDao.findAll(pageable);
	}

	@Override
	public Page<Spot> findByCategory(String category, Pageable pageable) {
		return spotDao.findByCategory(category, pageable);
	}

	@Override
	public long count() {
		return spotDao.count();
	}

}
