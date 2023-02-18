package task;

import java.util.Scanner;

public class CreateStudentUsingScanner {
	
	public static Student createStudent() {
		
		Scanner sc = new Scanner(System.in);
		Student newStudent = new Student();
		String newGender;
		
		System.out.println("Enter name: ");
		newStudent.setName(sc.nextLine());
		System.out.println("Enter last name: ");
		newStudent.setLastName(sc.nextLine());
		System.out.println("Enter gender: ");
		newGender = sc.nextLine();
		if (Gender.man.name().equals(newGender)) {
			newStudent.setGender(Gender.man);
		} else if (Gender.women.name().equals(newGender)) {
			newStudent.setGender(Gender.women);
		} else {
			System.out.println("Wrong value of gender");
		}
		System.out.println("Enter id: ");
		newStudent.setId(sc.nextInt());
		System.out.println("Enter group name: ");
		sc.nextLine();
		newStudent.setGroupName(sc.nextLine());
				
		sc.close();
		
		return newStudent;
				
	}

}
