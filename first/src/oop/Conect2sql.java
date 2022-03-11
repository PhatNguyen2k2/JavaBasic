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
import java.util.Vector;

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
	private Vector<Employee>v;
	public Employees() {
		super();
		v = new Vector<Employee>();
	}
	public void read() {
		String url = "D:\\JavaBasic\\first\\src\\oop\\employee";
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(url);
			Scanner sc = new Scanner(fileInputStream);
			for(int i = 0; i < 2; i++) {
				Employee e = new Employee();
				e.setId(sc.nextLine());
				e.setName(sc.nextLine());
				e.setGender(sc.nextLine());
				e.setAddress(sc.nextLine());
				e.setPhone(sc.nextLine());
				e.setPosition(sc.nextLine());
				e.setDay(sc.nextInt());
				e.setMonth(sc.nextInt());
				e.setYear(sc.nextInt());
				e.setWorking_hour(sc.nextInt());
				e.setBonus(sc.nextFloat());
				e.setMinus(sc.nextFloat());
				e.setCoefficients(sc.nextFloat());
				e.setSalary(sc.nextFloat());
				e.setExperience(sc.nextFloat());
				String c = sc.nextLine();//catch "enter"
				v.add(e);
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
			st.setString(1, v.elementAt(i).getId());
			st.setString(2, v.elementAt(i).getName());
			st.setString(3, v.elementAt(i).getGender());
			st.setInt(4, v.elementAt(i).getDay());
			st.setInt(5, v.elementAt(i).getMonth());
			st.setInt(6, v.elementAt(i).getYear());
			st.setString(7, v.elementAt(i).getAddress());
			st.setString(8, v.elementAt(i).getPhone());
			st.setInt(9, v.elementAt(i).getWorking_hour());
			st.setFloat(10, v.elementAt(i).getBonus());
			st.setFloat(11, v.elementAt(i).getMinus());
			st.setFloat(12, v.elementAt(i).getCoefficients());
			st.setFloat(13, v.elementAt(i).getSalary());
			st.setFloat(14, v.elementAt(i).getExperience());
			st.setString(15, v.elementAt(i).getPosition());
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
