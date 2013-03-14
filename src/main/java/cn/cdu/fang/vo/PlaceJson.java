package cn.cdu.fang.vo;

import java.io.Serializable;
import java.util.Arrays;

import cn.cdu.fang.entity.Place;

@SuppressWarnings("serial")
public class PlaceJson implements Serializable{
	private String name;//名称
	private String placeId;//编号
	
	private String nation;//国家
	private String province;//省份
	private String city;//城市
	private String district;//==
	private String contry;//区县
	private String street;//街道
	
	private String zipCode;//邮编
	private String fullAddr;//地址全址
	
	private Double[] lngLat;
	
	public PlaceJson(){}

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

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
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

	public Double[] getLngLat() {
		return lngLat;
	}

	public void setLngLat(Double[] lngLat) {
		this.lngLat = lngLat;
	}

	public static PlaceJson builtPlaceJson(Place place){
		PlaceJson json = new PlaceJson();
		json.setCity(place.getCity()==null?"":place.getCity());
		json.setContry(place.getContry()==null?"":place.getContry());
		json.setDistrict(place.getDistrict()==null?"":place.getDistrict());
		json.setFullAddr(place.getFullAddr()==null?"":place.getFullAddr());
		json.setZipCode(place.getZipCode()==null?"":place.getZipCode());
		json.setStreet(place.getStreet()==null?"":place.getStreet());
		json.setProvince(place.getProvince()==null?"":place.getProvince());
		json.setName(place.getName()==null?"":place.getName());
		json.setNation(place.getNation()==null?"":place.getNation());
		json.setLngLat(place.getLngLat()==null?new Double[]{}:place.getLngLat());
		json.setPlaceId(place.getId()==null?"":place.getId()+"");
		return json;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((contry == null) ? 0 : contry.hashCode());
		result = prime * result
				+ ((district == null) ? 0 : district.hashCode());
		result = prime * result
				+ ((fullAddr == null) ? 0 : fullAddr.hashCode());
		result = prime * result + Arrays.hashCode(lngLat);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nation == null) ? 0 : nation.hashCode());
		result = prime * result
				+ ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
		PlaceJson other = (PlaceJson) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (contry == null) {
			if (other.contry != null)
				return false;
		} else if (!contry.equals(other.contry))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (fullAddr == null) {
			if (other.fullAddr != null)
				return false;
		} else if (!fullAddr.equals(other.fullAddr))
			return false;
		if (!Arrays.equals(lngLat, other.lngLat))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nation == null) {
			if (other.nation != null)
				return false;
		} else if (!nation.equals(other.nation))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
	
	
}