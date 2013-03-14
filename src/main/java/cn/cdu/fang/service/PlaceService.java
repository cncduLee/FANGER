package cn.cdu.fang.service;

import java.util.List;

import cn.cdu.fang.entity.Place;;

public interface PlaceService {
	public void save(Place entity);
	public void update(Place entity);
	public void delete(Integer id);
	public Place getEntity(Integer id);
	public List<Place> getEntities();
	
	public Place getEntityByFullAdd(String fullAdd);
}
