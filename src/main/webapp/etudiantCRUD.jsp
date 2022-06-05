<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Gestion des étudiants</title>
</head>
<body>
  
<h1>Gestion des étudiants</h1>
	<div>
		<h2>Liste des étudiants</h2>
		<table border="1" >
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Login</th>
				<th>Password</th>
				<th>Nb_LivreMensuel_Autorise</th>
				<th>Nb_Livre_Emprunte</th>
				<th>Type_Package</th>
				<th>Password Livre</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="Etudiant" items="${listE}">
				<tr>
					<td>${Etudiant.id}</td>
					<td>${Etudiant.nom}</td>
					<td>${Etudiant.prenom} </td>
					<td>${Etudiant.login}</td>
					<td>${Etudiant.pwd}</td>
					<td>${Etudiant.nbLivreMensuel_Autorise} </td>
					<td>${Etudiant.nbLivreEmprunte}</td>
					<td>${Etudiant.pack} </td>
					<td>${Etudiant.pwdLivre} </td>
					<td> <a href="update?id=${Etudiant.id}"> Modifier</a> </td>
					<td> <a href="delete?id=${Etudiant.id}">Supprimer</a> </td>
					
				 
				</tr>
			</c:forEach>
		</table>
	</div>
	
	
	 
	  
	<c:if test="${Etudiant == null}">
	  <div>
	 <h3>Ajouter un étudiant</h3>
   
          
      <form method="POST" action="${pageContext.request.contextPath}/new">
       
         <table >
            
            <tr>
               <td>Nom &nbsp</td>
               <td><input type="text" name="nom" value="${Etudiant.nom}" /></td>
            </tr>
            <tr>
               <td>Prenom &nbsp</td>
               <td><input type="text" name="prenom" value="${Etudiant.prenom}" /></td>
            </tr>
            
            <tr>
               <td>Login &nbsp </td>
               <td><input type="text" name="login" value="${Etudiant.login}" /></td>
            </tr>
            <tr>
               <td>Password &nbsp</td>
               <td><input type="password" name="pwd" value="${Etilisateur.pwd}" /></td>
            </tr>
            
            <tr>
               <td>Nb_LivreMensuel_Autorise &nbsp </td>
               <td><input type="text" name="nbLivreMensuel_Autorise" value="${Etudiant.login}" /></td>
            </tr>
            <tr>
               <td>Nb_Livre_Emprunte &nbsp</td>
               <td><input type="text" name="nbLivreEmprunte" value="${Etudiant.nbLivreEmprunte}" /></td>
            </tr>
            
             <tr>
               <td>Type_Package &nbsp</td>
               <td><input type="text" name="pack" value="${Etudiant.pack}" /></td>
            </tr>
            
            <tr>
               <td>Password Livre &nbsp</td>
               <td><input type="text" name="pwdLivre" value="${Etudiant.pwdLivre}" /></td>
            </tr>
          
             </table>
               <br> <br>              
             <input type="submit" value="Ajouter" />
                   
               
        
      </form>
	
	  </div>
	  </c:if>
	  
	<c:if test="${Etudiant != null}">
	  <div>
	 <h3>Modifier un étudiant</h3>
   
          
      <form method="POST" action="${pageContext.request.contextPath}/update">
          <input type="hidden" name="id" value="<c:out value='${Etudiant.id}' />" />
         <table >
            
            <tr>
               <td>Nom &nbsp</td>
               <td><input type="text" name="nom" value="${Etudiant.nom}" /></td>
            </tr>
            <tr>
               <td>Prenom &nbsp</td>
               <td><input type="text" name="prenom" value="${Etudiant.prenom}" /></td>
            </tr>
            
            <tr>
               <td>Login &nbsp </td>
               <td><input type="text" name="login" value="${Etudiant.login}" /></td>
            </tr>
            <tr>
               <td>Password &nbsp</td>
               <td><input type="password" name="pwd" value="${Etudiant.pwd}" /></td>
            </tr>
            
            <tr>
               <td>Nb_LivreMensuel_Autorise &nbsp </td>
               <td><input type="text" name="nbLivreMensuel_Autorise" value="${Etudiant.nbLivreMensuel_Autorise}" /></td>
            </tr>
            <tr>
               <td>Nb_Livre_Emprunte &nbsp</td>
               <td><input type="text" name="nbLivreEmprunte" value="${Etudiant.nbLivreEmprunte}" /></td>
            </tr>
            
             <tr>
               <td>Type_Package &nbsp</td>
               <td><input type="text" name="pack" value="${Etudiant.pack}" /></td>
            </tr>
            
            <tr>
               <td>Password Livre &nbsp</td>
               <td><input type="text" name="pwdLivre" value="${Etudiant.pwdLivre}" /></td>
            </tr>
          
             </table>
               <br> <br>              
             <input type="submit" value="Modifier" />
                   
               
        
      </form>
	
	  	</div>
	  </c:if>
	         
             
       
	</body>
</html>