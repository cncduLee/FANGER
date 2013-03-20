package cn.cdu.fang.service;

import java.util.List;

import cn.cdu.fang.entity.Spot;;

public interface SpotService {
	public void save(Spot entity);
	public void update(Spot entity);
	public void delete(Integer id);
	public Spot getEntity(Integer id);
	public List<Spot> getEntities();
	
	public List<Spot> getEntitiesByPage(int startPosition, int maxResult);
}
