package cn.cdu.fang.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.vo.PlaceCreationVo;


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
	private String district;//==
	private String contry;//区县
	private String street;//街道
	
	private String zipCode;//邮编
	private String fullAddr;//地址全址
	
	private Double[] lngLat;
	
	@OneToOne(cascade={CascadeType.DETACH,CascadeType.REFRESH})
	private User createBy;
	@OneToOne(cascade={CascadeType.DETACH,CascadeType.REFRESH})
	private User updateBy;
	
	
	private Date createAt;
	private Date updateAt;
	
	@OneToOne(cascade={CascadeType.ALL},mappedBy="place")
	private Spot spot;
	
	public Place(){}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getCreateAt() {
		return createAt;
	}

	public User getUpdateBy() {
		return updateBy;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public void setUpdateBy(User updateBy) {
		this.updateBy = updateBy;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
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

	public Double[] getLngLat() {
		return lngLat;
	}

	public void setLngLat(Double[] lngLat) {
		this.lngLat = lngLat;
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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
	
	public static Place builPlace(PlaceCreationVo vo,User signUser){
		if(vo==null || signUser == null) return null;
		Place place = new Place();
		if(vo.getAddress()!=null ||
				(vo.getLngLat()!=null &&
				 vo.getLngLat().length>1)){
			
			place.setCreateAt(new Date());
			place.setCreateBy(signUser);
			Map<String, String> addr = vo.getAddress();
			place.setFullAddr(vo.getFullAddr());
			if(addr!=null){
				place.setNation(addr.get(ApplicationConstant.NATION));
				place.setProvince(addr.get(ApplicationConstant.PROVINCE));
				place.setCity(addr.get(ApplicationConstant.CITY));
				place.setDistrict(addr.get(ApplicationConstant.DISTRICT));
				place.setStreet(addr.get(ApplicationConstant.STREET));
				place.setZipCode(addr.get(ApplicationConstant.ZIP_CODE));
				if(place.getFullAddr()==null){
					place.setFullAddr(addr.get(ApplicationConstant.FULL_ADDR));
				}
			}
			if(vo.getLngLat()!=null &&
				vo.getLngLat().length>1){
				place.setLngLat(vo.getLngLat());
			}
		}
		return place;
	}
}
