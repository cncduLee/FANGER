package cn.cdu.fang.service;

import java.util.List;

import cn.cdu.fang.entity.Comment;;

public interface CommentService {
	public void save(Comment entity);
	public void update(Comment entity);
	public void delete(Integer id);
	public Comment getEntity(Integer id);
	public List<Comment> getEntities();
}
