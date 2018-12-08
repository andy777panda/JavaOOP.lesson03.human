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

	/**
	 * Randomizing high school from list = метод випадкової генерації вищого
	 * навчального закладу зі списку
	 * 
	 * @return String value.
	 * @author ap
	 */
	public static String setHighScoolRnd() {
		// initializing list of high schools
		// = ініціалізація списку навчальних закладів
		String[] highScool = { "КНУ", "КПІ", "КНЕУ", "КМА", "КТЕУ", "НМУ",
				"МАУП", "НАУ" };

		return (highScool[(int) (Math.random() * highScool.length)]);
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
		return "Student [" + this.getSecondName() + " " + this.getFirstName()
				+ " " + this.getMiddleName() + " (" + this.getAge()
				+ "-years, " + (this.isSex() ? "male" : "female")
				+ ") HighSchool-" + this.getHighSchool() + ", grade-"
				+ this.getYearStudy() + "]";
	}

	/**
	 * Method randomize initialazation of new Student element depending of age
	 * range, sex and grade range = Метод ініціалізації нового елементу класу
	 * Student в залежності від діапазону віку, статі та діапазону року
	 * навчання.
	 * 
	 * @param a1
	 *            <code>int</code> minimum age of student
	 * @param a2
	 *            <code>int</code> maximum age of student
	 * @param sex
	 *            <code>boolean</code> sex of student
	 * @param g1
	 *            <code>int</code> minimum grade of student
	 * @param g2
	 *            <code>int</code> maximum grade of student
	 * @return Student element.
	 * @author ap
	 */
	public static Student rndStudent(int a1, int a2, boolean sex, int g1, int g2) {
		return new Student(Human.rndHuman(a1, a2, sex), setHighScoolRnd(), AP
				.rndInteger(g1, g2));
	}

	/**
	 * Method randomize initialazation of new Student element depending of age
	 * range, sex and grade range = Метод ініціалізації нового елементу класу
	 * Student в залежності від діапазону віку, статі та діапазону року
	 * навчання.
	 * 
	 * @param hm
	 *            <code>Human</code> element of class Human
	 * @param g1
	 *            <code>int</code> minimum grade of student
	 * @param g2
	 *            <code>int</code> maximum grade of student
	 * @return Student element.
	 * @author ap
	 */
	public static Student rndStudent(Human hm, int g1, int g2) {
		return new Student(hm, setHighScoolRnd(), AP.rndInteger(g1, g2));
	}

}
