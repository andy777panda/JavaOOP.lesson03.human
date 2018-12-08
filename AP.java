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
								+ " - " + b+ "\n" + msg));
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

	public static String[] swapArrElem(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[i + 1];
		arr[i + 1] = temp;
		return arr;
	}

	public static String[] sortArray(String[] sts, int az) {
		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < sts.length - 1; i++) {
				if (sts[i].compareToIgnoreCase(sts[i + 1]) * az > 0) {
					isSorted = false;
					sts = AP.swapArrElem(sts, i, i + 1);
				}
			}
		}
		return sts;
	}
}
