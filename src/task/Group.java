package task;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
	
	private String groupName;
	private Student[] students;
	
	public Group(String groupName) {
		super();
		this.groupName = groupName;
		students = new Student[10];
	}
		
	public Group() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}
	
	public void addStudent(Student student) throws GroupOverflowException {
		
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				return;
			}
		}
		
		throw new GroupOverflowException();
		
	}
	
	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getLastName() == lastName) {
					return students[i];
				}
			}
		}
		
		throw new StudentNotFoundException();
		
	}
	
	public boolean removeStudentByID(int id) {
		
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (students[i].getId() == id) {
					students[i] = null;
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public void sortStudentsByLastName() {
		Arrays.sort(students, Comparator.nullsFirst(new LastNameComparator()));
	}

	@Override
	public String toString() {
		
		String result = getGroupName() + System.lineSeparator();
		
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				result += students[i] + System.lineSeparator();
			}
		}
		
		return result; 
	
	}
	
}
