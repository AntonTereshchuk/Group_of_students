package task;

import java.io.File;

public class Main {

	public static void main(String[] args) {
				
		Group group1 = new Group("First group");
		
		Student student1 = new Student("Igor", "Shpek", Gender.man, 1, group1.getGroupName());
		Student student2 = new Student("Taras", "Jamon", Gender.man, 2, group1.getGroupName());
		Student student3 = new Student("Inna", "Salami", Gender.women, 3, group1.getGroupName());
		Student student4 = new Student("Ira", "Superjamon", Gender.women, 4, group1.getGroupName());
		Student student5 = new Student("Dmitriy", "Prosciutto", Gender.man, 5, group1.getGroupName());
		Student student6 = new Student("Dmitriy", "Prosciutto", Gender.man, 5, group1.getGroupName());
		
		try {
			group1.addStudent(student1);
			group1.addStudent(student2);
			group1.addStudent(student3);
			group1.addStudent(student4);
			group1.addStudent(student5);
			group1.addStudent(student6);
//			If you want overflow exception, you can receive it	
//			group1.addStudent(student1);
//			group1.addStudent(student2);
//			group1.addStudent(student3);
//			group1.addStudent(student4);
//			group1.addStudent(student5);
//			group1.addStudent(student5);
		} catch (GroupOverflowException e) {
			
			e.printStackTrace();
		}
		
		//System.out.println(group1);
				
		//System.out.println(group1.removeStudentByID(3));
		//System.out.println();		
		
//		try {
//			System.out.println(group1.searchStudentByLastName("Salami"));
//		} catch (StudentNotFoundException e) {
//			e.printStackTrace();
//		}
		
		//System.out.println();
		
		//System.out.println(group1);
								
//		try {
//			group1.addStudent(CreateStudentUsingScanner.createStudent());
//		} catch (GroupOverflowException e) {
//			e.printStackTrace();
//		}
		
		group1.sortStudentsByLastName();
		//System.out.println(group1);
		
		GroupFileStorage.saveGroupToCSV(group1);
		
		System.out.println();
						
		File fileCsv = new File("First group.csv");
		Group loadedGroup = GroupFileStorage.loadGroupFromCSV(fileCsv);
		System.out.println(loadedGroup);
		
		File workFolder = new File("D:/Work/JAVA/Java projects/Group_of_students_oop");
		File foundFile = GroupFileStorage.findFileByGroupName(group1.getGroupName(), workFolder);
		System.out.println(foundFile);
				
		System.out.println();
		System.out.println("Founded duplicates of students in " + group1.getGroupName() +": " + group1.chekEqualStudentsInGroup());
		
	}

}
