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
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class EntityTemplate implements Serializable{
	private static final long serialVersionUID = 6404309960680005028L;
	
	@Id  
    @GeneratedValue 
	private Integer id;
	
    private String title;	
    private Date date;
    
    //注意：使用mappedBy,说明双向关联，使用fetch说明集合采用加载的方式：默认LAZY表示延迟加载，另外一种表示强制加载
    @OneToMany(mappedBy="entityTemplate",targetEntity=EntityItem.class,fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    private Set<EntityItem> entityItems = new HashSet<EntityItem>();
   
    
    public EntityTemplate(){}
    
	public EntityTemplate(String title, Date date) {
		this.title = title;
		this.date = date;
	}
	public EntityTemplate(String title, Date date, Set<EntityItem> entityItems) {
		super();
		this.title = title;
		this.date = date;
		this.entityItems = entityItems;
	}	
	public EntityTemplate(Integer id, String title, Date date,
			Set<EntityItem> entityItems) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.entityItems = entityItems;
	}

	public long getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<EntityItem> getEntityItems() {
		return entityItems;
	}

	public void setEntityItems(Set<EntityItem> entityItems) {
		this.entityItems = entityItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		EntityTemplate other = (EntityTemplate) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public  void addItems(EntityItem item){
		this.entityItems.add(item);
		item.setEntityTemplate(this);
	}
}
