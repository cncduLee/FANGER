package cn.cdu.fang.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import cn.cdu.fang.constant.Gender;
import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.vo.SignUpVO;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 6509063873201700210L;
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;//用户名
	
	@NotNull
	private String email;//邮箱
	
	@NotNull
	private String password;//密码
	
	private Gender gender;//性别
	
	private Role role;//权限
	
	private String summary;//简介
	
	@OneToOne(fetch=FetchType.LAZY)
	private Resource avatar;//头像
	@OneToOne(fetch=FetchType.LAZY)
	private Resource avatarOrg;//原始头像
	
	public Date createAt;
	public UserStatus status;
	
	
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Resource getAvatar() {
		return avatar;
	}
	public void setAvatar(Resource avatar) {
		this.avatar = avatar;
	}
	public Resource getAvatarOrg() {
		return avatarOrg;
	}
	public void setAvatarOrg(Resource avatarOrg) {
		this.avatarOrg = avatarOrg;
	}
	
	
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public User(String username, String email, String password, Gender gender,
			String summary, Resource avatar, Resource avatarOrg) {
		this.name = username;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.summary = summary;
		this.avatar = avatar;
		this.avatarOrg = avatarOrg;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public User(){}
	
	
	
	public static User builtByVo(SignUpVO vo){
		
		User user = new User();
		user.setEmail(vo.getEmail());
		user.setGender(Gender.UNKNOWN);
		user.setName(vo.getName());
		user.setPassword(vo.getPassword());
		user.setRole(Role.USER);
		user.setCreateAt(new Date());
		user.setStatus(UserStatus.VALID);
		
		return user;
	}
}
