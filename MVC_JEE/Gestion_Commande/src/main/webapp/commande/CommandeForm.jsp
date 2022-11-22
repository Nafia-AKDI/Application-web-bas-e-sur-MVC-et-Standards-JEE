<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clients</title>
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
        <a class="nav-link" href="http://localhost:8081/Gestion_Commande/produit/">Produit</a>
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
	<c:if test="${commande != null}">
            			<h1>Moudifier une Commande</h1>
            		</c:if>
            		<c:if test="${commande == null}">
            			<h1>Ajouter une Commande</h1>
            		</c:if>
        <h2>
        &nbsp;&nbsp;&nbsp;
        	<a href="list">Liste des une Commandes</a>
        </center>
        
        	
    <div align="center">
		<c:if test="${commande != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${commande == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	
            </caption>
        		<c:if test="${commande != null}">
        			<input type="hidden" name="numCmd" value="<c:out value='${commande.getNumCmd()}' />" />
        		</c:if>            
            <tr>
                <th>Date: </th>
                <td>
                	<input type="date" name="dateCmd" size="45"
                			value="<c:out value='${commande.getDateCmd()}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Client: </th>
                <td>
                	<select name="codCli" value='${commande.getCodCli()}' >
                 <c:forEach var="client" items="${ listClient }">
    			<option  >${client.getCodCli()}</option>
                </c:forEach>
    
  			</select>
                </td>
            </tr>
            
           
            
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
    
    
    
</body>
</html>