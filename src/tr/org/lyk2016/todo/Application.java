package tr.org.lyk2016.todo;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		String input = "";
		Scanner scanner = new Scanner(System.in);

		while (true) {
			Menu.printMenu();
			input = scanner.nextLine();

			processInput(input);
		}

	}

	private static void processInput(String input) {

		String[] inputParams = input.split(",");

		int action = Integer.parseInt(inputParams[0]);
		String param = null;
		if (inputParams.length > 1) { // 0 verdiğimizde exception almadan
			param = inputParams[1];
			// çıkabilmek için ikinci kısmı direk
			// null okusun diye böyle bir koşul
			// verdik.
		}

		System.out.println("[debug] action: " + action);
		System.out.println("[debug] param: " + param);

		int index;
		switch (action) {
		case 0:
			System.out.println("Exiting...");
			System.exit(0);
		case 1:
			Todo newTodo = new Todo(param);
			TodoHelper.add(newTodo);
			break;
		case 2:
			index = Integer.parseInt(param);
			TodoHelper.mark(index - 1, true);
			break;
		case 3:
			index = Integer.parseInt(param);
			TodoHelper.remove(index - 1);
			break;
		case 4:
			index = Integer.parseInt(param);
			TodoHelper.mark(index - 1, false);
			break;

		default:
			break;
		}

	}
}
