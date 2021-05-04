<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>CEN4025 Create Todo</title>
<%@ include file="header.jsp" %>
<form action="TodosController" method="GET">
            <table>
                <tr>
                    <td> Todo Name: </td>
                    <td><input type="text" name="todoname"></td>
                </tr>
                <tr>
                    <td><input class="submit-button" type="submit" name="addTodo" value="Add"></td>
                    
                </tr>
            </table>
        </form>
        </div>
        </div>
</body>
</html>