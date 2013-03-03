package cn.cdu.fang.service;

import java.util.List;

import cn.cdu.fang.entity.Activity;;

public interface ActivityService {
	public void save(Activity entity);
	public void update(Activity entity);
	public void delete(Integer id);
	public Activity getEntity(Integer id);
	public List<Activity> getEntities();
}
