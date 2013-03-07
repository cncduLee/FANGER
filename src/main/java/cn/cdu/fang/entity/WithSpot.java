package cn.cdu.fang.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import cn.cdu.fang.constant.ShipWithSpot;

/**
 * 对事件感兴趣的关系，标注为喜欢状态，如果不喜欢则取消
 * 
 * @author Lee
 */

@Entity
public class WithSpot implements Serializable{
	private static final long serialVersionUID = 7267025961598128870L;

	public WithSpot(Spot target, User tracked, ShipWithSpot type, int status,
			Date createdAt, Date updatedAt, int markCount) {
		super();
		this.target = target;
		this.tracked = tracked;
		this.type = type;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.markCount = markCount;
	}

	@Id
	@GeneratedValue
	private Integer id;
	
	
	@ManyToOne
    @JoinColumn(name="sid",referencedColumnName="id")
	private Spot target;
	
	@ManyToOne
    @JoinColumn(name="eid",referencedColumnName="id")
	private User tracked;
	
	private ShipWithSpot type;
	
	private int status; //0代表正常，1代表取消
	
	@NotNull
	private Date createdAt;//创建时间
	private Date updatedAt;//更新时间
	
	private int markCount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Spot getTarget() {
		return target;
	}

	public void setTarget(Spot target) {
		this.target = target;
	}

	public User getTracked() {
		return tracked;
	}

	public void setTracked(User tracked) {
		this.tracked = tracked;
	}

	public ShipWithSpot getType() {
		return type;
	}

	public void setType(ShipWithSpot type) {
		this.type = type;
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

	public int getMarkCount() {
		return markCount;
	}

	public void setMarkCount(int markCount) {
		this.markCount = markCount;
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
		WithSpot other = (WithSpot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
