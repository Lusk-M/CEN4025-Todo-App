package TodoApp;

public class TodoItem {
	private String todoName;
	private int id;
	
	public TodoItem() {}
	
	public TodoItem(String name) {
		this.todoName = name;
	}
	
	public TodoItem(String name, int id) {
		this.todoName = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}
	
	

}
