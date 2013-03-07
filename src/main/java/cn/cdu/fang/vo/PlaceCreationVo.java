package cn.cdu.fang.vo;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

public class PlaceCreationVo implements Serializable{
	private static final long serialVersionUID = -72703331584549851L;
	
	public Map<String, String> getAddress() {
		return address;
	}
	public void setAddress(Map<String, String> address) {
		this.address = address;
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
	private Map<String, String> address;
	@NotBlank
	private String fullAddr;
	private Double[] lngLat;
	
}
