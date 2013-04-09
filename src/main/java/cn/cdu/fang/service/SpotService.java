package cn.cdu.fang.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.cdu.fang.entity.Spot;;

public interface SpotService {
	
	public void save(Spot entity);
	public void update(Spot entity);
	public void delete(Integer id);
	public Spot getEntity(Integer id);

	@Deprecated
	public List<Spot> getEntities();
	
	
	/**
	 * 按类别分页
	 * 
	 * @param category
	 * @param pageable
	 * @return
	 */
	Page<Spot> findByCategory(String category, Pageable pageable);
	
	/**
	 * 所有spot分页
	 * 如需排序，在pageable中设置排序字段即可
	 * 
	 * @param pageable
	 * @return
	 */
	Page<Spot> findAll(Pageable pageable);
	
	public long count();
}
