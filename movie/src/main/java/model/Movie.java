package model;

import java.io.Serializable;

public class Movie implements Serializable{
	private String userName;
	private String title;
	private String text;
	
	public Movie() {}
	public Movie(String userName,String title, String text) {
		this.userName = userName;
		this.title = title;
		this.text = text;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
