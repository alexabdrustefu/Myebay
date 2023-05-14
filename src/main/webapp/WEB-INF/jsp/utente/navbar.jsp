<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header>
  <!-- Fixed navbar -->
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark border border-warning" aria-label="Eighth navbar example">
    <div class="container">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
       <h2 style="text-align: left;"><span style="font-size:20px"><span style="font-family:Times New Roman,Times,serif"><big><span data-darkreader-inline-color="" style="--darkreader-inline-color:#ff8664; color:#e74c3c">E</span><span data-darkreader-inline-color="" style="--darkreader-inline-color:#8dffff; color:#5effff">b</span><span data-darkreader-inline-color="" style="--darkreader-inline-color:#ffff18; color:#f1c40f">a</span><span data-darkreader-inline-color="" style="--darkreader-inline-color:#60ffe7; color:#2ecc71">y</span></big></span></span></h2>
      

      <div class="collapse navbar-collapse" id="navbarsExample07">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/home">Home</a>
          
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false">Menu</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown07">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/home">Home</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/annuncio/search">Ricerca Annunci</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/annuncio/insert">Inserisci Annuncio</a></li>
            </ul> 
          </li>
           <sec:authorize access="hasRole('ADMIN')">
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestione Utenze</a>
		        <div class="dropdown-menu" aria-labelledby="dropdown01">
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/utente/search">Ricerca Utenti</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/utente/insert">Inserisci Utente</a>
		        </div>
		      </li>
		   </sec:authorize>
        </ul>
      </div>
      <sec:authorize access="isAuthenticated()">
      
    
		    <div class="col-md text-end">   
	         <p class="navbar-text">Utente: ${userInfo.username } (${userInfo.nome } ${userInfo.cognome }) 
    	 <a href="${pageContext.request.contextPath}/executeLogout">Logout</a></p>
    	 </div>
	    	
	      
    </sec:authorize>
    </div>
  </nav>
  
  
</header>