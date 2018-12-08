package net.ukr.andy777;

/*
 1. Создать класс Человек/Human, описывающий человека (Ф.,И.,О., возраст, пол)
 Создать метод, выводящий информацию о человеке.
 */

public class Human {

	protected String secondName; // surname = прізвище
	protected String firstName; // name = ім'я
	protected String middleName; // patronymic = по-батькові
	protected int age; // years old = вік
	protected boolean sex; // gender = стать

	/* constructors = конструктори */
	public Human() {
		super();
	}

	public Human(String secondName, String firstName, String middleName,
			int age, boolean sex) {
		super();
		this.secondName = secondName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.age = age;
		this.sex = sex;
	}

	/* setters and getters = сеттери та геттери */

	// surname = прізвище
	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * Randomizing second name from list depending of sex = метод випадкової
	 * генерації прізвища зі списку в залежності від статі
	 * 
	 * @return String value.
	 * @author ap
	 */
	public static String setSecondNameRnd(boolean sex) {
		// initializing list of male second names
		// = ініціалізація списку чоловічих прізвищ
		String[] secondNameM = { "АНДРІЄВ","БОБРОВ", "ВОЛОДЬКОВ", "ДИМИТРІВ",
				"ЗАХАРЕНКОВ", "ІВАНОВ", "КОСТЕНКОВ", "МИКОЛАЄНКОВ",
				"НАЗАРЕНКОВ", "ОЛЕКСІЄНКОВ", "ПЕТРОВ", "РОМАНОВ", "СЕРГІЄВ",
				"ТАРАСОВ", "ФЕДОРОВ", "ЮХИМОВ" };

		// initializing list of female second names
		// = ініціалізація списку жіночих прізвищ
		String[] secondNameF = { "АНДРІЄВА", "БОБРОВА", "ВОЛОДЬКОВА",
				"ДИМИТРІВА", "ЗАХАРЕНКОВА", "ІВАНОВА", "КОСТЕНКОВА",
				"МИКОЛАЄНКОВА", "НАЗАРЕНКОВА", "ОЛЕКСІЄНКОВА", "ПЕТРОВА",
				"РОМАНОВА", "СЕРГІЄВА", "ТАРАСОВА", "ФЕДОРОВА", "ЮХИМОВА" };

		return (sex ? secondNameM[(int) (Math.random() * secondNameM.length)]
				: secondNameF[(int) (Math.random() * secondNameF.length)]);
	}

	// name = ім'я
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Randomizing first name from list depending of sex = метод випадкової
	 * генерації імені зі списку в залежності від статі
	 * 
	 * @return String value.
	 * @author ap
	 */
	public static String setFirstNameRnd(boolean sex) {
		// initializing list of male first names
		// = ініціалізація списку чоловічих імен
		String[] firstNameM = { "Андрій", "Борис", "Володимир", "Дмитро",
				"Захар", "Іван", "Костянтин", "Микола", "Назар", "Олексій",
				"Петро", "Роман", "Сергій", "Тарас", "Федір", "Юхим" };

		// initializing list of female first names
		// = ініціалізація списку жіночих імен
		String[] firstNameF = { "Антоніна", "Віталіна", "Владлена", "Ангеліна",
				"Зоряна", "Іванна", "Людмила", "Марія", "Наталя", "Олександра",
				"Христина", "Романа", "Світлана", "Тетяна", "Уляна", "Юлія" };

		return (sex ? firstNameM[(int) (Math.random() * firstNameM.length)]
				: firstNameF[(int) (Math.random() * firstNameF.length)]);
	}

	// patronymic = по-батькові
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Randomizing first name from list depending of sex = метод випадкової
	 * генерації імені зі списку в залежності від статі
	 * 
	 * @return String value.
	 * @author ap
	 */
	public static String setMiddleNameRnd(boolean sex) {
		// initializing list of male middle names
		// = ініціалізація списку чоловічих імен по-батькові
		String[] middleNameM = { "Андрійович", "Борисович", "Володимирович",
				"Дмитрович", "Захарович", "Іванович", "Костянтинович",
				"Миколайович", "Назарович", "Олексійович", "Петрович",
				"Романович", "Сергійович", "Тарасович", "Федорович", "Юхимович" };

		// initializing list of female middle names
		// = ініціалізація списку жіночих імен по-батькові
		String[] middleNameF = { "Андріївна", "Борисівна", "Володимирівна",
				"Дмитрівна", "Захарівна", "Іванівна", "Костянтинівна",
				"Миколаївна", "Назарівна", "Олександрівна", "Павлівна",
				"Романівна", "Сергіївна", "Тарасівна", "Федорівна", "Юріївна" };

		return (sex ? middleNameM[(int) (Math.random() * middleNameM.length)]
				: middleNameF[(int) (Math.random() * middleNameF.length)]);
	}

	// years old = вік
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// gender = стать (true = male/чоловіча)
	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	// toString method = метод виводу інформації про екземпляр класу Human
	public String toString() {
		return "Human [" + this.getSecondName() + " " + this.getFirstName()
				+ " " + this.getMiddleName() + " (" + this.getAge()
				+ "-years, " + (this.isSex() ? "male" : "female") + ")]";
	}

	/**
	 * Method randomize initialazation of new Human element depending of age
	 * range and sex = Метод ініціалізації нового елементу класу Human в
	 * залежності від діапазону віку та статі
	 * 
	 * @param a1
	 *            <code>int</code> minimum age of human
	 * @param a2
	 *            <code>int</code> maximum age of human
	 * @param sex
	 *            <code>boolean</code> sex of human
	 * @return Human element.
	 * @author ap
	 */
	public static Human rndHuman(int a1, int a2, boolean sex) {
		return new Human(setSecondNameRnd(sex), setFirstNameRnd(sex),
				setMiddleNameRnd(sex), AP.rndInteger(a1, a2), sex);
	}
}