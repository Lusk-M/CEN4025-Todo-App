package TodoApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Todos {
	private ArrayList<TodoItem> todoList;
	private SessionFactory sf;
	
	/**
	 * Default constructor
	 */
	public Todos() {
		this.todoList = new ArrayList<TodoItem>();
		//Configure the connection and load the list of data
		sf = new Configuration().configure().buildSessionFactory();
		loadList();
	}

	
	/**
	 * A method to create a new TodoItem
	 * @param name the name of the new TodoItem
	 */
	public void addTodo(String name) {
		TodoItem todoItem = new TodoItem(name);
		//If the todo item was successfully added
		if(saveItem(todoItem)) {
		//System.out.println("'" +name + "' added to to-do list");
		}
		else {
			//System.out.println("There was an issue adding the to-do item");
		}
	}
	
	/**
	 * This method deletes the specified todo from the todo list
	 * @param id of the TodoItem to be deleted
	 */
	public void deleteTodo(int id) {
		//If the todo was successfully deleted
		if(deleteItem(id)) {
			//System.out.println("Todo has been deleted");
		}
		else {
			//System.out.println("There was an issue deleting the item");
		}
	}
	
	/**
	 * A method to get all of the todo items in an ArrayList
	 * @return the list of todo items
	 */
	public ArrayList<TodoItem> getTodoList() {
		return todoList;
	}
	
	/**
	 * Method to save TodoItem in the database
	 * @param item the item to be deleted
	 * @return if the operation was successful
	 */
	public boolean saveItem(TodoItem item) {
		Session session = sf.openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			int dataId = (int) session.save(item);
			t.commit();
			loadList();
		}catch(Exception e) {
			if(t != null) {
				t.rollback();
			}
			//e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}
	
	/**
	 * Method to delete TodoItem from the database
	 * @param id the id of the item to be deleted
	 * @return if the deletion was successful
	 */
	public boolean deleteItem(int id) {
		Session session = sf.openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			TodoItem item = session.get(TodoItem.class,  id);
			session.delete(item);
			t.commit();
			loadList();
		}catch(Exception e) {
			if(t != null) {
				t.rollback();
			}
			//e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}
	
	/**
	 * Method to load all of the TodoItem from the database
	 * @return if the selection was successful
	 */
	public boolean loadList() {
		Session session = sf.openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			List todos = session.createQuery("FROM TodoItem").list();
			todoList.clear();
			todoList.addAll(todos);
			t.commit();
		}catch(Exception e) {
			if(t != null) {
				t.rollback();
			}
			//e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		return true;
	}

}
