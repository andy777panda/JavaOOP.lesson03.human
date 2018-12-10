package net.ukr.andy777;

import javax.swing.JOptionPane;

public class AP {

	/**
	 * Randomizing int value in the range from A to B = метод випадкової
	 * генерації цілого числа в діапазоні від А до В
	 * 
	 * @param a
	 *            <code>int</code> minimum integer value of randimizing
	 * @param b
	 *            <code>int</code> maximum integer value of randimizing
	 * @return int value.
	 * @author ap
	 */
	public static int rndInteger(int a, int b) {
		return a + (int) (Math.random() * (b - a + 1));
	}

	/**
	 * Randomizing boolean value = метод випадкової генерації булевої величини
	 * 
	 * @return boolean value.
	 * @author ap
	 */
	public static boolean rndBoolean() {
		return Math.random() < 0.5;
	}

	/**
	 * Screen input integer value from a set range = метод екранного введення
	 * цілого числа з заданого діапазону
	 * 
	 * @return int value.
	 * @author ap
	 */
	public static int inputIntegerDialog(int a, int b, String msg) {
		int res;
		for (;;) {
			try {
				res = Integer.valueOf(JOptionPane
						.showInputDialog("Input integer number in range " + a
								+ " - " + b + "\n" + msg));
				if ((res < a) || (res > b))
					JOptionPane.showMessageDialog(null, "number out of range");
				else
					break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			}
		}
		return res;
	}

	/**
	 * Swap elements of string array = обмін елементів String-масиву
	 * 
	 * @param arr
	 *            <code>String[]</code> array for swaping
	 * @param i
	 *            <code>int</code> array-element for swapping
	 * @param j
	 *            <code>int</code> array-element for swapping
	 * @return String[] swaped array.
	 * @author ap
	 */
	public static String[] swapArrElem(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[i + 1];
		arr[i + 1] = temp;
		return arr;
	}

	/**
	 * Bubble sort string array = метод бульбашкового сортування String-масиву
	 * 
	 * @param arr
	 *            <code>String[]</code> array for sorting
	 * @param az
	 *            <code>int</code> sort direction (+0=AZ; -0=Z; 0=unsort)
	 * @return String[] sorted array.
	 * @author ap
	 */
	public static String[] sortArray(String[] arr, int az) {
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i].compareToIgnoreCase(arr[i + 1]) * az > 0) {
					isSorted = false;
					arr = swapArrElem(arr, i, i + 1);
				}
			}
		}
		return arr;
	}

	
	/**
	 * Resizing array of Students for given value = зміна розмірності масиву
	 * студентів на задану ведичину
	 * 
	 * @param arr
	 *            <code>String[]</code> array for resizing
	 * @param addSize
	 *            <code>int</code> value for resize of array
	 * @return Student[] resizied array
	 * @author ap
	 */
	public static Student[] resize(Student[] arr, int addSize) {
		Student[] temp = new Student[arr.length + addSize];
		System.arraycopy(arr, 0, temp, 0, arr.length);
		return temp;
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
		String[] secondNameM = { "АНДРІЄВ", "БОБРОВ", "ВОЛОДЬКОВ", "ДИМИТРІВ",
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
				setMiddleNameRnd(sex), rndInteger(a1, a2), sex);
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
		return new Student(rndHuman(a1, a2, sex), setHighScoolRnd(),
				rndInteger(g1, g2));
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
		return new Student(hm, setHighScoolRnd(), rndInteger(g1, g2));
	}
}
