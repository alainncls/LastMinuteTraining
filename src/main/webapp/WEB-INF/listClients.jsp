<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-primary">
			<div class="table-responsive">
				<table class="table table-hover table-striped table-align">
					<thead>
						<tr>
							<th>num</th>
							<th>id</th>
							<th>firstName</th>
							<th>lastName</th>
							<th>address</th>
							<th>town</th>
							<th>cp</th>
							<th>mail</th>
							<th>phone</th>
							<th>login</th>
							<th>password</th>
							<th>bank</th>
							<th>cardNumber</th>
							<th>expirationDate</th>
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
									<td>${client.password}</td>
									<td>${client.bank}</td>
									<td>${client.cardNumber}</td>
									<td>${client.expirationDate}</td>
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