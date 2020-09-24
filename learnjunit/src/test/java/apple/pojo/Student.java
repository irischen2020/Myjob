package apple.pojo;

import lombok.Data;

@Data
public class Student {
	private String name;
	private String age;
	private String gender;
	
	public Student(String name, String age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
}
