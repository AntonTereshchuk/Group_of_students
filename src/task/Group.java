package task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

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
				if (students[i].getLastName().equals(lastName)) {
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
	
	public boolean chekEqualStudentsInGroup() {
		
		boolean duplicatesOfStudentsInAGroup = false;
		
		for (int i = 0; i < students.length; i++) {
			
			Student studentForCheking = students[i];
			int numberOfMatches = 0;
			
			for (int j = 0; j < students.length; j++) {
				if (studentForCheking != null && studentForCheking.equals(students[j])) {
					numberOfMatches += 1;
				}
			}
			
			if (numberOfMatches > 1) {
				duplicatesOfStudentsInAGroup = true;
				System.out.println(studentForCheking.toString() + " with index " + i + " is duplicated");								
			}
			
		}
		
		return duplicatesOfStudentsInAGroup;
		
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(students);
		result = prime * result + Objects.hash(groupName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Arrays.equals(students, other.students);
	}
	
}
