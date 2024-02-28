package EmployeeManagementApp;
import java.util.Scanner;

public class Main extends Employee {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		while (true) {
			menu();
			System.out.print("Enter your choice:- ");
			int choice;
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				AddEmployee();
				break;
			case 2:
				RemoveEmployee();
				break;
			case 3:
				UpdateEmp();
				break;
			case 4:
				ViewAllemp();
				break;
			case 5:
				ViewOneEmp();
				break;

			case 6:
				sc.close();
				return;
			default:
				System.out.println("Invalid Option...");

			}

		}

	}

}
