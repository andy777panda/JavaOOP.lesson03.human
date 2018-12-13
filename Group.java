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
		for (Student st : group)
			resStr += "\n" + ++i + ". " + st;
		return "Group [" + groupName + " #" + groupNumber
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
		String[] sts = new String[group.length];
		String resStr = "";
		for (int i = 0; i < group.length; i++) {
			try {
				sts[i] = group[i].toString();
			} catch (NullPointerException e) {
				sts[i] = "";
			}
		}
		sts = AP.sortArray(sts, az);
		for (int i = 0; i < sts.length; i++) {
			if (sts[i] != "")
				resStr += "\n" + sts[i];
		}
		return "Sorted " + direction(az) + "\t Group [" + groupName + " #"
				+ groupNumber + "] consists of such students:" + resStr;
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

	
	// Реализовать метод добавления студента в группу. В случае попытки
	// добавления 11го студента создать собственное исключение и обработать его.
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
		String id = "(" + groupName + " #" + groupNumber + ")";

		// search same recordNumber in group = 
		// пошук однакового номеру заліковки в групі
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				if (group[i].getRecordNumber() == st.getRecordNumber()) {
					throw new MyException(3, id);
				}
			}
		}

		// search free place in group = 
		// пошук вільного місця в групі
		boolean add = false;
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				group[i] = st;
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

	// Реализовать метод удаления студента из группы.
	/**
	 * Remove Student from Group by recordNumber = метод видалення студента з
	 * групи по номеру заліковки
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
		String id = "(" + groupName + " #" + groupNumber + ")";
		if (st == null)
			throw new MyException(2, id);
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null)
				continue;

			// if (group[i].equals(st)) { 
			// !!!! methot EQUALS needs to be improved, for future = 
			// метод потребує доопрацювання, на майбутнє

			// currently, identification is only on the recordNumber = 
			// наразі ідентифікація лише по номеру заліковки
			if (group[i].getRecordNumber() == st.getRecordNumber()) {
				group[i] = null; // exclude student = видаляємо студента
				count--; // reduce counter = зменшуємо лічільник
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

	// Реализовать метод поиска студента по фамилии.
	/**
	 * Finding a student by second name = метод пошуку студента за прізвищем
	 * 
	 * @param sName
	 *            <code>String</code> second name(surname)
	 * @return count of found surnames
	 * @author ap
	 */
	public Student[] findSecondName(String sName) {
		Student[] findList = new Student[0];// result array == масив результатів
		String id = "(" + groupName + " #" + groupNumber + ")";
		System.out.print("Find student in group = пошук студента в групі " + id
				+ ": " + sName + " ==>> ");
		String resStr = "";
		int q = 0; // finds counter = лічильник знахідок
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null)
				continue;
			if (group[i].getSecondName().equalsIgnoreCase(sName)) {
				// розширюємо масив знайдених студентів
				findList = AP.resize(findList, 1);
				// ініціалізуємо знайденого студента в масиві результатів
				findList[q++] = group[i];
				resStr += "\n\t\t" + (i + 1) + ". " + group[i].toString();
			}
		}
		resStr = "\t found students = знайдено студентів: " + q + resStr;
		System.out.println(resStr);
		return findList;
	}

}
