package cn.cdu.fang.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import cn.cdu.fang.constant.ActivityType;
import cn.cdu.fang.constant.Platform;


/**
 * 活动----记录用户操作
 * 做的是什么：{发布消息, 标记, 评论, 设置,关注，}
 * 
 * 
 * 
 * @author Lee
 */
@Entity
public class Activity implements Serializable{
	private static final long serialVersionUID = -1228229594415584643L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private ActivityType type;//类型--做什么
	private Platform platform;//平台
	private String content;//
	
	private String targetSpot;//相关的事件
	private String targetUser;//对象时谁
	private String owner;//发起人
	
	private Date createAt;
	
	
	public Activity(){}
	public Activity(ActivityType type, Platform platform, String content,
			String targetSpot, String targetUser, String owner, Date createAt) {
		super();
		this.type = type;
		this.platform = platform;
		this.content = content;
		this.targetSpot = targetSpot;
		this.targetUser = targetUser;
		this.owner = owner;
		this.createAt = createAt;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ActivityType getType() {
		return type;
	}
	public void setType(ActivityType type) {
		this.type = type;
	}
	public Platform getPlatform() {
		return platform;
	}
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getTargetSpot() {
		return targetSpot;
	}
	public void setTargetSpot(String targetSpot) {
		this.targetSpot = targetSpot;
	}
	public String getTargetUser() {
		return targetUser;
	}
	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
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
		Activity other = (Activity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
