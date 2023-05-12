<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-striped">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Image</th>
      <th scope="col">Title</th>
      <th scope="col">Duration</th>
      <th scope="col">Album</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${liste}" var="c">
      <tr>
        <td>${c.id}</td>
        <td><img src="<c:url value='images/${c.filename}'/>" width="100" height="100" alt="Album cover of ${c.title}" /></td>
        <td>${c.title}</td>
        <td>${c.duree}</td>
        <td>${c.album.nom}</td>
        <td>
          <a href="FirstServlet?action=supprimer&id=${c.id}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this song?')">
            <i class="fas fa-trash"></i>
          </a>
          <a href="FirstServlet?action=modifier&id=${c.id}" class="btn btn-warning">
            <i class="fas fa-edit"></i>
          </a>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
