package cn.cdu.fang.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


/***
 * 构造此实体的目的：
 * 1、用于管理管理员账户
 * 2、考虑到普通用户数量较大时，不变管理
 * 3、不作为普通用户实体，增加该实体方便查询，以及后期普通用户类型的管理
 * 
 * @author Lee
 */
@Entity
public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer id;
	@NotNull
	private String name;
	@NotNull
	private String password;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public Admin(){}
	
	
}
