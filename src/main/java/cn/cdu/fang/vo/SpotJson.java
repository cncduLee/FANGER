package cn.cdu.fang.vo;

import java.io.Serializable;
import java.util.Date;

import cn.cdu.fang.constant.ApplicationConstant;
import cn.cdu.fang.entity.Place;
import cn.cdu.fang.entity.Resource;
import cn.cdu.fang.entity.Spot;
import cn.cdu.fang.entity.User;

public class SpotJson implements Serializable{
	private static final long serialVersionUID = 8035204954355078110L;
	
	
	private Double lat;//经纬度
	private Double lng;//经纬度
	private Data data;
	private Options options;
	
	
	public SpotJson(){}
	
	public SpotJson builtJosn(Spot spot){
		SpotJson json = new SpotJson();
		if(spot.getPlace() != null){
			json.setLat(spot.getPlace().getLngLat()[1]);
			json.setLng(spot.getPlace().getLngLat()[0]);
		}else{
			json.setLat(ApplicationConstant.FULL_CHINA_LAT);
			json.setLng(ApplicationConstant.FULL_CHINA_LNT);
		}
		
		
		Data data = new Data();
		data.setId(spot.getId());
		data.setCategory(spot.getCategory());
		data.setCreatedAt(spot.getCreatedAt());
		data.setCreatedBy(spot.getCreatedBy().getName());
		data.setName(spot.getName());
		data.setSummary(spot.getSummary());
		data.setPlace(spot.getPlace().getFullAddr());
		data.setImageUrl(spot.getImages().getResId());
		json.setData(data);
		
		Options options = new Options();
		options.setIcon(spot.getImages().getResId());
		json.setOptions(options);
		
		return json;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}





	@SuppressWarnings("serial")
	public class Options{
		private String icon;
		public Options(){}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public Options(String icon) {
			super();
			this.icon = icon;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((icon == null) ? 0 : icon.hashCode());
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
			Options other = (Options) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (icon == null) {
				if (other.icon != null)
					return false;
			} else if (!icon.equals(other.icon))
				return false;
			return true;
		}
		private SpotJson getOuterType() {
			return SpotJson.this;
		}
		
	}
	@SuppressWarnings("serial")
	public class Data implements Serializable{
		private Integer id;
		private String createdBy;//创建人
		private Date createdAt;
		private Date updatedAt;//更新时间
		private String category;//分类
		private String place;//事发地点
		private String imageUrl;//图片
		private String name;//事件取名
		private String summary;//事件描述
		public Data(){}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getPlace() {
			return place;
		}
		public void setPlace(String place) {
			this.place = place;
		}
		public String getImageUrl() {
			return imageUrl;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
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
			Data other = (Data) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
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
		private SpotJson getOuterType() {
			return SpotJson.this;
		}
		
		
	}
}


