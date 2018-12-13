package net.ukr.andy777;

/*
 2. На основе класса Человек/Human создать класс Студент/Student. И переопределить метод вывода информации.
 */

public class Student extends Human {

	// protected Human human; // екземпляр класу Human
	protected int recordNumber; // record number = номер заліковки
	protected String highSchool; // higher school = навчальний заклад
	protected int yearStudy; // year of study = рік навчання

	/* constructors = конструктори */
	public Student() {
		super();
	}

	public Student(Human human, int recordNumber, String highSchool,
			int yearStudy) {
		super(human.getSecondName(), human.getFirstName(), human
				.getMiddleName(), human.getAge(), human.isSex());
		this.recordNumber = recordNumber;
		this.highSchool = highSchool;
		this.yearStudy = yearStudy;
	}

	public Student(Human human, int recordNumber) {
		super(human.getSecondName(), human.getFirstName(), human
				.getMiddleName(), human.getAge(), human.isSex());
		this.recordNumber = recordNumber;
	}

	public Student(String secondName, String firstName, String middleName,
			int age, boolean sex, int recordNumber, String highSchool,
			int yearStudy) {
		super(secondName, firstName, middleName, age, sex);
		this.recordNumber = recordNumber;
		this.highSchool = highSchool;
		this.yearStudy = yearStudy;
	}

	public Student(String secondName, String firstName, String middleName,
			int age, boolean sex, int recordNumber) {
		super(secondName, firstName, middleName, age, sex);
		this.recordNumber = recordNumber;
	}

	/* setters and getters = сеттери та геттери */

	// higher school = навчальний заклад
	public String getHighSchool() {
		return highSchool;
	}

	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}

	// year of study = рік навчання
	public int getYearStudy() {
		return yearStudy;
	}

	public void setYearStudy(int yearStudy) {
		this.yearStudy = yearStudy;
	}

	// record number = номер заліковки
	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}

	// toString method = перевизначений метод виводу інформації про екземпляр
	// класу Student
	@Override
	public String toString() {
		return "Student [" + secondName + " " + firstName + " " + middleName
				+ " (" + age + "-years, " + (sex ? "male" : "female")
				+ ") recordNumber-" + recordNumber + ", HighSchool-"
				+ highSchool + ", grade-" + yearStudy + "]";
	}

	public String toStringR() {
		return "Student [" + secondName + " " + firstName + " " + middleName
				+ " (" + age + "-years, " + (sex ? "male" : "female")
				+ ") recordNumber-" + recordNumber + "]";
	}

	// !!!! methot needs to be improved, for future = метод потребує
	// доопрацювання, на майбутнє
	/**
	 * Comparing two instances of a class Student = метод порівняння двох
	 * екземпляір класу Student
	 * 
	 * @param person
	 *            <code>Student</code> instances of a class Student
	 * @return boolean true-value if equals
	 * @author ap
	 */
	public boolean equals(Student person) {
		boolean res = false;
		if (this.secondName.equals(person.getSecondName())
				&& this.firstName.equals(person.getFirstName())
				&& this.middleName.equals(person.getMiddleName())
				&& this.age == person.getAge() && this.sex == person.isSex()
				&& this.highSchool.equals(person.getHighSchool())
				&& this.yearStudy == person.getYearStudy()) {
			res = true;
		}
		return res;
	}

}
