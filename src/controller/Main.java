package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Scanner;

import businesslogic.ManagerLoginValidation;
import dao.EmployeeDao;
import dao.ManagerloginDao;
import model.EmployeeDetail;
import model.ManagerSignup;

class Front {
	int choice = 0, e = 0;
	EmployeeDetail emp = null;
	EmployeeDao empdao = new EmployeeDao();
	ManagerLoginValidation cv = new ManagerLoginValidation();

	void Manager() throws IOException, ParseException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("ENTER YOUR CHOICE-");
			System.out.println("1. Add Employee Detail" + " \n");
			System.out.println("2. Read All Employees Detail  " + "\n" + " 3.Update Employee data");
			System.out.println("4. Calculate Salary " + "\n" + "5. Attendence read" + "\n" + "6. Log out");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Employee ID :");
				String id = br.readLine();
				System.out.println("Enter Name : ");
				String nm = br.readLine();
				System.out.println("Enter e-mail : ");
				String em = br.readLine();
				if (cv.validEmail(em)) {
					System.out.println("Enter PAN no. : ");
					String pan = br.readLine();
					System.out.println("Enter password for employee to login ");
					String pswd = br.readLine();
					if (cv.validPassword(pswd)) {
						System.out.print("ENTER DATE of joining Format (dd/mm/yyyy ): ");
						String doj = br.readLine();
						System.out.println("Enter Job Title : ");
						String jt = br.readLine();
						System.out.println("Enter Department : ");
						String dp = br.readLine();
						System.out.println("Enter Current Address :");
						String ca = br.readLine();
						System.out.println("Enter Employee Annual CTC : ");
						Double ac = Double.parseDouble(br.readLine());
						System.out.println("Enter Employee Account No. :");
						Long an = Long.parseLong(br.readLine());

						emp = new EmployeeDetail(id, nm, em, pan, pswd, doj, jt, dp, ca, ac, an);
						e = empdao.addEmp(emp);
					}
				}
				if (e < 0)
					System.out.println("Error in Addition. Please Enter Again... ");
				break;
			/*
			 * case 2: System.out.println(" Please Enter Employee Unique ID: : "); String
			 * idd = br.readLine(); String emid = empdao.search(idd); if (emid.equals(idd))
			 * empdao.deleteEmp(idd); else
			 * System.out.println("YOU MAY HAVE ENTERED WRONG EMPLOYEE ID"); break;
			 */
			case 2:
				empdao.readEmp();
				System.out.println();
				break;
			case 3:
				System.out.println("Enter Employee ID to do Updation:");
				String eid = br.readLine();
				String empid = empdao.search(eid);
				if (empid.equals(eid)) {
					System.out.println("Enter new Annual CTC");
					double d = Double.parseDouble(br.readLine());
					empdao.updateEmp(eid, d);
				} else
					System.out.println("YOU MAY HAVE ENTERED WRONG EMPLOYEE ID");
				break;
			case 4:
				double salary = 0;
				System.out.println("Entr Employee ID to calculate salary:");
				String ide = br.readLine();
				String mpid = empdao.search(ide);
				if (mpid.contentEquals(ide)) {
					salary = empdao.calculateSalary(ide);
				} else
					System.out.println("YOU MAY HAVE ENTERED WRONG EMPLOYEE ID");
				System.out.println("Calculated Monthly Salary----" + salary);
				System.out.println("Enter SID:");
				String iddd = br.readLine();
				String iemp = empdao.searchSal(iddd);
				// System.out.println(iemp);
				if (iemp.equals(iddd)) {
					// System.out.println("in if equals");
					empdao.storeSalary(iddd, salary);
				}
				break;
			case 5:
				empdao.readAttendence();
				break;
			case 6:
				break;
			}
		} while (choice != 6);
	}
}

public class Main {
	public static void main(String args[]) {
		ManagerLoginValidation cv = new ManagerLoginValidation();
		ManagerloginDao mdao = new ManagerloginDao();
		ManagerSignup mlogin = null;
		EmployeeDetail empd = null;
		EmployeeDao empdao = new EmployeeDao();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int choice;
		Front fobj = new Front();
		System.out.println("SALARY PAY SYSTEM ");
		System.out.println("------------------------------");
		while (true) {
			System.out.println("ENTER YOUR CHOICE");
			System.out.println("------------------------------");
			System.out.println("1. Manager Log in " + "\n" + "2. Manager Sign up " + "\n" + "3. Employee login");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				try {
					System.out.println("Enter Email : ");
					String email = br.readLine();
					if (cv.validEmail(email)) {
						System.out.println("Enter Password : ");
						String pwd = br.readLine();
						if (cv.validPassword(pwd)) {
							mlogin = new ManagerSignup(email, pwd);
							boolean rs = mdao.login(mlogin);
							if (rs == true) {
								System.out.println("LOGIN DONE");
								try {
									fobj.Manager();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					} else
						System.out.println(" RE-ENTER ");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					System.out.println("Enter Manager ID:");
					String mid = br.readLine();
					System.out.println("Enter Name");
					String name = br.readLine();
					System.out.println("Enter E-mail:");
					String em = br.readLine();
					if (cv.validEmail(em)) {
						System.out.println("Enter Mobile No.:");
						String number = br.readLine();
						if (cv.validMobile(number)) {
							System.out.println("Min. 6 characters.One UPPERCASE & one digit. Enter Password :  ");
							String psswd = br.readLine();
							if (cv.validPassword(psswd)) {
								System.out.println("Enter Confirm Password : ");
								String cpswd = br.readLine();
								if (cv.validConfPassword(psswd, cpswd)) {
									mlogin = new ManagerSignup(mid, em, name, number, psswd, cpswd);
									// if (cv.checkManagerSignup(em, number, psswd, cpswd)) {
									mdao.signUp(mlogin);
									System.out.println("------------------------------------------");
								}
							}
						}
					} else {
						System.out.println("SORRY ! YOU MAY HAVE FILLED INCORRECT DETAILS");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 3:
				try {
					System.out.println("Enter Email : ");
					String mail = br.readLine();
					if (cv.validEmail(mail)) {
						System.out.println("Enter Password : ");
						String pswd = br.readLine();
						if (cv.validPassword(pswd)) {
							empd = new EmployeeDetail(mail, pswd);
							empdao.checkLogin(empd);
							System.out.println("LOGIN DONE");
							System.out.println("------------------");
							System.out.println("Enter YOUR EID:");
							String ee = br.readLine();
							String empid = empdao.searchAttendence(ee);
							if (empid.equals(ee)) {
								empdao.markAttendence(ee);
							}
						} else {
							System.out.println("You Entered invalid detail");
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}