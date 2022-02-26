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
	private int phone;
	public EPerson() {
		id = "";
		name = "";
		gender = "";
		day = 0;
		month = 0;
		year = 0;
		address = "";
		phone = 0;
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
		phone = sc.nextInt();
	}
	public String getId() {return id;}
	public String getName() {return name;}
	public String getGender() {return gender;}
	public int getDay() {return day;}
	public int getMonth() {return month;}
	public int getYear() {return year;}
	public String getAddress() {return address;}
	public int getPhone() {return phone;}
}
