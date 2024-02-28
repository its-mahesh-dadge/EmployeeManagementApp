package EmployeeManagementApp;

import java.util.Scanner;
import java.sql.*;

public class Employee {
	// This Method is for Add Employee
	public static void AddEmployee() throws Exception {

		// load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// Creating Connection
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String password = "";

		Connection con = DriverManager.getConnection(url, user, password);
		if (con.isClosed()) {
			System.out.println("Something Went Wrong...");
		} else {
			System.out.println("Connection Success..!!");
		}

		Scanner sc = new Scanner(System.in);
		// System.out.println("Fill The Details");
		String query = "INSERT INTO `employee_info` " + "(`id`, `name`, `age`, `desiganation`, `department`, `salary`) "
				+ "VALUES (?, ?, ?, ?, ?, ?);";
		PreparedStatement pstmt = con.prepareStatement(query);

		System.out.println("*********************");
		System.out.println("Add Employee...");
		System.out.println("*********************");
		System.out.print("Enter the Employee ID:- ");
		int id = sc.nextInt();
		System.out.print("Enter the Employee Name:- ");
		String name = sc.next();
		System.out.print("Enter the Employee age:- ");
		int age = sc.nextInt();
		System.out.print("Enter the Employee Desiganation:- ");
		String designation = sc.next();
		System.out.print("Enter the Employee Department:- ");
		String dapartment = sc.next();
		System.out.print("Enter the Employee CTC:- ");
		float salary = sc.nextFloat();

		try {
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setString(4, designation);
			pstmt.setString(5, dapartment);
			pstmt.setFloat(6, salary);
			pstmt.executeLargeUpdate();
			System.out.println("Data Saved...!!");
			

		} catch (Exception e) {
			System.out.println("Wrong Input...");
			e.printStackTrace();
		}
		
	}

