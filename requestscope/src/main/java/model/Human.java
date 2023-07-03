package model;

import java.io.Serializable;

//implements Serializable はテストで絶対聞かれる
public class Human implements Serializable{
	private String name;
	private int age;
	
	//引数なしのコンストラクタを必ず作る
	public Human() {}
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
