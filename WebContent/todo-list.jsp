<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>CEN4025 Todo List</title>
<%@ include file="header.jsp" %>
		<c:forEach var="todos" items="${todoList}">
		<div>
            <h3>${todos.todoName} </h3>
       		<form action="TodosController" method="POST">
       		<input type="hidden" id="todoId" name="todoId" value="${todos.id}">
            <input class="submit-button" type="submit" name="deleteTodo" value="Delete">    
        </form>
            </div>
        </c:forEach>
</div>
</div>
</body>
</html>