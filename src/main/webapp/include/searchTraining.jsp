<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Filtre de recherche</h3>
			</div>
			<div class="panel-body">
				<%-- <pre>${debug}</pre> --%>
				<form role="form" method="POST">
					<div class="form-group">
						<label for="inputName">Nom</label> <input type="text"
							class="form-control" id="inputName" name="name" value="${training.name}" />
					</div>
					<div class="form-group">
						<label for="inputPrereq">Prérequis</label> <select multiple
							class="form-control chosen-select" id="inputPrereq"
							name="inputPrereq[]">
							<c:forEach items="${prerequis}" var="prerequis">
								<option value="${prerequis.id}" selected="${prerequis.selected}">${prerequis.name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="inputStart">Date Début</label> <input type="date"
							class="form-control" id="inputStart" name="startDate" value="${training.startDate}" />
					</div>
					<div class="form-group">
						<label for="inputEnd">Date Fin</label> <input type="date"
							class="form-control" id="inputEnd" name="endDate" value="${training.endDate}" />
					</div>
					<div class="form-group">
						<label for="inputPriceLMT">Prix LMT</label> <input type="number"
							class="form-control" id="inputPriceLMT" name="priceLMT" value="${training.priceLMT}" />
					</div>
					<div class="form-group">
						<label for="difficulty">Difficulté</label>
						<div class="ratingstars" data-score=""></div>
					</div>
					<div class="form-group">
						<label for="inputVendor">Organisme Formateur</label> <select
							multiple class="form-control chosen-select" id="inputVendor"
							name="inputVendor[]">
							<c:forEach items="${vendors}" var="vendor">
								<option value="${vendor.id}" selected="${vendor.selected}">${vendor.name}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Rechercher</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%-- 	<div class="col-sm-9">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Resultats de la recherche</h3>
            </div>
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prix</th>
                            <th>Prix LMT</th>
                            <th>Date</th>
                            <th>Difficulté</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${trainings}" var="training">
                            <tr>
                                <td><a href="addtraining?id=${training.id}">${training.name}</a></td>
                                <td>${training.prix}</td>
                                <td>${training.prixReduc}</td>
                                <td>${training.date_debut}</td>
                                <td>${training.niveau}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div> --%>
</div>
