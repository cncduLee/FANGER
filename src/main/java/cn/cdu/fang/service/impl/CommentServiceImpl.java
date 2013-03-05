package cn.cdu.fang.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cdu.fang.entity.Comment;
import cn.cdu.fang.service.CommentService;

@Transactional
@Service("commentService")
public class CommentServiceImpl implements CommentService{
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void save(Comment entity) {
		em.persist(entity);
	}

	@Override
	public void update(Comment entity) {
		em.merge(entity);
	}

	@Override
	public void delete(Integer id) {
		em.remove(em.getReference(Comment.class, id));
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public Comment getEntity(Integer id) {
		return em.find(Comment.class, id);
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	@Override
	public List<Comment> getEntities() {
		return em.createQuery("select c from Comment c", Comment.class).getResultList();
	}

}
