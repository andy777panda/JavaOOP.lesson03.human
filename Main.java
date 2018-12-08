package net.ukr.andy777;

/*
 1. Создать класс Человек/Human, описывающий человека (Ф.,И.,О., возраст, пол)
 Создать метод, выводящий информацию о человеке.
 2. На основе класса Человек/Human создать класс Студент/Student. И переопределить метод вывода информации.
 3. Создать класс Группа/Group, который содержит массив из 10 объектов класса Студент/Student.
 Реализовать методы добавления, удаления студента из группы и поиска по фамилии.
 В случае попытки добавления 11го студента создать собственное исключение и обработать его.
 Определить метод toString() для группы так, чтобы он выводил список студентов в алфавитном порядке.
 4. Нарисовать UML диаграмму проекта. 
 */

public class Main {

	public static void main(String[] args) {

		int q = AP.inputIntegerDialog(0, 12,"amount of students for fist initializing");
		Group gr1 = new Group("Group1", "123/45");

		
		// initializing array of students = ініціалізація переліку студентів
		for (int i = 0; i < q; i++)
			gr1.tcAddStudentToGroup(Student.rndStudent(17, 23, AP.rndBoolean(),
					1, 6));
		System.out.println();
		System.out.println(gr1 + "\n");

		
		// remove students from group = виключення студентів з групи
		for (int i = 0; i < 3; i++) {
			// особа на випадковій позиції у списку
			gr1.tcRemoveStudentFromGroup(gr1.getGroup()[AP.rndInteger(0, 9)]);
			// випадкова особа
			gr1.tcRemoveStudentFromGroup(Student.rndStudent(17, 23, AP
					.rndBoolean(), 1, 6));
		}
		System.out.println();
		System.out.println(gr1 + "\n");

		
		// Add students to group = додавання студентів до групи
		for (int i = 0; i < 4; i++)
			gr1.tcAddStudentToGroup(Student.rndStudent(17, 23, AP.rndBoolean(),
					1, 6));
		System.out.println();
		System.out.println(gr1 + "\n");

		
		// Finding a student by second name = метод пошуку студента за прізвищем
		for (int i = 0; i < 10; i++) {
			gr1.findSecondName(Human.setSecondNameRnd(AP.rndBoolean()));
		}
		System.out.println();

		//AZ-sort = сортування переліку зростанням
		System.out.println(gr1.getSortGroup(1)+ "\n");
		//ZA-sort = сортування переліку спаданням
		System.out.println(gr1.getSortGroup(-1)+ "\n");
		//unsorted = не сортований перелік
		System.out.println(gr1.getSortGroup(0)+ "\n");
		//original = оригінальна база
		System.out.println(gr1 + "\n");

	}
}
