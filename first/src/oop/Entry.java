package oop;

import java.util.Scanner;

class Student{
	private String name;
	private int age;
	public Student(){
		name = "";
		age = 0;
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		name = sc.nextLine();
		age = sc.nextInt();
		sc.close();
	}
	public void output() {
		System.out.println("Name: " + name + ", Age: " + age);
	}
}
public class Entry {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.input();
		s1.output();
	}
}
