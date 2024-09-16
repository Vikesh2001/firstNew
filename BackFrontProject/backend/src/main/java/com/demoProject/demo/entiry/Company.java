package com.demoProject.demo.entiry;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String itemName;
	
	private int itemPrice ;
	
	private String itemColor;
	
	private String itemSize;
	
	private String brandName;
	
	private int itemRating;
	
	private byte[] image;
	
	private String imageUrl;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemColor() {
		return itemColor;
	}

	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getItemRating() {
		return itemRating;
	}

	public void setItemRating(int itemRating) {
		this.itemRating = itemRating;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	 public String getImageUrl() {
	        return imageUrl;
	    }

	    public void setImageUrl(String imageUrl) {
	        this.imageUrl = imageUrl;
	    }
	@Override
    public String toString() {
        return "Company [id=" + id + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemColor=" + itemColor
                + ", itemSize=" + itemSize + ", brandName=" + brandName + ", itemRating=" + itemRating + ", image="
                + Arrays.toString(image) + "]";
    }

}
