package cn.cdu.fang.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EntityItem implements Serializable{
	private static final long serialVersionUID = -4344086507075719448L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Integer id;  
    private String name;  
    private int age;  
    private Date birthday;  
    private int sex;
    
    @ManyToOne
    @JoinColumn(name="eid",referencedColumnName="id")
    private EntityTemplate entityTemplate;
    
    public EntityItem(){}
	public EntityItem(String name, int age, Date birthday, int sex,
			EntityTemplate entityTemplate) {
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.sex = sex;
		this.entityTemplate = entityTemplate;
	}
	
	public long getId() {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public EntityTemplate getEntityTemplate() {
		return entityTemplate;
	}
	public void setEntityTemplate(EntityTemplate entityTemplate) {
		this.entityTemplate = entityTemplate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		EntityItem other = (EntityItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
    
}
