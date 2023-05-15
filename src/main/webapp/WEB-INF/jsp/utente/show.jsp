<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="it" class="h-100">
<head>

<!-- Common imports in pages -->
<jsp:include page="../header.jsp" />

<title>Visualizza Elemento</title>

</head>
<body class="d-flex flex-column h-100">

	 <sec:authorize access="isAuthenticated()" var="isAutenticato"></sec:authorize>
<c:choose>
   <c:when test="${isAutenticato}"><jsp:include page="../navbar.jsp"></jsp:include></c:when>
   <c:otherwise><jsp:include page="./navbar.jsp"></jsp:include>
	</c:otherwise>
</c:choose>

	<!-- Begin page content -->
	<main class="flex-shrink-0">
		<div class="container">

			<div class='card border border-success'>
				<div class='card-header border border-success'>
					<h5>Visualizza dettaglio</h5>
				</div>


				<div class='card-body'>

					<dl class="row">
						<dt class="col-sm-3 text-right">Username:</dt>
						<dd class="col-sm-9">${show_utente_attr.username}</dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Nome:</dt>
						<dd class="col-sm-9">${show_utente_attr.nome}</dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Cognome:</dt>
						<dd class="col-sm-9">${show_utente_attr.cognome}</dd>
					</dl>
					<dl class="row">
						<dt class="col-sm-3 text-right">Data Creazione:</dt>
						<dd class="col-sm-9">
							<fmt:parseDate value="${show_utente_attr.dateCreated}"
								pattern="yyyy-MM-dd" var="localDateToBeParsed" type="date" />
							<fmt:formatDate pattern="dd/MM/yyyy"
								value="${localDateToBeParsed}" />
						</dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Tipologia Utente:</dt>

						<dd class="col-sm-9">
							<ul>
								<c:forEach items="${ruoli_totali_attr}" var="ruoliItem">
									<li>${ruoliItem.descrizione}</li>
								</c:forEach>
							</ul>
						</dd>

					</dl>

				</div>

				<div class='card-footer'>
					<a
						href="${pageContext.request.contextPath}/utente"
						class='btn btn-outline-secondary' style='width: 80px'> <i
						class='fa fa-chevron-left'></i> Back
					</a>
					
					
				</div>
				<!-- end card -->
			</div>


			<!-- end container -->
		</div>

	</main>

	<!-- Footer -->
	<jsp:include page="../footer.jsp" />
</body>
</html>