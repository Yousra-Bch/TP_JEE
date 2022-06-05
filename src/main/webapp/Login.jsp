<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
  

	  <div>
	 <h2>Login</h2>
   
          
      <form method="POST" action="${pageContext.request.contextPath}/login">
       
         <table >
            
            <tr>
               <td>Nom d'utilisateur &nbsp</td>
               <td><input type="text" name="login" value="" /></td>
            </tr>
            <tr>
               <td>Mot de passe &nbsp</td>
               <td><input type="password" name="pwd" value="" /></td>
            </tr>
        
          
             </table>
               <br> <br>              
             <input type="submit" value="Connexion" />        
        
      </form>
	
	  </div>
	</body>
</html>