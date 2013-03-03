package cn.cdu.fang.service;

import java.util.List;

import cn.cdu.fang.entity.WithSpot;;

public interface WithSpotService {
	public void save(WithSpot entity);
	public void update(WithSpot entity);
	public void delete(Integer id);
	public WithSpot getEntity(Integer id);
	public List<WithSpot> getEntities();
}
