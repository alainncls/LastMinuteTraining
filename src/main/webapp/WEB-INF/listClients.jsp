<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-primary">
			<div class="table-responsive">
				<table class="table table-hover table-striped table-align">
					<thead>
						<tr>
							<th>#</th>
							<th>ID</th>
							<th>Prénom</th>
							<th>Nom</th>
							<th>Adresse</th>
							<th>Ville</th>
							<th>Code postal</th>
							<th>Mail</th>
							<th>Tél.</th>
							<th>Identifiant</th>

						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty clients}">
							<c:forEach items="${clients}" var="client" varStatus="loop">
								<tr>
									<td>${loop.index+1}</td>
									<td>${client.id}</td>
									<td>${client.firstName}</td>
									<td>${client.lastName}</td>
									<td>${client.address}</td>
									<td>${client.town}</td>
									<td>${client.cp}</td>
									<td>${client.mail}</td>
									<td>${client.phone}</td>
									<td>${client.login}</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/include/footer.jsp" />