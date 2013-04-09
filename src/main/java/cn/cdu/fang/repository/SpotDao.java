package cn.cdu.fang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.cdu.fang.entity.Spot;
/**
 * 常用的方法如下：
 * 
 * 保存：save()
 * 获取一则记录：findOne(Integer id)
 * 获取全部：findAll()
 * 
 * @author Lee
 */
public interface SpotDao extends JpaRepository<Spot, Integer>{
	
	/**
	 * 按类别分页
	 * 
	 * @param category
	 * @param pageable
	 * @return
	 */
	@Query("select s from Spot s where s.category = ?1")
	Page<Spot> findByCategory(String category, Pageable pageable);
	
	/**
	 * 所有spot分页
	 * 如需排序，在pageable中设置排序字段即可
	 * 
	 * @param pageable
	 * @return
	 */
	Page<Spot> findAll(Pageable pageable);
	
	/**
	 * private int commentsCount;
	private int likeCount;
	private int markCount;
	private int shareCount;
	private int downloadCount;
	 * @param spot
	 * @return
	 */
	
	@Modifying
	@Query("update Spot s set s.commentsCount = ?1 where s.id = ?2")
	int setFixedCommentsCountFor(Integer commentsCount,Integer id);
	
	@Query("select s from Spot s where s.name like ?1")
	Page<Spot> findByName(String name, Pageable pageable);
}