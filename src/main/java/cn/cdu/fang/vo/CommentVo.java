package cn.cdu.fang.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
 

public class CommentVo implements Serializable{
	private static final long serialVersionUID = 7153965467224156352L;
	
	private int spotId;
	private String content;
	private String name;
	private String email;
	private String sitAdd;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public int getSpotId() {
		return spotId;
	}
	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}
	
}
