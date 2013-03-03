package cn.cdu.fang.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment implements Serializable{
	private static final long serialVersionUID = 2378527428354792124L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="sid",referencedColumnName="id",unique=true)
	private Spot spot;
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="uid",referencedColumnName="id",unique=true)
	private User createdBy;
	
	private String content;
	
	private Date createdAt;
	private Date updateAt;
	
	private int agreeCount;//赞成数
	private int disagreeCount;//反对数
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Spot getSpot() {
		return spot;
	}
	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public int getAgreeCount() {
		return agreeCount;
	}
	public void setAgreeCount(int agreeCount) {
		this.agreeCount = agreeCount;
	}
	public int getDisagreeCount() {
		return disagreeCount;
	}
	public void setDisagreeCount(int disagreeCount) {
		this.disagreeCount = disagreeCount;
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
		Comment other = (Comment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Comment(Spot spot, User createdBy, String content, Date createdAt,
			Date updateAt, int agreeCount, int disagreeCount) {
		super();
		this.spot = spot;
		this.createdBy = createdBy;
		this.content = content;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
		this.agreeCount = agreeCount;
		this.disagreeCount = disagreeCount;
	}
	
	
}
