package cn.cdu.fang.service;

import java.util.List;

import cn.cdu.fang.entity.FlowShip;;

public interface FlowShipService {
	public void save(FlowShip entity);
	public void update(FlowShip entity);
	public void delete(Integer id);
	public FlowShip getEntity(Integer id);
	public List<FlowShip> getEntities();
}
