package cn.cdu.fang.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 图片，图片相关的信息
 * 时间的主角，分享的中心
 * 
 * @author Lee
 */

@Entity
public class Resource implements Serializable{
	private static final long serialVersionUID = 3196068466991876098L;
	
	@Id
	@GeneratedValue
	private Integer id;
	private String resId;//资源的系统标识,及路径
	private Integer[] orgSize;//原始大小
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResId() {
		return resId;
	}
	public void setResId(String resId) {
		this.resId = resId;
	}
	public Integer[] getOrgSize() {
		return orgSize;
	}
	public void setOrgSize(Integer[] orgSize) {
		this.orgSize = orgSize;
	}
	public Resource(String resId, Integer[] orgSize) {
		super();
		this.resId = resId;
		this.orgSize = orgSize;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resource other = (Resource) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
