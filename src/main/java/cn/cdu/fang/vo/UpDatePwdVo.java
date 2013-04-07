package cn.cdu.fang.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class UpDatePwdVo implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String oldpwd;
	@NotNull
	private String newpwd;
	@NotNull
	private String renewpwd;

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public String getRenewpwd() {
		return renewpwd;
	}

	public void setRenewpwd(String renewpwd) {
		this.renewpwd = renewpwd;
	}

}
