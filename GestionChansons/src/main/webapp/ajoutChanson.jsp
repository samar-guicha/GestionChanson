<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.entities.Chanson"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
	integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
body {
	background-color: #f8f9fa;
}

.card {
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}
</style>
</head>
<body>
	<%@ include file="NavBar.html"%>

	<br>
	<div class="container-fluid">
		<div class="card mx-5">
			<div class="card-header">
				<h5>Ajouter Chanson</h5>
			</div>
			<div class="card-body">
				<form method="post" action="FirstServlet"
					enctype="multipart/form-data">
					<div class="mb-3">
						<label for="title" class="form-label">Title</label> <input
							type="text" class="form-control" id="title" name="title"
							value="${chanson.title}">
					</div>
					<div class="mb-3">
						<label for="duree" class="form-label">Duree</label> <input
							type="number" class="form-control" id="duree" name="duree"
							step="0.01" value="${chanson.duree}">
					</div>
					<div class="mb-3">
						<label for="album" class="form-label">Album</label> 
						<select name="album" class="form-control">
							<option selected hidden>Choose here</option>
							<c:forEach items="${album}" var="cc">
								<option value="${cc.id}"
									<c:if test="${chanson.album.id==cc.id }">selected="true"</c:if>>${cc.nom}</option>
							</c:forEach>
						</select>
					</div>
					<div class="mb-3">
						<label for="image" class="form-label">Image</label> <input
							type="file" name="image" id="filename" />
					</div>
					<button type="submit" name="action" value="ajouterform"
						class="btn btn-primary">
						<span class="fa fa-save"></span>
						<c:if test="${chanson.id==null}">

Ajouter

</c:if>

						<c:if test="${chanson.id!=null}">

Modifier

</c:if>
					</button>

					<input type="hidden" name="id" value="${chanson.id}" />
				</form>
				<br>
			</div>
		</div>
	</div>
</body>
</html>
