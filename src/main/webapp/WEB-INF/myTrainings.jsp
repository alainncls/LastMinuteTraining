<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<input type="text" id="search" placeholder="Type to search">
					<a lass="btn btn-p	rimary" href="${page.url}/LastMinuteTraining/mytrainings/add">Ajouter une formation</a></li>
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
										href="/LastMinuteTraining/trainings/${training.id}"
										target="_blank">${training.name}</a></td>
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
									<td>${training.duration.count}<c:if
											test="${training.duration.unit == 'days'}">jours</c:if> <c:if
											test="${training.duration.unit == 'day'}">jour</c:if> <c:if
											test="${training.duration.unit != 'day' && training.duration.unit != 'days'}">${training.duration.unit}</c:if></td>
									<td><c:forEach begin="1" end="${training.level}">
											<i class="fa fa-star"></i>
										</c:forEach></td>
									<td>${training.available}</td>
									<td colspan="3"><a href="mytrainings/edit/${training.id}"
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