package cn.cdu.fang.entity;

import java.io.Serializable;

public class CityMeta implements Serializable {
	private static final long serialVersionUID = 3321450456991162507L;
		
		private String name;
		private String pinyin;
		private Double[] lngLat;
		private Integer zoom;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPinyin() {
			return pinyin;
		}
		public void setPinyin(String pinyin) {
			this.pinyin = pinyin;
		}
		public Double[] getLngLat() {
			return lngLat;
		}
		public void setLngLat(Double[] lngLat) {
			this.lngLat = lngLat;
		}
		public Integer getZoom() {
			return zoom;
		}
		public void setZoom(Integer zoom) {
			this.zoom = zoom;
		}
		
		public CityMeta(String name, String pinyin, Double[] lngLat,
				Integer zoom) {
			super();
			this.name = name;
			this.pinyin = pinyin;
			this.lngLat = lngLat;
			this.zoom = zoom;
		}
		
		
}
