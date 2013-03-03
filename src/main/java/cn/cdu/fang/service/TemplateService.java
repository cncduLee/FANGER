package cn.cdu.fang.service;

import java.util.List;

import cn.cdu.fang.entity.EntityTemplate;

public interface TemplateService {
	public void save(EntityTemplate entity);
	public void update(EntityTemplate entity);
	public void delete(Integer personId);
	public EntityTemplate getEntity(Integer personId);
	public List<EntityTemplate> getEntityTemplates();
}
