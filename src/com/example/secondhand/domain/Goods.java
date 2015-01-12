package com.example.secondhand.domain;

import android.graphics.Bitmap;

public class Goods {
	private int id;
	private String name;
	private String discription;
	private float money;
	private Bitmap[] pictures;

	public Goods() {
	}

	public Goods(int id, String name, String discription, float money, Bitmap[] pictures) {
		this.id = id;
		this.name = name;
		this.discription = discription;
		this.money = money;
		this.pictures = pictures;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public Bitmap[] getPictures() {
		return pictures;
	}

	public void setPicture(Bitmap[] pictures) {
		this.pictures = pictures;
	}

}
