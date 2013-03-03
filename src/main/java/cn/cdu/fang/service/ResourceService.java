package cn.cdu.fang.service;

import java.util.List;

import cn.cdu.fang.entity.Resource;

public interface ResourceService {
	public void save(Resource entity);
	public void update(Resource entity);
	public void delete(Integer id);
	public Resource getEntity(Integer id);
	public List<Resource> getEntities();
}
