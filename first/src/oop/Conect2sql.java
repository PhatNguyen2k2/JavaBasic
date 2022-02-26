package oop;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class Employee {
	private String id;
	private String name;
	private String gender;
	private int day;
	private int month;
	private int year;
	private String address;
	private int phone;
	private int working_hour;
	private float bonus;
	private float minus;
	private float coefficients;
	private float salary;
	private String shifts;
	public Employee(){
		id = "";
		name = "";
		gender = "";
		day = 0;
		month = 0;
		year = 0;
		address = "";
		phone = 0;
		working_hour = 0;
		bonus = 0;
		minus = 0;
		coefficients = 0;
		salary = 0;
		shifts = "";
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
		working_hour = sc.nextInt();
		bonus = sc.nextFloat();
		minus = sc.nextFloat();
		coefficients = sc.nextFloat();
		salary = sc.nextFloat();
		shifts = sc.next();
	}
	public String getId() {return id;}
	public String getName() {return name;}
	public String getGender() {return gender;}
	public int getDay() {return day;}
	public int getMonth() {return month;}
	public int getYear() {return year;}
	public String getAddress() {return address;}
	public int getPhone() {return phone;}
	public int getWorking_hour() {return working_hour;}
	public float getBonus() {return bonus;}
	public float getMinus() {return minus;}
	public float getCoefficients() {return coefficients;}
	public float getSalary() {return salary;}
	public String getShifts() {return shifts;}
}
public class Conect2sql {

	public static void main(String[] args) {
		String url = "jdbc:sqlserver://FAT\\SQLEXPRESS:1433;databaseName=Example1;user=sa;password=phat12112002;encrypt=false";
			Connection cn;
			try {
				cn = DriverManager.getConnection(url);
				System.out.print("connect success\n");
				Employee e = new Employee();
				e.input();
				String sql = "INSERT INTO EMPLOYEE VALUES"
						+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement st = cn.prepareStatement(sql);
				st.setString(1, e.getId());
				st.setString(2, e.getName());
				st.setString(3, e.getGender());
				st.setInt(4, e.getDay());
				st.setInt(5, e.getMonth());
				st.setInt(6, e.getYear());
				st.setString(7, e.getAddress());
				st.setInt(8, e.getPhone());
				st.setInt(9, e.getWorking_hour());
				st.setFloat(10, e.getBonus());
				st.setFloat(11, e.getMinus());
				st.setFloat(12, e.getCoefficients());
				st.setFloat(13, e.getSalary());
				st.setString(14, e.getShifts());
				int rows = st.executeUpdate();
				if(rows > 0) {
					System.out.print("row has been inserted");
					cn.close();
				}
			} catch (SQLException e) {
				System.out.print("oh no.");
				e.printStackTrace();
			}
	}

}
