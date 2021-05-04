package TodoApp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TodosController")
public class TodosController extends HttpServlet {
	
	Todos todo = new Todos();
	
	/**
	 *Method to handle get form action
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		if(request.getParameter("addTodo") != null) {
			String todoName = request.getParameter("todoname");
			todo.addTodo(todoName);
			RequestDispatcher rd = request.getRequestDispatcher("create-todo.jsp");

			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
	
		}
		if(request.getParameter("deleteTodo") != null) {
			
		}
	}
	
	/**
	 *Method to handle post form action
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("deleteTodo") != null) {
			int id = Integer.parseInt(request.getParameter("todoId"));
			todo.deleteItem(id);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		if(request.getParameter("displayTodos") != null) {
			ArrayList<TodoItem> todoItems = todo.getTodoList();
			request.setAttribute("todoList", todoItems);
			RequestDispatcher rd = request.getRequestDispatcher("todo-list.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
