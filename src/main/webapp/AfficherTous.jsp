<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Afficher tous les livres</title>
</head>
<body>
  
<h1>La liste des livres :</h1>
	<div>
		<table border="1" >
			<tr>
				<th>Nom</th>
				<th>Domaine</th>
				<th>Url</th>
			</tr>
			<c:forEach var="Livre" items="${listl}">
				<tr>
					<td>${Livre.nom}</td>
					<td>${Livre.domaine}</td>
					<td><a href="${Livre.url}">${Livre.url}</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>
</html>