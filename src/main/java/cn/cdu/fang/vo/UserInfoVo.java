package cn.cdu.fang.vo;

import java.io.Serializable;

public class UserInfoVo implements Serializable{
	private static final long serialVersionUID = -1952728026559259133L;
	private String name;
	private String email;
	private String blog;
	private String summary;
	private String avatalrUr;
	
	public UserInfoVo(){}

	public UserInfoVo(String name, String email, String blog, String summary,
			String avatalrUr) {
		super();
		this.name = name;
		this.email = email;
		this.blog = blog;
		this.summary = summary;
		this.avatalrUr = avatalrUr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((avatalrUr == null) ? 0 : avatalrUr.hashCode());
		result = prime * result + ((blog == null) ? 0 : blog.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
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
		UserInfoVo other = (UserInfoVo) obj;
		if (avatalrUr == null) {
			if (other.avatalrUr != null)
				return false;
		} else if (!avatalrUr.equals(other.avatalrUr))
			return false;
		if (blog == null) {
			if (other.blog != null)
				return false;
		} else if (!blog.equals(other.blog))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		return true;
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

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAvatalrUr() {
		return avatalrUr;
	}

	public void setAvatalrUr(String avatalrUr) {
		this.avatalrUr = avatalrUr;
	}
}
