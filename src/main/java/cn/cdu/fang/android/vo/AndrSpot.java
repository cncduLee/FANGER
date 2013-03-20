package cn.cdu.fang.android.vo;

import java.io.Serializable;

import cn.cdu.fang.entity.Spot;

@SuppressWarnings("serial")
public class AndrSpot implements Serializable{
	
	private String imageUrl;
	private String category;
	private String name;
	private String summary;
	
	private String fullAddr;
	private String placeId;
	private String city;
	
	private Double lat;//经纬度
	private Double lng;//经纬度
	
	private int commentsCount;
	private int likeCount;
	private int markCount;
	private int shareCount;
	private int downloadCount;
	
	public AndrSpot() {}
	public AndrSpot(String imageUrl, String category, String name,
			String summary, String fullAddr, String placeId, String city,
			Double lat, Double lng, int commentsCount, int likeCount,
			int markCount, int shareCount, int downloadCount) {
		super();
		this.imageUrl = imageUrl;
		this.category = category;
		this.name = name;
		this.summary = summary;
		this.fullAddr = fullAddr;
		this.placeId = placeId;
		this.city = city;
		this.lat = lat;
		this.lng = lng;
		this.commentsCount = commentsCount;
		this.likeCount = likeCount;
		this.markCount = markCount;
		this.shareCount = shareCount;
		this.downloadCount = downloadCount;
	}


	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getFullAddr() {
		return fullAddr;
	}
	public void setFullAddr(String fullAddr) {
		this.fullAddr = fullAddr;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public int getCommentsCount() {
		return commentsCount;
	}
	public void setCommentsCount(int commentsCount) {
		this.commentsCount = commentsCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getMarkCount() {
		return markCount;
	}
	public void setMarkCount(int markCount) {
		this.markCount = markCount;
	}
	public int getShareCount() {
		return shareCount;
	}
	public void setShareCount(int shareCount) {
		this.shareCount = shareCount;
	}
	public int getDownloadCount() {
		return downloadCount;
	}
	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}
	public static AndrSpot convertTo(Spot spot){
		AndrSpot as = new AndrSpot();
		as.setCategory(spot.getCategory());
		
		as.setCity(spot.getPlace().getCity());
		as.setFullAddr(spot.getPlace().getFullAddr());
		as.setImageUrl(spot.getImages().getResId());
		as.setLat(spot.getPlace().getLngLat()[1]);
		as.setLng(spot.getPlace().getLngLat()[0]);
		as.setPlaceId(spot.getPlace().getId()+"");
		
		as.setName(spot.getName());
		as.setSummary(spot.getSummary());
		
		as.setMarkCount(spot.getMarkCount());
		as.setCommentsCount(spot.getCommentCount());
		as.setDownloadCount(spot.getDownloadCount());
		as.setLikeCount(spot.getLikeCount());
		as.setShareCount(spot.getShareCount());
		
		return as;
	}
		
}
