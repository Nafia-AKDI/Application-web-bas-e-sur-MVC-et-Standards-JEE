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
		<caption>
            	<h2>
            		<c:if test="${ligneCmd != null}">
            			Edit ligneCmd
            		</c:if>
            		<c:if test="${ligneCmd == null}">
            			Add New ligneCmd
            		</c:if>
            	</h2>
            </caption>
        <h2>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">Ligne de Commande</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${ligneCmd != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${ligneCmd == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            
        		<c:if test="${ligneCmd != null}">
        			<input type="hidden" name="numLigne" value="<c:out value='${ligneCmd.getNumLigne()}' />" />
        		</c:if>            
            <tr>
                <th>qte cmd: </th>
                <td>
                	<input type="text" name="qteCmd" size="45"
                			value="<c:out value='${ligneCmd.getQteCmd()}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Article: </th>
                <td>
                	<select name="codArt" value='${ligneCmd.getCodArt()}' >
                 <c:forEach var="article" items="${ listArticle }">
    			<option  >${article.getCodArt()}</option>
                </c:forEach>
    
  			</select>
                </td>
            </tr>
            <tr>
                <th>Commande: </th>
                <td>
                	<select name="numCmd" value='${ligneCmd.getNumCmd()}' >
                 <c:forEach var="commande" items="${ listCommande }">
    			<option  >${commande.getNumCmd()}</option>
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