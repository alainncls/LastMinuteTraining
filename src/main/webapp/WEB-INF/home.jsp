<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Modal d'ajout panier -->

<div class="modal fade" id="buyModal" tabindex="-1" role="dialog"
	aria-labelledby="BuyModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Fermer</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">Ajouter au
					panier</h4>
				<br> Vous venez d'ajouter ce produit à votre panier
			</div>
			<div class="modal-body">
				<form role="form">
					<div class="modal-name">
						Formation : <label for="name" class="control-label">X</label>
					</div>
					<div class="modal-price">
						<br>Prix avec LastMinuteTraining <br>
						<label for="price" class="control-label"><del>0.0 €</del></label>
					</div>
					<div class="modal-priceLMT">	
					<h4>
							<label for="priceLMT" class="control-label">0 €</label>
						</h4>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">
					<span class="fa fa-arrow-circle-left"></span> Continuer mes
					recherches
				</button>
				<button type="button" class="btn btn-primary">
					Terminer ma commande <span class="fa fa-check"></span>
				</button>
			</div>
		</div>
	</div>
</div>

<script>
$('#buyModal').on('show.bs.modal', function (event) {
	
	var button = $(event.relatedTarget) // Button that triggered the modal
	  var training = button.data('name') // Extract info from data-* attributes
	  var price = button.data('price')
	  var priceLMT = button.data('priceLMT')
	  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
	  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
	  var modal = $(this)
	  modal.find('.modal-name input').val(training)
	  modal.find('.modal-price input').val(price)
	  modal.find('.modal-priceLMT input').val(priceLMT)
	  alert(training);  
	})
</script>

<div class="row">
	<div class="col-sm-12">
		<h3>Passer par LastMinuteTraining.com, c'est s'assurer d'avoir
			les meilleurs prix du marché sur les meilleures formations ERP / SAP
			du moment</h3>
		<h4>Clientèle satisfaite à 97%</h4>
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
										href="/trainings/${training.id}">${training.name}</a></td>
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
									<td>${training.price * 0.8}0€</td>
									<%-- <td>${${training.priceLMT}*2}€</td> --%>
									<td>${training.date.startDate}</td>
									<td>${training.duration.count} <c:if
											test="${training.duration.unit == 'days'}">Jours</c:if> <c:if
											test="${training.duration.unit == 'day'}">Jour</c:if> <c:if
											test="${training.duration.unit != 'day' && training.duration.unit != 'days'}">${training.duration.unit}</c:if></td>
									<td><c:forEach begin="1" end="${training.level}">
											<i class="fa fa-star"></i>
										</c:forEach></td>
									<td>${training.available}</td>
									<td colspan="3"><button type="button"
											class="btn btn-warning navbar-btn navbar-right nomargin btn-sm"
											data-toggle="modal" data-target="#buyModal"
											data-price="${training.price}"
											data-priceLMT="${training.price*0.8}"
											data-name="${training.name}">
											<span class="fa fa-shopping-cart"></span> Acheter
										</button></td>
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