<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Filtre de recherche</h3>
			</div>
			<div class="panel-body">
				<input type="text" id="search"
					placeholder="Renseignez vos termes de recherche">
			</div>
		</div>
		<c:if test="${(sessionScope.validated=='true')&&(sessionScope.status=='vendor')}">
			<a class="btn btn-primary fa fa-plus" style="margin-bottom: 10px"
			href="/mytrainings/add"> Ajouter une formation</a>
		</c:if>
		<c:if test="${(sessionScope.validated!='true')&&(sessionScope.status=='vendor')}">
			<a class="btn btn-danger fa fa-exclamation-circle" style="margin-bottom: 10px"
			href="/myaccount"><b> Votre compte n'est pas activé, cliquez pour compléter vos informations</b></a>
		</c:if>
		
		<div class="panel panel-primary">
			<div class="panel-heading">Les prochaines formations</div>
			<div class="table-responsive">
				<table class="table table-hover table-align" id="table">
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

					<c:if test="${not empty trainings}">
						<c:forEach items="${trainings}" var="training" varStatus="loop">
							<tbody>
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
								<tr class="tr-light centered">
									<td>${training.price}€</td>
									<td>${training.priceLMT}€</td>
									<td>${training.date.startDate}</td>
									<td>${training.duration.count} ${training.duration.unit}
									<td>
										<c:forEach begin="1" end="${training.difficulty}">
											<i class="fa fa-star"></i>
										</c:forEach>
									</td>
									<td>${training.available}</td>
									<td colspan="3"><a href="/mytrainings/edit/${training.id}"
										class="btn btn-warning btn-sm pull-right"><i
											class="fa fa-edit"></i>Modifer</a></td>
								</tr>
							</tbody>

						</c:forEach>
					</c:if>
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
	<script>
		var $rows = $('#table tbody');
		$('#search').keyup(function() {
			var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();

			$rows.show().filter(function() {
				var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
				return !~text.indexOf(val);
			}).hide();
		});
	</script>
</div>
<jsp:include page="/include/footer.jsp" />