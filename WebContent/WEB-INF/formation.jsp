<jsp:include page="/include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="filter">
	<form role="form">
		<div class="form-group">
			<label for="inputPrerequis">Prerequisites</label>
			<select multiple id="inputPrerequis" name="inputPrerequis" class="form-control">
				<c:forEach items="${prerequis}" var="prerequis">
					<option value="${prerequis.id}" selected="${prerequis.selected}">${prerequis.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="inputDate">Date</label>
			<input type="date" id="inputDate" name="inputDate"/>
		</div>
	</form>
</div>
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