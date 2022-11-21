package org.booleancareer.java;

public class Person {

	final int MY_CONST;
	
	private String name;
	private int age;
	
	public Person(String name, int age) throws Exception {
		
		setName(name);
		setAge(age);
		
		MY_CONST = 10;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		
		if (name.length() < 1) {
			
			throw new Exception("Empty name not permetted");
		}
		
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws Exception {
		
		if (age <= 0) {
			
			throw new Exception("Only positive age admitted");
		}
		
		this.age = age;
	}
	
	@Override
	public String toString() {
		
		return name + ": " + age;
	}
}
