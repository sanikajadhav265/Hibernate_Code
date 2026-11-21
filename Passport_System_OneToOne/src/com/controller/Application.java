package com.controller;

import java.util.Scanner;

import com.serviceimple.Passportserviceimple;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Passportserviceimple passport = new Passportserviceimple();

		boolean flag = true;

		while (flag) {
			System.out.println("****************************************");
			System.out.println("****************************************");
			System.out.println("**    1. Add Person                   **");
			System.out.println("**    2. Add Passport                 **");
			System.out.println("**    3. Get Person                   **");
			System.out.println("**    4. Get Passport                 **");
			System.out.println("**    5. Update Person                **");
			System.out.println("**    6. Update Passport              **");
			System.out.println("**    7. Delete Person                **");
			System.out.println("**    8. Delete Passport              **");
			System.out.println("**    9. Exit                         **");
			System.out.println("****************************************");
			System.out.println("****************************************");
			System.out.println("Enter Your Choice 1 to 9:");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				passport.addPerson();
				break;
			case 2:
				passport.addPassport();
				break;
			case 3:
				passport.getPerson();
				break;
			case 4:
				passport.getPassportbyId();
				break;

			case 5:
				passport.updatePerson();
				break;
			case 6:
				passport.updatePassportbyId();
				break;
			case 7:
				passport.deletePerson();
				break;
			case 8:
				passport.deletePassportbyId();
				break;
			case 9:
				flag = false;
				break;
			default:
				System.out.println("Invalid Choice...");
			}
		}
	}

}
