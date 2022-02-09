package oop;

import java.util.Scanner;

class Person{
	private String name;
	private int year;
	public Person(){
		name = "";
		year = 0;
	}
	public Person(String name, int year) {
		this.name = name;
		this.year = year;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getYear() {
		return year;
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name: ");
		name = sc.nextLine();
		System.out.print("Enter year: ");
		year = sc.nextInt();
	}
	public void output() {
		System.out.print("Name: " + name + ", Year: " + year);
	}
}

class Student1 extends Person{
	private double gpa;
	public Student1() {
		super();
		gpa = 0;
	}
	public Student1(String name, int year, double gpa) {
		super(name, year);
		this.gpa = gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public double getGpa() {
		return gpa;
	}
	public void input() {
		super.input();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter gpa: ");
		gpa = sc.nextDouble();
		sc.close();
	}
	public void output() {
		super.output();
		System.out.print(", Gpa:" + gpa);
	}
}

public class Entry1 {
	public static void main(String[] args) {
		Student1 s1 = new Student1();
		s1.input();
		s1.output();
	}
}
