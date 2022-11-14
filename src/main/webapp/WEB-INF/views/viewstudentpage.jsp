<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Students List</h1>
<table border="2" width="70%" cellpadding="2">
   <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Grade</th>
      <th>Edit</th>
      <th>Delete</th>
   </tr>
   <c:forEach var="student" items="${studentlist}">
      <tr>
         <td>${student.id}</td>
         <td>${student.name}</td>
         <td>${student.grade}</td>
         <td><a href="editstudent/${student.id}">Edit</a></td>
         <td><a href="deletestudent/${student.id}">Delete</a></td>
      </tr>
   </c:forEach>
</table>
<br/>
<a href="addstudent">Add New Student</a>