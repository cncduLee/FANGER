package cn.cdu.fang.android.vo;

import java.io.Serializable;

import cn.cdu.fang.constant.Gender;
import cn.cdu.fang.entity.User;



public class AndrUser implements Serializable{
	private static final long serialVersionUID = 3209182876694283259L;
	
	private Integer id;
	private String name;//用户名
	private String email;//邮箱
	private String password;//密码
	private Gender gender;//性别
	
	public AndrUser(){}

	public AndrUser(String name, String email, String password, Gender gender) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
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
	
	/**
	 * 转换
	 * @param user
	 * @return
	 */
	public static AndrUser convertTo(User user){
		AndrUser au = new AndrUser();
		au.setId(user.getId());
		au.setEmail(user.getEmail());
		au.setGender(user.getGender());
		au.setName(user.getName());
		au.setPassword(user.getPassword());
		return au;
	}
	
	
}
