package cn.cdu.fang.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class SignInVO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Email
	private String sname;
	@NotNull
	private String spassword;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
}
