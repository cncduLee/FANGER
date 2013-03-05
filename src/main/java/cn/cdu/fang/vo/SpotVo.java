package cn.cdu.fang.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


public class SpotVo implements Serializable{
	private static final long serialVersionUID = 3966990710561024639L;
	
	@NotNull
	private String imageUrl;
	@NotNull
	private String category;
	@NotNull
	private String name;
	@NotNull
	private String summary;
	
	private String fullAddr;
	private String placeId;
	private String city;
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getFullAddr() {
		return fullAddr;
	}
	public void setFullAddr(String fullAddr) {
		this.fullAddr = fullAddr;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
