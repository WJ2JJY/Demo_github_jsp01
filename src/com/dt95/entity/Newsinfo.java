package com.dt95.entity;

import java.sql.Blob;
import java.util.Date;

public class Newsinfo {
	private int newsid;
	private int typeid;
	private String newstitle;
	private String newsauthor;
	private String newsummary;
	private String newscontent;
	private Blob newspic;
	private Date releasetime;
	public Newsinfo() {
		super();
	}

	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getNewstitle() {
		return newstitle;
	}
	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}
	public String getNewsauthor() {
		return newsauthor;
	}
	public void setNewsauthor(String newsauthor) {
		this.newsauthor = newsauthor;
	}
	public String getNewsummary() {
		return newsummary;
	}
	public void setNewsummary(String newsummary) {
		this.newsummary = newsummary;
	}
	public String getNewscontent() {
		return newscontent;
	}
	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}
	public Blob getNewspic() {
		return newspic;
	}
	public void setNewspic(Blob newspic) {
		this.newspic = newspic;
	}
	public Date getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}

	
}
