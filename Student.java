package net.ukr.andy777;

/*
 2. На основе класса Человек/Human создать класс Студент/Student. И переопределить метод вывода информации.
 */

public class Student extends Human {

	// protected Human human; // екземпляр класу Human
	protected String highSchool; // higher school = навчальний заклад
	protected int yearStudy; // year of study = рік навчання

	/* constructors = конструктори */
	public Student() {
		super();
	}

	public Student(Human human, String highSchool, int yearStudy) {
		super(human.getSecondName(), human.getFirstName(), human
				.getMiddleName(), human.getAge(), human.isSex());
		this.highSchool = highSchool;
		this.yearStudy = yearStudy;
	}

	public Student(String secondName, String firstName, String middleName,
			int age, boolean sex, String highSchool, int yearStudy) {
		super(secondName, firstName, middleName, age, sex);
		this.highSchool = highSchool;
		this.yearStudy = yearStudy;
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

	// toString method = перевизначений метод виводу інформації про екземпляр
	// класу Student
	@Override
	public String toString() {
		return "Student [" + secondName + " " + firstName + " " + middleName
				+ " (" + age + "-years, " + (sex ? "male" : "female")
				+ ") HighSchool-" + highSchool + ", grade-" + yearStudy + "]";
	}
}
