<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>CEN4025 Home Page</title>
<%@ include file="header.jsp" %>
  <span><a href="create-todo.jsp"><span class="section-nav">Add Todo</a></span>
  </span>
  <span>
		<form action="TodosController" method="POST">
            <input class="submit-button section-nav" type="submit" name="displayTodos" value="View Todos">     
        </form>
        </span>
</div>
</div>
</body>
</html>