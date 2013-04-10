package cn.cdu.fang.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 用户之间 的关系
 * 
 * @author Lee
 */

@Entity
public class FlowShip implements Serializable{
	private static final long serialVersionUID = 3882851752259961449L;
	
	@Id
	@GeneratedValue
	private Integer id;
	@OneToOne(cascade=CascadeType.ALL)
	private User target;//关注对象
	@OneToOne(cascade=CascadeType.ALL)
	private User followed;//发起人
	
	private int status; // 0 for normal, 1 for disabled
	
	private Date createdAt;
	private Date updatedAt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getTarget() {
		return target;
	}
	public void setTarget(User target) {
		this.target = target;
	}
	public User getFollowed() {
		return followed;
	}
	public void setFollowed(User followed) {
		this.followed = followed;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public FlowShip(){}
	public FlowShip(User target, User followed, int status, Date createdAt,
			Date updatedAt) {
		super();
		this.target = target;
		this.followed = followed;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
		FlowShip other = (FlowShip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
