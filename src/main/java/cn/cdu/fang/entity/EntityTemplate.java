package cn.cdu.fang.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class EntityTemplate implements Serializable{
	private static final long serialVersionUID = 6404309960680005028L;
	
	@Id  
    @GeneratedValue 
	private Integer id;
	
    private String title;	
    private Date date;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="entityTemplate")
    private List<EntityItem> entityItems = new ArrayList<EntityItem>();
   
    
    public EntityTemplate(){}
    
	public EntityTemplate(String title, Date date) {
		this.title = title;
		this.date = date;
	}
	public EntityTemplate(String title, Date date, List<EntityItem> entityItems) {
		super();
		this.title = title;
		this.date = date;
		this.entityItems = entityItems;
	}	
	public EntityTemplate(Integer id, String title, Date date,
			List<EntityItem> entityItems) {
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
	public List<EntityItem> getEntityItems() {
		return entityItems;
	}

	public void setEntityItems(List<EntityItem> entityItems) {
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
}
