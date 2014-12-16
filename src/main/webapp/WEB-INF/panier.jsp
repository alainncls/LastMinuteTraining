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
			<div class="panel-heading">Les formations choisis</div>
			<div class="table-responsive">
				<table class="table table-hover table-align">
					<thead>
						<tr>
							<th colspan="2">Formation</th>
							<th>Quantité</th>
							<th>Prix</th>
							<th>Supprimer</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${not empty panier.orders}">
								<c:forEach items="${panier.orders}" var="order" varStatus="loop">
									<tr class="tr-dark">
										<td class="trainingName"><a
											href="/trainings/${order.training.id}">${order.training.name}</a></td>
										<td class="td-chevron"><i
											class="fa fa-chevron-down chevron-toggle pull-right"
											data-toggle="collapse" href="#col${loop.index}"></i></td>
										<td><a href="/cart/decrement/${order.training.id}"><span class="fa fa-minus"></span></a>
											${order.quantity} <a href="/cart/increment/${order.training.id}"><span
												class="fa fa-plus"></span></a></td>
										<td>${order.training.price * 0.8}0€</td>
										<td><a href="/cart/remove/${order.training.id}"><span>Delete</span></a></td>
									</tr>
									<tr id="col${loop.index}"
										class="panel-collapse collapse tr-light">
										<td colspan="9">${order.training.description}</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="3">Panier vide</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-sm-8">
			<div class="panel panel-primary">
				<div class="panel-heading">Total de mes formations :
					${sessionScope.cart.total}</div>
				<br>
				<div class="centered">
					<a type="button" class="btn btn-default" href="/home"> <span
						class="fa fa-arrow-circle-left"></span> Continuer mes recherches
					</a> 
					<form action='cart/checkout' METHOD='POST'>
						<input class="btn" type="image"
						src="https://www.paypalobjects.com/fr_FR/FR/i/btn/btn_paynow_LG.gif" name="submit"
						alt="PayPal - la solution de paiement en ligne la plus simple et la plus sécurisée !"></input>
					</form>
				</div>
				<br>
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