package cn.cdu.fang.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class EntityOne implements Serializable{
	@Id
	@GeneratedValue
	private Integer id;
	
	private String content;
	
	@OneToOne(mappedBy="one",cascade=CascadeType.ALL)  
	private EntityItem item;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public EntityItem getItem() {
		return item;
	}

	public void setItem(EntityItem item) {
		this.item = item;
	}

	public EntityOne(String content) {
		this.content = content;
	}
	
	public EntityOne(){}
}
