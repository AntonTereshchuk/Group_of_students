package task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GroupFileStorage {
	
	public static void saveGroupToCSV(Group gr) {
		
		File fileCsv = new File(gr.getGroupName() + ".csv");
				
		try(PrintWriter pw = new PrintWriter(fileCsv)){
			
			Student[] students = gr.getStudents();
			
			for (int i = 0; i < students.length; i++) {
				if (students[i] != null) {
					pw.println(students[i].getName() + " " + students[i].getLastName() + " " + students[i].getGender()
					+ " " + students[i].getId() + " " + students[i].getGroupName());
				}
			}
			
			System.out.println(gr.getGroupName() + " saved to csv file -> " + fileCsv.getAbsolutePath());
			
		}
		 catch(IOException e) {
			e.printStackTrace();
		}
						
	}
	
	public static Group loadGroupFromCSV(File fileCsv) {
		
		String fleName = fileCsv.getName();
		int dotIndex = fleName.lastIndexOf(".");
		String groupName = fleName.substring(0, dotIndex);
				
		Group group = new Group(groupName);
		
		String fileContent = "";
		
		try (Scanner sc = new Scanner(fileCsv)) {
			for (; sc.hasNextLine();) {
				fileContent += sc.nextLine() + System.lineSeparator();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String[] students = fileContent.split(System.lineSeparator());
		
		for (int i = 0; i < students.length; i++) {
			
			String studentString = students[i];
			String[] studentArray = studentString.split(" ");
			Student student = new Student(studentArray[0], studentArray[1], Gender.valueOf(studentArray[2]), Integer.parseInt(studentArray[3]), groupName);
			
			try {
				group.addStudent(student);
			} catch (GroupOverflowException e) {
				e.printStackTrace();
			}
					
		}
		
		return group;
		
	}
	
	public static File findFileByGroupName(String groupName, File workFolder)  {
		
		File[] files = workFolder.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() && files[i].getName().equals(groupName + ".csv")) {
				return files[i];
			}
		}
		
		return null;
		
	}

}
