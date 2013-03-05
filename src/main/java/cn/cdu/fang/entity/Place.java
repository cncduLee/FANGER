package cn.cdu.fang.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * 地点，地理位置的描述类型
 * 
 * @author Lee
 */
@Entity
public class Place implements Serializable{
	private static final long serialVersionUID = -903257281165546388L;
	@Id
	@GeneratedValue
	private Integer id;
	private String name;//名称
	
	private String nation;//国家
	private String province;//省份
	private String city;//城市
	private String contry;//区县
	private String street;//街道
	
	private String zipCode;//邮编
	private String fullAddr;//地址全址
	
	private Spot spot;
	
	public Place(){}
	
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
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContry() {
		return contry;
	}
	public void setContry(String contry) {
		this.contry = contry;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getFullAddr() {
		return fullAddr;
	}
	public void setFullAddr(String fullAddr) {
		this.fullAddr = fullAddr;
	}
	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
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
		Place other = (Place) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Place(String name, String nation, String province, String city,
			String contry, String street, String zipCode, String fullAddr) {
		super();
		this.name = name;
		this.nation = nation;
		this.province = province;
		this.city = city;
		this.contry = contry;
		this.street = street;
		this.zipCode = zipCode;
		this.fullAddr = fullAddr;
	}
	
	
}
