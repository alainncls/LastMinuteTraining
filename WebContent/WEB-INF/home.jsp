<jsp:include page="/include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="table-responsive">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nom</th>
				<th>Prix</th>
				<th>Prix via SM</th>
				<th>Date</th>
				<th>Difficulté</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${formations}" var="formation">
			<tr>
				<td><a href="addformation?id=${formation.id}">${formation.name}</a></td>
				<td>${formation.prix}</td>
				<td>${formation.prixReduc}</td>
				<td>${formation.date_debut}</td>
				<td>${formation.niveau}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>

<jsp:include page="/include/footer.jsp" />