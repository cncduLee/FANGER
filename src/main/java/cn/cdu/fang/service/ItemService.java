package cn.cdu.fang.service;

import java.util.List;

import cn.cdu.fang.entity.EntityItem;

public interface ItemService {
	public void save(EntityItem entity);
	public void update(EntityItem entity);
	public void delete(Integer personId);
	public EntityItem getEntity(Integer id);
	public List<EntityItem> getEntityItems();
}
