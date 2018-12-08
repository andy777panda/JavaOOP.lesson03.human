package net.ukr.andy777;

/*
 3. Создать класс Группа/Group, который содержит массив из 10 объектов класса Студент/Student.
 Реализовать методы добавления, удаления студента из группы и поиска по фамилии.
 В случае попытки добавления 11го студента создать собственное исключение и обработать его.
 Определить метод toString() для группы так, чтобы он выводил список студентов в алфавитном порядке.
 */

public class Group {
	private String groupName; // group name = назва групи
	private String groupNumber; // group number = номер групи
	private int count; // amount of students in group = кількість студентів в
	// групі
	private Student[] group = new Student[10]; // array Student = масив судентів

	/* constructors = конструктори */
	public Group() {
		super();
	}

	public Group(String groupName, String groupNumber) {
		super();
		this.groupName = groupName;
		this.groupNumber = groupNumber;
	}

	public Group(String groupName, String groupNumber, Student[] group) {
		super();
		this.groupName = groupName;
		this.groupNumber = groupNumber;
		this.group = group;
	}

	/* setters and getters = сеттери та геттери */

	// group name = назва групи
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	// group number = номер групи
	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	// array of Student[] = масив судентів
	public Student[] getGroup() {
		return group;
	}

	public void setGroup(Student[] group) {
		this.group = group;
	}

	// amount of students in group = кількість студентів в групі
	public int getCount() {
		return count;
	}

	// toString method = метод виводу інформації про екземпляр класу Group
	public String toString() {
		String resStr = "";
		int i = 0;
		for (Student st : this.getGroup())
			resStr += "\n" + ++i + ". " + st;
		return "Group [" + this.getGroupName() + " #" + this.getGroupNumber()
				+ "] consists of such students:" + resStr;
	}

	/**
	 * Get string-line sorted elemets of group (array of Students) = метод
	 * отримання строкового рядка відсортованих елементів групи (масиву
	 * студентів)
	 * 
	 * @param az
	 *            <code>int</code> sort direction (+0=AZ; -0=Z; 0=unsort)
	 * @return String value.
	 * @author ap
	 */
	public String getSortGroup(int az) {
		String[] sts = new String[this.getGroup().length];
		String resStr = "";
		for (int i = 0; i < this.getGroup().length; i++) {
			try {
				sts[i] = this.getGroup()[i].toString();
			} catch (NullPointerException e) {
				sts[i] = "";
			}
		}
		sts = AP.sortArray(sts, az);
		for (int i = 0; i < sts.length; i++) {
			if (sts[i] != "")
				resStr += "\n" + sts[i];
		}
		return "Sorted " + direction(az) + "\t Group [" + this.getGroupName()
				+ " #" + this.getGroupNumber() + "] consists of such students:"
				+ resStr;
	}

	// return string value of sort direction = метод повертає напрямок сортуання
	private static String direction(int az) {
		if (az > 0)
			return "AZ ";
		else if (az < 0)
			return "ZA ";
		else
			return "unsorted ";
	}

	// В случае попытки добавления 11го студента создать собственное исключение
	// и обработать его.
	/**
	 * Add Student to Group = метод додавання студента до групи
	 * 
	 * @param st
	 *            <code>Student</code> element of class Student
	 * @author ap
	 */
	public void addStudentToGroup(Student st) throws MyException {
		System.out.print("Add student = додавання студента: " + st + " ==>> "
				+ "\n\t");
		String id = "(" + this.getGroupName() + " #" + this.getGroupNumber()
				+ ")";
		boolean add = false;
		for (int i = 0; i < this.getGroup().length; i++) {
			if (this.getGroup()[i] == null) {
				this.getGroup()[i] = st;
				add = true;
				break;
			}
		}
		if (!add)
			throw new MyException(1, id);
		String resStr = "the student has been ADDED to the group"
				+ " = студента ДОДАНО до групи ";
		System.out.println(resStr + id);
	}

	/**
	 * Try-Catch method for add Student to Group = метод з контролем на
	 * виключення додавання студента до групи
	 * 
	 * @param st
	 *            <code>Student</code> element of class Student
	 * @author ap
	 */
	public void tcAddStudentToGroup(Student st) {
		try {
			addStudentToGroup(st);
		} catch (MyException е) {
			System.out.println("intercepted exception"
					+ " = перехвачено виключення: " + е);
		}
	}

	/**
	 * Remove Student from Group = метод видалення студента з групи
	 * 
	 * @param st
	 *            <code>Student</code> element of class Student
	 * @author ap
	 */
	public void removeStudentFromGroup(Student st) throws MyException {
		System.out.print("Exclude student = виключення студента: " + st
				+ " ==>> " + "\n\t");
		String resStr = "an exception is not possible. student is not in the group"
				+ " = виключення не можливе. студент не в групі ";
		String id = "(" + this.getGroupName() + " #" + this.getGroupNumber()
				+ ")";
		if (st == null)
			throw new MyException(2, id);
		for (int i = 0; i < this.getGroup().length; i++) {
			if (this.getGroup()[i] == st) {
				this.getGroup()[i] = null; // exclude student = видаляємо
				// студента
				this.count = this.getCount() - 1; // reduce counter = зменшуємо
				// лічільник
				resStr = "the student is EXCUDED from the group"
						+ " = студента ВИКЛЮЧЕНО з групи ";
				break;
			}
		}
		System.out.println(resStr + id);
	}

	/**
	 * Try-Catch method for remove Student from Group = метод з контролем на
	 * виключення видалення студента з групи
	 * 
	 * @param st
	 *            <code>Student</code> element of class Student
	 * @author ap
	 */
	public void tcRemoveStudentFromGroup(Student st) {
		try {
			removeStudentFromGroup(st);
		} catch (MyException е) {
			System.out.println("intercepted exception"
					+ " = перехвачено виключення: " + е);
		}
	}

	/**
	 * Finding a student by second name = метод пошуку студента за прізвищем
	 * 
	 * @param sName
	 *            <code>String</code> second name(surname)
	 * @return count of found surnames
	 * @author ap
	 */
	public int findSecondName(String sName) {
		String id = "(" + this.getGroupName() + " #" + this.getGroupNumber()
				+ ")";
		System.out.print("Find student in group = пошук студента в групі " + id
				+ ": " + sName + " ==>> ");
		String resStr = "";
		int q = 0; // finds counter = лічильник знахідок
		for (int i = 0; i < this.getGroup().length; i++) {
			if (this.getGroup()[i] == null)
				continue;
			if (this.getGroup()[i].getSecondName() == sName) {
				q++;
				resStr += "\n\t\t" + (i + 1) + ". "
						+ this.getGroup()[i].toString();
			}
		}
		resStr = "\t found students = знайдено студентів: " + q + resStr;
		System.out.println(resStr);
		return q;
	}
}
