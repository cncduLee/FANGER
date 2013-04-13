package cn.cdu.fang.vo;

import java.io.Serializable;

public class ImageVo implements Serializable{
	private static final long serialVersionUID = -2687528313436309224L;
	
	private Integer x;
	private Integer y;
	private Integer width;
	private Integer hight;
	
	public ImageVo(){}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHight() {
		return hight;
	}

	public void setHight(Integer hight) {
		this.hight = hight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hight == null) ? 0 : hight.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		ImageVo other = (ImageVo) obj;
		if (hight == null) {
			if (other.hight != null)
				return false;
		} else if (!hight.equals(other.hight))
			return false;
		if (width == null) {
			if (other.width != null)
				return false;
		} else if (!width.equals(other.width))
			return false;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}

	public ImageVo(Integer x, Integer y, Integer width, Integer hight) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.hight = hight;
	}
	
}
