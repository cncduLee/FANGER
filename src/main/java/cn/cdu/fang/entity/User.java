package cn.cdu.fang.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

import cn.cdu.fang.constant.Gender;
import cn.cdu.fang.constant.Role;
import cn.cdu.fang.constant.UserStatus;
import cn.cdu.fang.vo.SignUpVO;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 6509063873201700210L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;//用户名
	
	private String blog;//用户名
	
	@NotNull
	private String email;//邮箱
	
	@NotNull
	private String password;//密码
	
	private Gender gender;//性别
	
	private Role role;//权限
	
	private String summary;//简介
	
	@OneToOne(cascade=CascadeType.ALL)
	private Resource avatar;//头像
	
	@OneToOne(cascade=CascadeType.ALL)
	private Resource avatarOrg;//原始头像

    //注意：使用mappedBy,说明双向关联，使用fetch说明集合采用加载的方式：默认LAZY表示延迟加载，另外一种表示强制加载
    @OneToMany(mappedBy="createdBy",targetEntity=Spot.class,fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Spot> spots = new HashSet<Spot>();
	
	public Date createAt;
	public UserStatus status;
	
	// follow-ship statistic
		private int fansCount;
		private int followCount;
		// spot statistic
		private int spotCount;
		private int trackCount;
		private int forwardCount;
		private int commentCount;
		
		
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
	
	
	public Set<Spot> getSpots() {
		return spots;
	}
	public void setSpots(Set<Spot> spots) {
		this.spots = spots;
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
	
	
	public String getBlog() {
		return blog;
	}
	public void setBlog(String blog) {
		this.blog = blog;
	}
	public int getFansCount() {
		return fansCount;
	}
	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}
	public int getFollowCount() {
		return followCount;
	}
	public void setFollowCount(int followCount) {
		this.followCount = followCount;
	}
	public int getSpotCount() {
		return spotCount;
	}
	public void setSpotCount(int spotCount) {
		this.spotCount = spotCount;
	}
	public int getTrackCount() {
		return trackCount;
	}
	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}
	public int getForwardCount() {
		return forwardCount;
	}
	public void setForwardCount(int forwardCount) {
		this.forwardCount = forwardCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
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
	
	public void addSpot(Spot spot){
		this.spots.add(spot);
		this.spotCount = this.spotCount+1;
		spot.setCreatedBy(this);
	}
}
