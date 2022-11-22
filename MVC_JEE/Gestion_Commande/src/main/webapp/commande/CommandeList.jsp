<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<title>Clients</title>
	<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Gestion des Commande</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8081/Gestion_Commande/client/">Client </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8081/Gestion_Commande/produit/">article</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8081/Gestion_Commande/commande/">Commande</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8081/Gestion_Commande/ligneCmd/">Ligne de Commande</a>
      </li>
    </ul>
  </div>
</nav>
	<center>
		<h1>Liste des Commandes</h1>
        
	</center>
    <div align="center">
        	<a href="new">Ajouter une Commande</a>
        	&nbsp;&nbsp;&nbsp;
        	
        	
        </h2>
        <table border="1" cellpadding="5">

            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Client</th>
                
                <th>Actions</th>
            </tr>
               <c:forEach var="commande" items="${ listCommande }">
                <tr>
                    <td><c:out value="${commande.getNumCmd()}" /></td>
                    <td><c:out value="${commande.getDateCmd()}" /></td>
                    <td><c:out value="${commande.getCodCli()}" /></td>
              

                    <td>
                    	<a href="edit?id=<c:out value='${commande.getNumCmd()}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${commande.getNumCmd()}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
 



</body>
</html>
