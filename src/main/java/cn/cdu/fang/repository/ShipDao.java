package cn.cdu.fang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.cdu.fang.entity.FlowShip;
import cn.cdu.fang.entity.User;

public interface ShipDao extends JpaRepository<FlowShip,Integer>{
	/**
	 * 传入当前用户，找到当前用户的关注[对象]-----Target
	 * 
	 * @param user 当前用户
	 * @return
	 */
	List<FlowShip> findByFollowed(User user);
	
	/**
	 * 传入当前用户，找到关注当前用户的所有[对象]---Followed
	 * 
	 * @param user 当前用户
	 * @return
	 */
	List<FlowShip> findByTarget(User user);
	
	/**
	 * 根据关注用户，查找关系是否存在
	 * 
	 * @param followed
	 * @param target
	 * @return
	 */
	@Query("select f from FlowShip f where f.followed=?1 and f.target=?2")
	FlowShip findByFollowedAndTarget(User followed,User target);
}
