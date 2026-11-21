package com.controller;

import java.util.Scanner;

import com.serviceimple.PassportServiceImple;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PassportServiceImple passport = new PassportServiceImple();

		boolean flag = true;

		while (flag) {
			System.out.println("*****************************************");
			System.out.println("*****************************************");
			System.out.println("**  1. Add Person                      **");
			System.out.println("**  2. Get Person Using Pid            **");
			System.out.println("**  3. Get Adhar Using Pid             **");
			System.out.println("**  4. Update Person Using Pid         **");
			System.out.println("**  5. Update Adhar Using Pid          **");
			System.out.println("**  6. Delete Person Using Pid         **");
			System.out.println("**  7. Delete Adhar Using Pid          **");
			System.out.println("**  8. Get Person Using Aid            **");
			System.out.println("**  9. Get Adhar Using Aid             **");
			System.out.println("**  10.Update Person Using Aid         **");
			System.out.println("**  11.Update Adhar Using Aid          **");
			System.out.println("**  12.Delete Person Using Aid         **");
			System.out.println("**  13.Delete Adhar Using Aid          **");
			System.out.println("**  14.Exit                            **");
			System.out.println("*****************************************");
			System.out.println("*****************************************");
			System.out.println("Enter Your Choice 1 to 14:");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				passport.addperson();
				break;
			case 2:
				passport.getPersonOnlyUsingPid();
				break;
			case 3:
				passport.getAdharOnlyUsingPid();
				break;
			case 4:
				passport.updatePersonDetailsUsingPid();
				break;
			case 5:
				passport.updateAdharDetailsUsingPid();
				break;
			case 6:
				passport.deletePersonOnlyUsingPid();
				break;
			case 7:
				passport.deleteAdharOnlyUsingPid();
				break;
			case 8:
				passport.getPersonOnlyUsingAid();
				break;
			case 9:
				passport.getAdharOnlyUsingAid();
				break;
			case 10:
				passport.updatePersonDetailsUsingAid();
				break;
			case 11:
				passport.updateAdharDetailsUsingAid();
				break;
			case 12:
				passport.deletePersonOnlyUsingAid();
				break;
			case 13:
				passport.deleteAdharOnlyUsingAid();
				break;
			case 14:
				flag = false;
				break;
			default:
				System.out.println("Invalid Choice...");
			}
		}
	}

}
