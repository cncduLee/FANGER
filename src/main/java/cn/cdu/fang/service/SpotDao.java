package cn.cdu.fang.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.cdu.fang.entity.Spot;

public interface SpotDao extends JpaRepository<Spot, Integer>{
	//Page<Spot> paging(PageRequest pageRequest);
}
