package oop;

import oop.EPerson;
import java.sql.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class Employee extends EPerson{
	private int working_hour;
	private float bonus;
	private float minus;
	private float coefficients;
	private float salary;
	private float experience;
	private String position;
	public Employee(){
		super();
		working_hour = 0;
		bonus = 0;
		minus = 0;
		coefficients = 0;
		salary = 0;
		experience = 0;
		position = "";
	}
	public void setWorking_hour(int working_hour) {
		this.working_hour = working_hour;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	public void setMinus(float minus) {
		this.minus = minus;
	}
	public void setCoefficients(float coefficients) {
		this.coefficients = coefficients;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public void setExperience(float experience) {
		this.experience = experience;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void input() {
		super.input();
		Scanner sc = new Scanner(System.in);
		working_hour = sc.nextInt();
		bonus = sc.nextFloat();
		minus = sc.nextFloat();
		coefficients = sc.nextFloat();
		salary = sc.nextFloat();
		experience = sc.nextFloat();
		position = sc.next();
	}
	public int getWorking_hour() {return working_hour;}
	public float getBonus() {return bonus;}
	public float getMinus() {return minus;}
	public float getCoefficients() {return coefficients;}
	public float getSalary() {return salary;}
	public float getExperience() {return experience;}
	public String getPosition() {return position;}
}
class Employees{
	private Employee[] e;
	public Employees() {
		super();
		e = new Employee[2];
	}
	public void read() {
		String url = "D:\\JavaBasic\\first\\src\\oop\\employee";
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(url);
			Scanner sc = new Scanner(fileInputStream);
			for(int i = 0; i < 2; i++) {
				e[i]= new Employee();
				e[i].setId(sc.nextLine());
				e[i].setName(sc.nextLine());
				e[i].setGender(sc.nextLine());
				e[i].setAddress(sc.nextLine());
				e[i].setPhone(sc.nextLine());
				e[i].setPosition(sc.nextLine());
				e[i].setDay(sc.nextInt());
				e[i].setMonth(sc.nextInt());
				e[i].setYear(sc.nextInt());
				e[i].setWorking_hour(sc.nextInt());
				e[i].setBonus(sc.nextFloat());
				e[i].setMinus(sc.nextFloat());
				e[i].setCoefficients(sc.nextFloat());
				e[i].setSalary(sc.nextFloat());
				e[i].setExperience(sc.nextFloat());
				String c = sc.nextLine();//catch "enter"
			}
		} catch (FileNotFoundException e) {
			System.out.println("Oh no\n");
			e.printStackTrace();
		}
	}
	public void writeSQL() {
		String url = "jdbc:sqlserver://FAT\\SQLEXPRESS:1433;databaseName=Example1;user=sa;password=phat12112002;encrypt=false";
		Connection cn;
		try {
			cn = DriverManager.getConnection(url);
			System.out.print("connect success\n");
			for(int i = 0; i < 2; i++) {
			String sql = "INSERT INTO EMPLOYEE VALUES"
					+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = cn.prepareStatement(sql);
			st.setString(1, e[i].getId());
			st.setString(2, e[i].getName());
			st.setString(3, e[i].getGender());
			st.setInt(4, e[i].getDay());
			st.setInt(5, e[i].getMonth());
			st.setInt(6, e[i].getYear());
			st.setString(7, e[i].getAddress());
			st.setString(8, e[i].getPhone());
			st.setInt(9, e[i].getWorking_hour());
			st.setFloat(10, e[i].getBonus());
			st.setFloat(11, e[i].getMinus());
			st.setFloat(12, e[i].getCoefficients());
			st.setFloat(13, e[i].getSalary());
			st.setFloat(14, e[i].getExperience());
			st.setString(15, e[i].getPosition());
			int rows = st.executeUpdate();
				if(rows > 0) {
					System.out.print("row has been inserted\n");
				}
			}
			cn.close();
		} catch (SQLException e) {
			System.out.print("oh no.");
			e.printStackTrace();
		}
	}
};
class Customer extends EPerson{
	private int point;
	private String member;
	public Customer() {
		super();
		point = 0;
		member = "";
	}
	public void input() {
		super.input();
		Scanner sc = new Scanner(System.in);
		point = sc.nextInt();
		member = sc.nextLine();
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public int getPoint() {
		return point;
	}
	public String getMember() {
		return member;
	}
};
public class Conect2sql {
	public static void main(String[] args) {
		Employees e = new Employees();
		e.read();
		e.writeSQL();
	}

}
