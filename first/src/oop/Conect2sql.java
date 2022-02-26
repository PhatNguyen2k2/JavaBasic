package oop;

import java.sql.Statement;
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
	private String shifts;
	public Employee(){
		super();
		working_hour = 0;
		bonus = 0;
		minus = 0;
		coefficients = 0;
		salary = 0;
		shifts = "";
	}
	public void input() {
		super.input();
		Scanner sc = new Scanner(System.in);
		working_hour = sc.nextInt();
		bonus = sc.nextFloat();
		minus = sc.nextFloat();
		coefficients = sc.nextFloat();
		salary = sc.nextFloat();
		shifts = sc.next();
	}
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
				int n;
				Scanner sc = new Scanner(System.in);
				System.out.print("Enter n: ");
				n = sc.nextInt();
				Employee[] e = new Employee[n];
				for(int i = 0; i < n; i++) {
					System.out.println("Enter info of employee " + i);
					e[i] = new Employee();
					e[i].input();
				}
				for(int i = 0; i < n; i++) {
				String sql = "INSERT INTO EMPLOYEE VALUES"
						+"(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement st = cn.prepareStatement(sql);
				st.setString(1, e[i].getId());
				st.setString(2, e[i].getName());
				st.setString(3, e[i].getGender());
				st.setInt(4, e[i].getDay());
				st.setInt(5, e[i].getMonth());
				st.setInt(6, e[i].getYear());
				st.setString(7, e[i].getAddress());
				st.setInt(8, e[i].getPhone());
				st.setInt(9, e[i].getWorking_hour());
				st.setFloat(10, e[i].getBonus());
				st.setFloat(11, e[i].getMinus());
				st.setFloat(12, e[i].getCoefficients());
				st.setFloat(13, e[i].getSalary());
				st.setString(14, e[i].getShifts());
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

}
