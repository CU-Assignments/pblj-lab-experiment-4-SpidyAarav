Experiment 4.1: Employee Management System

The Employee Management System is a simple Java-based application that uses ArrayList to manage employee records. The system allows users to perform the following operations:

Add Employee → Store Employee ID, Name, and Salary.

Update Employee → Modify employee details based on their ID.

Remove Employee → Delete an employee using their ID.

Search Employee → Find employees by ID or Name.

Display All Employees → Show a complete list of employees.

Test Cases

Test Case 1: Adding Employees (No Employees Initially)
Display Employees
Expected Output:
No employees found.
  
Test Case 2: Add Employees
Input:
Add Employee (ID=101, Name="Anish", Salary=50000)
Add Employee (ID=102, Name="Bobby", Salary=60000)
Expected Output:
Employee Added: ID=101, Name=Anish, Salary=50000
Employee Added: ID=102, Name=Bobby, Salary=60000

Test Case 3: Update Employee Salary
Input:
Update Employee (ID=101, New Salary=55000)
Expected Output:
Employee ID 101 updated successfully.

Test Case 4: Search Employee by ID
Input:
Search Employee by ID=102
Expected Output:
Employee Found: ID=102, Name=Bobby, Salary=60000

Test Case 5: Remove Employee
Input:
Remove Employee (ID=101)
Expected Output:
Employee ID 101 removed successfully.

Test Case 6: Display All Employees
Input:
Display Employees
Expected Output:
ID: 102, Name: Bobby, Salary: 60000

Test Case 7: Adding Duplicate Employee ID
Input:
Add Employee (ID=101, Name="Charlie", Salary=70000)

  Code:
import java.util.ArrayList;
 import java.util.Scanner;
 class Employee
 { int id;
 String name;
 double salary;
 public Employee(int id, String name, double salary)
 { this.id = id;
 this.name = name;
 this.salary = salary;
 }
 @Override
 public String toString() {
 return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
 }
 }
 public class EmployeeManagement {
 static ArrayList<Employee> employees = new ArrayList<>();
 static Scanner scanner = new Scanner(System.in);
 public static void addEmployee()
 { System.out.print("Enter ID: ");
 int id = scanner.nextInt();
 scanner.nextLine(); // Consume newline
 System.out.print("Enter Name: ");
 String name = scanner.nextLine();
 System.out.print("Enter Salary: ");
 double salary = scanner.nextDouble();
 employees.add(new Employee(id, name, salary));
 }
 public static void updateEmployee()
 { System.out.print("Enter Employee ID to update: ");
 int id = scanner.nextInt();
 for (Employee emp : employees)
 { if (emp.id == id) {
 scanner.nextLine();
 System.out.print("Enter New Name: ");
 emp.name = scanner.nextLine();
 System.out.print("Enter New Salary: ");
 emp.salary = scanner.nextDouble();
 System.out.println("Updated Successfully!");
 return;
 }
 }
 System.out.println("Employee Not Found!");
 }
 public static void removeEmployee()
 { System.out.print("Enter Employee ID to remove: ");
 int id = scanner.nextInt();
 employees.removeIf(emp-> emp.id == id);
 System.out.println("Removed Successfully!");
 }
 public static void searchEmployee()
 { System.out.print("Enter Employee ID to search: ");
 int id = scanner.nextInt();
 for (Employee emp : employees) {
DEPARTMENTOF
 COMPUTERSCIENCE&ENGINEERING
 if (emp.id == id)
 { System.out.println(emp);
 return;
 }
 }
 System.out.println("Employee Not Found!");
 }
 public static void main(String[] args)
 { while (true) {
 System.out.println("\n1. Add 2. Update 3. Remove 4. Search 5. Exit");
 int choice = scanner.nextInt();
 switch (choice) {
 case 1-> addEmployee();
 case 2-> updateEmployee();
 case 3->removeEmployee();
 case 4-> searchEmployee();
 case 5-> System.exit(0);
 default-> System.out.println("Invalid Choice!");
 }
 }
 }
 }
Expected Output:
Error: Employee with ID 101 already exists.


