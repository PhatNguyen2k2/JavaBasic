package oop;

import java.util.Scanner;

public class EPerson {
	private String id;
	private String name;
	private String gender;
	private int day;
	private int month;
	private int year;
	private String address ;
	private String phone;
	public EPerson() {
		id = "";
		name = "";
		gender = "";
		day = 0;
		month = 0;
		year = 0;
		address = "";
		phone = "";
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		id = sc.nextLine();
		name = sc.nextLine();
		gender = sc.nextLine();
		address = sc.nextLine();
		day = sc.nextInt();
		month = sc.nextInt();
		year = sc.nextInt();
		phone = sc.nextLine();
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getId() {return id;}
	public String getName() {return name;}
	public String getGender() {return gender;}
	public int getDay() {return day;}
	public int getMonth() {return month;}
	public int getYear() {return year;}
	public String getAddress() {return address;}
	public String getPhone() {return phone;}
}
