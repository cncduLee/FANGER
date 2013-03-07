package cn.cdu.fang.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.hibernate.validator.constraints.Length;

import cn.cdu.fang.vo.CommentVo;

@Entity
public class Comment implements Serializable{
	private static final long serialVersionUID = 2378527428354792124L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name="sid",referencedColumnName="id")
	private Spot spot;
	
	@ManyToOne
    @JoinColumn(name="uid",referencedColumnName="id")
	private User createdBy;
	
	@NotNull
	@Length(max=1024)
	private String content;
	
	private Date createdAt;
	private Date updateAt;
	
	private int agreeCount;//赞成数
	private int disagreeCount;//反对数
	
	//======匿名评论=======//
	private String name;
	private String email;
	private String sitAdd;
	//======匿名评论=======//
	
	public Comment(){}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSitAdd() {
		return sitAdd;
	}

	public void setSitAdd(String sitAdd) {
		this.sitAdd = sitAdd;
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
	
	/****登陆用户评论****/
	public void voToComment(CommentVo vo,User signUser,Spot spot){
		this.setContent(vo.getContent());
		this.setCreatedBy(signUser);
		this.setCreatedAt(new Date());
		this.setSpot(spot);
	}
	/***匿名评论***/
	public void voToComment(CommentVo vo,Spot spot){
		
		this.setContent(vo.getContent());
		this.setSitAdd(vo.getSitAdd());
		this.setEmail(vo.getEmail());
		this.setName(vo.getName());
		
		this.setCreatedAt(new Date());
		this.setSpot(spot);
	}
}
