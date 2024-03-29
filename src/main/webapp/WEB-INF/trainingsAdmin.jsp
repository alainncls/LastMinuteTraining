<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="google-site-verification" content="42P-VGwCiT29W4i-TUK4NWnbQq2zlra4DsDA28iBVoI" />

<div class="row">
	<div class="col-sm-12">
		<h3>Gérez ici les formations publiées en ligne</h3>
	</div>
</div>
<div class="row">
	<div class="col-sm-8">
		<div class="panel panel-primary">
			<div class="panel-heading">Les prochaines formations</div>
			<div class="table-responsive">
				<table class="table table-hover table-align">
					<thead>
						<tr>
							<th>Prix</th>
							<th>Prix LMT</th>
							<th>Date début</th>
							<th>Durée</th>
							<th>Difficulté</th>
							<th>Places restantes</th>
							<th></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty trainings}">
							<c:forEach items="${trainings}" var="training" varStatus="loop">
								<tr class="tr-dark">
									<%-- <td colspan="8" class="trainingName"><a
										href="404?id=${training.id}">${training.name}</a></td> --%>
									<td colspan="8" class="trainingName"><a
										href="/trainings/${training.id}" target="_blank">${training.name}</a></td>
									<td class="td-chevron"><i
										class="fa fa-chevron-down chevron-toggle pull-right"
										data-toggle="collapse" href="#col${loop.index}"></i></td>
								</tr>
								<tr id="col${loop.index}"
									class="panel-collapse collapse tr-light">
									<td colspan="9">${training.description}</td>
								</tr>
								<tr class="tr-light">
									<td>${training.price}€</td>
									<td>${training.priceLMT}€</td>
									<td>${training.date.startDate}</td>
									<td>${training.duration.count} <c:if test="${training.duration.unit == 'days'}">jours</c:if><c:if test="${training.duration.unit == 'day'}">jour</c:if><c:if test="${training.duration.unit != 'day' && training.duration.unit != 'days'}">${training.duration.unit}</c:if></td>
									<td><c:forEach begin="1" end="${training.level}">
											<i class="fa fa-star"></i>
										</c:forEach></td>
									<td>${training.available}</td>
									<td colspan="3">
                                        <a href="/admin/editTraining/${training.id}" class="btn btn-success btn-xs"><span class="fa fa-pencil" aria-hidden="true"></span></a>
                                        <a href="/admin/deleteTraining/${training.id}" class="btn btn-danger btn-xs"><span class="fa fa-trash-o" aria-hidden="true"></span></a>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<script>
		$(".chevron-toggle").click(function() {
			$(this).toggleClass("fa-chevron-down");
			$(this).toggleClass("fa-chevron-up");
		});
	</script>

	<div class="col-sm-4">
		<jsp:include page="/include/searchTraining.jsp" />
	</div>
</div>
<jsp:include page="/include/footer.jsp" />