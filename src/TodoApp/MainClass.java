package TodoApp;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	//Create variable for program status and for user input
	private static boolean programRunning = true;
	static Scanner userInput;
	
	public static void main(String[] args) {
		//Create new todo object and set the user input up
		Todos todo = new Todos();
		userInput = new Scanner(System.in);

		//Print the program menu
		printMenu();
		
		//While the program status is still set to run
		while(programRunning) {
			//Prompt the user to enter a command
			System.out.println("\nEnter a command:");
			//Get the user input, to lower case to ensure there are no case issues, and pass it to the method to handle it
			String userAction = userInput.next().toLowerCase();
			handleUserSelection(userAction, todo);
		}
		
		//Close the input scanner and tell the user the program has finished running
		userInput.close();
		System.out.println("Program has exited");
	}
	
	/**
	 * Method to control the program based on the user input
	 * @param command the command entered by the user
	 * @param userTodos the todos item to be actioned on by the method
	 */
	public static void handleUserSelection(String command, Todos userTodos) {
		//Check what the user entered and take the appropriate action
		switch(command) {
		case "add":
		case "create":
			System.out.print("Enter to-do name: ");
			String name = userInput.next();
			userTodos.addTodo(name);
			break;
		case "delete":
			printTodoList(userTodos);
			System.out.println("Please enter the number of the to-do you would like to delete:");
			try {
				int id = userInput.nextInt();
				userTodos.deleteTodo(id);
			}catch(Exception e) {
				System.out.println("There was an issue deleting the to-do. Please make sure the number entered matches one of the to-do items");
			}
			break;
		case "view":
		case "list":
			printTodoList(userTodos);
			break;
		case "menu":
		case "help":
			printMenu();
			break;
		case "exit":
			programRunning = false;
			break;
		default:
			printMenu();
		}
		
	}
	
	/**
	 * Method to print out a list of todo items
	 * @param userTodos the object containing the list of todos
	 */
	public static void printTodoList(Todos userTodos) {
		ArrayList<TodoItem> todoItems = userTodos.getTodoList();
		//For all TodoItem in ArrayList print their index and name
		for(int i = 0; i < todoItems.size(); i++) {
			System.out.println(todoItems.get(i).getId() + " " + todoItems.get(i).getTodoName());
		}
	}
	
	/**
	 * Method to print the menu with commands the user can input into the program
	 */
	public static void printMenu() {
		System.out.println("\nYou can use the following commands to add, delete, and view to-do items:"
				+ "\n'Add' or 'Create' to add a new to-do"
				+ "\n'Delete' to delete an existing to-do"
				+ "\n'View' or 'List' to list all to-do items"
				+ "\nUse 'Menu' to view the controls again and use 'Exit' to stop the program");
	}

}
