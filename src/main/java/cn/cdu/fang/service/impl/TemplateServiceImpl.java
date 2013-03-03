package cn.cdu.fang.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.EntityTemplate;
import cn.cdu.fang.service.TemplateService;

@Service("templateService")
@Transactional
public class TemplateServiceImpl implements TemplateService {
	@PersistenceContext 
	private EntityManager em;
	
	@Override
	public void save(EntityTemplate entity) {
		em.persist(entity);
	}

	@Override
	public void update(EntityTemplate entity) {
		em.merge(entity);
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.getReference(EntityTemplate.class, id));
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public EntityTemplate getEntity(Integer id) {
		return em.find(EntityTemplate.class, id);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<EntityTemplate> getEntityTemplates() {
		return em.createQuery("select en from EntityTemplate en",EntityTemplate.class).getResultList();
	}

}
