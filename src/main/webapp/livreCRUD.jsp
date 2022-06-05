<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Gestion des livres</title>
</head>
<body>
  
<h1>Gestion des livres</h1>
	<div>
		<h2>Liste des livres</h2>
		<table border="1" >
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Domaine</th>
				<th>Url</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="Livre" items="${listL}">
				<tr>
					<td>${Livre.id}</td>
					<td>${Livre.nom}</td>
					<td>${Livre.domaine} </td>
					<td>${Livre.url} </td>
					<td> <a href="Lupdate?id=${Livre.id}"> Modifier</a> </td>
					<td> <a href="Ldelete?id=${Livre.id}">Supprimer</a> </td>
					
				 
				</tr>
			</c:forEach>
		</table>
	</div>
	
	
	 
	  
	<c:if test="${Livre == null}">
	  <div>
	 <h3>Ajouter un livre</h3>
   
          
      <form method="POST" action="${pageContext.request.contextPath}/Lnew">
       
         <table >
            
            <tr>
               <td>Nom &nbsp</td>
               <td><input type="text" name="nom" value="${Livre.nom}" /></td>
            </tr>
            <tr>
               <td>Domaine &nbsp</td>
               <td><input type="text" name="domaine" value="${Livre.domaine}" /></td>
            </tr>
             <tr>
               <td>Url &nbsp</td>
               <td><input type="text" name="url" value="${Livre.url}" /></td>
            </tr>
             </table>
               <br> <br>              
             <input type="submit" value="Ajouter" />
                   
               
        
      </form>
	
	  </div>
	  </c:if>
	  
	<c:if test="${Livre != null}">
	  <div>
	 <h3>Modifier un livre</h3>
   
          
      <form method="POST" action="${pageContext.request.contextPath}/Lupdate">
          <input type="hidden" name="id" value="<c:out value='${Livre.id}' />" />
         <table >
            
            <tr>
               <td>Nom &nbsp</td>
               <td><input type="text" name="nom" value="${Livre.nom}" /></td>
            </tr>
            <tr>
               <td>Domaine &nbsp</td>
               <td><input type="text" name="domaine" value="${Livre.domaine}" /></td>
            </tr>
            <tr>
               <td>Url &nbsp</td>
               <td><input type="text" name="url" value="${Livre.url}" /></td>
            </tr>
            
             </table>
               <br> <br>              
             <input type="submit" value="Modifier" />
                   
               
        
      </form>
	
	  	</div>
	  </c:if>
	         
             
       
	</body>
</html>