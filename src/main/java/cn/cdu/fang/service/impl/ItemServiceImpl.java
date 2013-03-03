package cn.cdu.fang.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.EntityItem;
import cn.cdu.fang.service.ItemService;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void save(EntityItem entity) {
		em.persist(entity);
	}

	@Override
	public void update(EntityItem entity) {
		em.merge(entity);
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.getReference(EntityItem.class, id));
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public EntityItem getEntity(Integer id) {
		return em.find(EntityItem.class, id);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@SuppressWarnings("unchecked")
	@Override
	public List<EntityItem> getEntityItems() {
		return em.createQuery("select item from EntityItem item").getResultList();
	}

}
