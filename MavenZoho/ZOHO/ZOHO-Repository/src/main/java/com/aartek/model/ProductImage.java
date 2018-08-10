package com.aartek.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProductImage")
public class ProductImage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ImageId")
	private Integer ImageId;
	
	@Column(name="ImageName")
	private String ImageName;
	
	@Column(name="ImageSize")
	private Integer ImageSize;
	
	@Column(name="ImagePath")
	private String ImagePath;
	
	public Integer getImageId() {
		return ImageId;
	}

	public void setImageId(Integer imageId) {
		ImageId = imageId;
	}

	public String getImageName() {
		return ImageName;
	}

	public void setImageName(String imageName) {
		ImageName = imageName;
	}

	public Integer getImageSize() {
		return ImageSize;
	}

	public void setImageSize(Integer imageSize) {
		ImageSize = imageSize;
	}

}
