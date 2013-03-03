package cn.cdu.fang.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import cn.cdu.fang.constant.ShipWithSpot;

/**
 * 用户和一则分享事件的关系
 * 
 * 事件实体 是系统的最基本组成单元。
 * 一个事件，就是一次记录的发布。这个事件记录了
 * 与之相关的所有内容：如事件发布者，事件品论
 * 
 * 与该事件相关的具有喜欢关系的人群。
 * 
 * @author Lee
 */

@Entity
public class Spot implements Serializable{
	private static final long serialVersionUID = 1187557735107950935L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL) 	
	private User createdBy;//创建人
	
	@NotNull
	private Date createdAt;
	private Date updatedAt;//更新时间
	private String category;//分类
	
	@OneToOne(fetch=FetchType.LAZY)
	private Place place;//事发地点
	
	private Double[] lngLat;//经纬度
	
	@OneToOne(fetch=FetchType.LAZY)
	private Resource images;//图片
	private String name;//事件取名
	private String summary;//事件描述
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="target")
	private List<WithSpot> withSpot;//
	@OneToMany(cascade = CascadeType.ALL,mappedBy="spot")
	private List<Comment> comments;
	
	/**
	 * 获取品论数量
	 * @return
	 */
	public int getCommentCount(){
		return this.comments.size();
	}
	
	/**
	 * 获取某类关系的类型数量
	 * 
	 * @param type------类型，包括：和spot间的关系：喜欢、标记、下载
	 * @return
	 */
	public int getXXCountByType(ShipWithSpot type){
		int count = 0;
		for(WithSpot ws : withSpot){
			if(ws.getType().equals(type)) count++;
		}
		return count;
	}
	
	public Spot(User createdBy, Date createdAt, Date updatedAt,
			String category, Place place, Double[] lngLat,
			Resource images, String name, String summary,
			List<WithSpot> withSpot, List<Comment> comments) {
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.category = category;
		this.place = place;
		this.lngLat = lngLat;
		this.images = images;
		this.name = name;
		this.summary = summary;
		this.withSpot = withSpot;
		this.comments = comments;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public Double[] getLngLat() {
		return lngLat;
	}
	public void setLngLat(Double[] lngLat) {
		this.lngLat = lngLat;
	}
	public Resource getImages() {
		return images;
	}
	public void setImages(Resource images) {
		this.images = images;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<WithSpot> getWithSpot() {
		return withSpot;
	}
	public void setWithSpot(List<WithSpot> withSpot) {
		this.withSpot = withSpot;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
		Spot other = (Spot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
