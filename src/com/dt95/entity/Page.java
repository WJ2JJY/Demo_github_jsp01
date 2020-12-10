package com.dt95.entity;

import com.dt95.dao.impl.SelectImpl;

public class Page {
	private int currentPage=1;
	private int limitPage;
	private int lastPage;
	private int sunPage;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLimitPage() {
		return limitPage;
	}
	public void setLimitPage(int limitPage) {
		this.limitPage = limitPage;
	}
	public int getLastPage() {
		if(getSunPage()%this.limitPage!=0){
			return getSunPage()/this.limitPage+1;
		}else {
			return getSunPage()/this.limitPage;
		}
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getSunPage() {
		
		return sunPage;
	}
	public void setSunPage(int sunPage) {
		this.sunPage = sunPage;
	}
	
	
}