	// This Method is for Remove Employee
	public static void RemoveEmployee() {
		System.out.println("*********************");
		System.out.println("Remove Employee...");
		System.out.println("*********************");
		System.out.print("Enter the employee Id:- ");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Creating Connection
			String url = "jdbc:mysql://localhost:3306/employee";
			String user = "root";
			String password = "";

			Connection con = DriverManager.getConnection(url, user, password);
			String query_remove_emp = "DELETE FROM employee_info WHERE `id` = " + id;
			PreparedStatement pstmt = con.prepareStatement(query_remove_emp);
			int rowaffected = pstmt.executeUpdate(query_remove_emp);
			if (rowaffected > 0) {
				System.out.println("Employee removed of Id:=> " + id);
			} else {
				System.out.println("No data Found of id:=> " + id);
			}

		} catch (Exception e) {
			System.out.println("Somthing Went Wrong...");
			e.printStackTrace();

		}

	}

	// This Method is for Update the Employee Details
	public static void UpdateEmp() throws Exception {

		try {
			// load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Creating Connection
			String url = "jdbc:mysql://localhost:3306/employee";
			String user = "root";
			String password = "";
			Connection con = DriverManager.getConnection(url, user, password);
			if (con.isClosed()) {
				System.out.println("Something Went Wrong...");
			} else {
				System.out.println("Connection Success..!!");
				Scanner sc = new Scanner(System.in);
				System.out.println("1. Update Employee ID");
				System.out.println("2. Update Employee Name");
				System.out.println("3. Update Employee Age");
				System.out.println("4. Update Employee Designation");
				System.out.println("5. Update Employee Department");
				System.out.println("6. Update Employee Salary");
				System.out.println("Enter your Choice:- ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("*********************");
					System.out.println("Update Employee ID");
					System.out.println("*********************");
					System.out.print("Enter New ID:=> ");
					int new_id = sc.nextInt();
					System.out.print("Enetr old ID:=> ");
					int id = sc.nextInt();
					String query = "UPDATE `employee_info` SET `id` = " + new_id + "  WHERE `employee_info`.`id` ="
							+ id;
					PreparedStatement pstmt = con.prepareStatement(query);
					try {
						int count = pstmt.executeUpdate();
						if (count > 0) {
							System.out.println("Employee ID Updated:=> " + id);
							System.out.println("New id of employee is:=> "+new_id);
						} else {
							System.out.println("No Data Found:=> "+id);
						}

					} catch (Exception e) {
						System.out.println("Problem is in pstmt");
						e.printStackTrace();
					}
					break;

				case 2:

					System.out.println("*********************");
					System.out.println("Update Employee Name");
					System.out.println("*********************");
					System.out.print("Enetr Employee ID:=> ");
					id = sc.nextInt();
					System.out.print("Enter New Name:=> ");
					String name = sc.next();

					query = "UPDATE `employee_info` SET `name` = ?  WHERE `employee_info`.`id` = ?";
					pstmt = con.prepareStatement(query);
					try {
						pstmt.setString(1, name);
						pstmt.setInt(2, id);
						int count = pstmt.executeUpdate();
						if (count > 0) {
							System.out.println("Name updated of Employee ID:=> " + id);
							System.out.println("Done...");
						} else {
							System.out.println("No data Found:=> " + id);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					break;
				case 3:
					System.out.println("*********************");
					System.out.println("Update Employee Age");
					System.out.println("*********************");
					System.out.print("Enetr Employee ID:=> ");
					id = sc.nextInt();
					System.out.print("Enter New Age:=> ");
					int age = sc.nextInt();
					query = "UPDATE employee_info SET age =? WHERE id=?";
					pstmt = con.prepareStatement(query);
					try {
						pstmt.setInt(1, age);
						pstmt.setInt(2, id);
						int count = pstmt.executeUpdate();
						if (count > 0) {
							System.out.println("Age Updated of Employee id " + id);
						} else {
							System.out.println("Employee Id Not found " + id);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 4:
					System.out.println("*******************************");
					System.out.println("Update Employee Designation");
					System.out.println("*******************************");
					System.out.print("Enetr Employee ID:=> ");
					id = sc.nextInt();
					System.out.print("Enter New Designation:=> ");
					String designation = sc.next();
					query = "UPDATE employee_info SET desiganation =? WHERE id=?";
					pstmt = con.prepareStatement(query);
					try {
						pstmt.setString(1, designation);
						pstmt.setInt(2, id);
						int count = pstmt.executeUpdate();
						if (count > 0) {
							System.out.println("Designation Updated of Employee id " + id);
						} else {
							System.out.println("Employee Id Not found " + id);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 5:
					System.out.println("*******************************");
					System.out.println("Update Employee Department");
					System.out.println("*******************************");
					System.out.print("Enetr Employee ID:=> ");
					id = sc.nextInt();
					System.out.print("Enter New Department:=> ");
					String department = sc.next();
					query = "UPDATE employee_info SET department =? WHERE id=?";
					pstmt = con.prepareStatement(query);
					try {
						pstmt.setString(1, department);
						pstmt.setInt(2, id);
						int count = pstmt.executeUpdate();
						if (count > 0) {
							System.out.println("Designation Updated of Employee id " + id);
						} else {
							System.out.println("Employee Id Not found " + id);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 6:
					System.out.println("*********************");
					System.out.println("Update Employee Salary");
					System.out.println("*********************");
					System.out.print("Enetr Employee ID:=> ");
					id = sc.nextInt();
					System.out.print("Enter New Salary:=> ");
					float salary = sc.nextFloat();
					query = "UPDATE employee_info SET salary =? WHERE id=?";
					pstmt = con.prepareStatement(query);
					try {
						pstmt.setFloat(1, salary);
						pstmt.setInt(2, id);
						int count = pstmt.executeUpdate();
						if (count > 0) {
							System.out.println("Salary Updated of Employee id " + id);
						} else {
							System.out.println("Employee Id Not found " + id);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				default:
					System.out.println("Invalid Option...");
				}

			}
		} catch (Exception e) {
			System.out.println("SOMTHING WENT WRONG...");
			e.printStackTrace();
		}

	}

	// This Method is for View all Employee Details
	public static void ViewAllemp() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String pass = "";
		Connection con = DriverManager.getConnection(url, user, pass);

		if (con.isClosed()) {
			System.out.println("Something Wentt Wrong...XX");
		} else {
			System.out.println("Connection Open...");
			System.out.println("All Employee are ==>>");
			String query = "SELECT * FROM `employee_info`";
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(
					"------------------------------------------------------------------------------------------------");
			System.out.println("\tID\tName\tAge\tDesignation\tDepartment\tSalary");
			System.out.println(
					"------------------------------------------------------------------------------------------------");
			while (rs.next())

			{
				int id = rs.getInt("id");
				System.out.print("\t" + id);
				String name = rs.getString("name");
				System.out.print("\t" + name);
				int age = rs.getInt("age");
				System.out.print("\t" + age);
				String designation = rs.getString("desiganation");
				System.out.print("\t" + designation);
				String department = rs.getString("department");
				System.out.print("\t\t" + department);
				float salary = rs.getInt("salary");
				System.out.println("\t\t" + salary);

			}

		}

	}

	// This Method For View One Employee Details
	public static void ViewOneEmp() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/employee";
		String user = "root";
		String pass = "";
		Connection con = DriverManager.getConnection(url, user, pass);
		if (con.isClosed()) {
			System.out.println("Conncetion Closed");
		} else {
			System.out.println("View one Employee Detail");
			String query = "SELECT * FROM employee_info WHERE id =?";
			PreparedStatement pstmt = con.prepareStatement(query);
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Employee Id:- ");
			int id = sc.nextInt();
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					int tid = rs.getInt("id");
					System.out.print("\t" + tid);
					String name = rs.getString("name");
					System.out.print("\t" + name);
					int age = rs.getInt("age");
					System.out.print("\t" + age);
					String designation = rs.getString("desiganation");
					System.out.print("\t" + designation);
					String department = rs.getString("department");
					System.out.print("\t" + department);
					float salary = rs.getInt("salary");
					System.out.println("\t" + salary);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	// Menu View
	public static void menu() {
		System.out.println("****************************************");
		System.out.println("WELCOME TO EMPLOYEE MANAGEMENT APP");
		System.out.println("****************************************");
		System.out.println("1. Add Employee");
		System.out.println("2. Remove Employee");
		System.out.println("3. Update Emloyee");
		System.out.println("4. View All Employee");
		System.out.println("5. View one Employee");
		System.out.println("6. Exit");
	}

}
