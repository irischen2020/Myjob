package cn.sd.sprinmvc.model;

public class User {
	private int id;
	private String userName;
	private int age;
	
	public User() {
	}
	
	public int getId() {
		return id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", userName='" + userName + '\'' +
				", age=" + age +
				'}';
	}
}
