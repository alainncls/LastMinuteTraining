<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<div class="row">
				<div class="col-md-12">
					<h1 class="panel-title">Ajouter une formation</h1>
				</div>
			</div>
		</div>

		<div class="panel-body">
			<div class="row">
				<div class="col-md-4">
					<form role="form" action="addComputer" method="POST">
						<div class="form-group">
							<label for="name">Intitulé de la formation</label> <input type="text"
								class="form-control" name="Formation" id="name"
								placeholder="Intitulé de la formation">
						</div>
						<div class="form-group">
							<label for="introduced">Prix</label> <input
								type="number" class="form-control" name="price"
								id="price" placeholder="Prix" required>
						</div>
						<div class="form-group">
							<label for="introduced">Prix via LMT</label> <input
								type="number" class="form-control" name="priceLMT"
								id="priceLMT" placeholder="Prix LMT" required>
						</div>
						<div class="form-group">
							<label for="name">Début de la formation</label> <input type="text"
								class="form-control" name="startDate" id="startDate"
								placeholder="Intitulé de la formation">
						</div>
						<div class="form-group">
							<label for="name">Fin de la formation</label> <input type="text"
								class="form-control" name="endDate" id="endDate"
								placeholder="Intitulé de la formation">
						</div>
						
						<div class="form-group">
							<label for="discontinued">Difficulté</label> 
							<div class="input">
								<select name="difficulty" class="form-control">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
								</select>	
							</div>
						</div>
						<div class="form-group">
							<label for="name">Description</label> <input type="text"
								class="form-control" name="description" id="description"
								placeholder="Intitulé de la formation">
						</div>

						<div class="actions">
							<button type="submit" class="btn btn-success">Envoyer</button>
							<a href="home" class="btn btn-danger">Annuler</a>
						</div>
					</form>


				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />