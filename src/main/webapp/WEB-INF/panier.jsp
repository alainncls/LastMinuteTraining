<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-12">
		<h3>Mon panier</h3>
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
							<th>Formation</th>
							<th>Quantité</th>
							<th>Prix</th>
							<th>Supprimer</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${not empty sessionScope.cart.orders}">
							<c:forEach items="${sessionScope.cart.orders}" var="order" varStatus="loop">
								<tr class="tr-dark">
									<td class="trainingName"><a
										href="/trainings/${order.training.id}">${order.training.name}</a></td>
									<td class="td-chevron"><i
										class="fa fa-chevron-down chevron-toggle pull-right"
										data-toggle="collapse" href="#col${loop.index}"></i></td>
								</tr>
								<tr id="col${loop.index}"
									class="panel-collapse collapse tr-light">
									<td colspan="9">${order.training.description}</td>
								</tr>
								<tr class="tr-light">
									<td>${training.duration.count}
										<c:if test="${training.duration.unit == 'days'}">Jours</c:if> 
										<c:if test="${training.duration.unit == 'day'}">Jour</c:if> 
										<c:if test="${training.duration.unit != 'day' && training.duration.unit != 'days'}">${training.duration.unit}</c:if>
									</td>
									<td>${order.training.price * 0.8}0€</td>
									<td><span>Delete</span></td>
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

</div>
<jsp:include page="/include/footer.jsp" />