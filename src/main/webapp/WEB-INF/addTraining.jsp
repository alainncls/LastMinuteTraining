<jsp:include page="/include/header.jsp" />

<div class="row">
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Informations générales</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="POST" id="trainingForm">
					<div class="form-group">
						<label for="name">Intitulé de la formation</label> <input
						type="text" class="form-control" name="name" id="name"
						placeholder="Intitulé de la fromation" />
					</div>
					<div class="form-group">
						<label for="price">Prix</label> <input type="number"
						class="form-control" name="price" id="price" placeholder="Prix"
						required="required" />
					</div>
					<div class="form-group">
						<label for="priceLMT">Prix via LMT (temporaire)</label> <input type="number"
						class="form-control" name="priceLMT" id="priceLMT"
						placeholder="Prix LMT" required="required" />
					</div>
					<div class="form-group">
						<label for="level">Difficulté </label>
						<div class="ratingstars" name="level" id="level"></div>
					</div>
					<div class="form-group">
						<label for="summary">Résumé</label> <input type="text"
						class="form-control" name="summary" id="summary"
						/>
					</div>
					<div class="form-group">
						<label for="category">Catégorie</label> <input type="text"
						class="form-control" name="category" id="category" placeholder="SAP ERP, SAP NetWeaver, ..."
						required="required" />
					</div>
					<div class="actions">
						<button type="submit" class="btn btn-success">Envoyer</button>
						<a href="home" class="btn btn-danger">Annuler</a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Informations pratiques</h3>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label for="date.startDate">Début de la formation</label> <input
					type="date" class="form-control" name="date.startDate" id="date.startDate" 
					required="required" form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="date.endDate">Fin de la formation</label> <input type="date"
					class="form-control" name="date.endDate" id="date.endDate" 
					required="required" form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="language">Langue</label> <input type="text"
					class="form-control" name="language" id="language"
					required="required" form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="location">Lieux de la formation</label> <input type="text"
					class="form-control" name="location" id="location"
					required="required" form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="method">Type d'enseignement</label> <input type="text"
					class="form-control" name="method" id="method"
					placeholder="En classe, e-learning, ..." 
					form="trainingForm" />
				</div>
				<div class="actions">
					<button type="submit" class="btn btn-success" form="trainingForm">Envoyer</button>
					<a href="home" class="btn btn-danger">Annuler</a>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Informations complémentaires</h3>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label for="target">Utilisateurs cibles</label> <input type="text"
					class="form-control" name="audience" id="audience"
					form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="notes">Notes</label> <input type="text"
					class="form-control" name="notes" id="notes"
					placeholder="La certification n'est disponible qu'en anglais" 
					form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="url">Lien de la formation</label> <input type="text"
					class="form-control" name="url" id="url" placeholder="training.sap.com/course/lumira-classroom-014-fr-en"
					form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="release">Version du logiciel</label> <input type="text"
					class="form-control" name="release" id="release"
					form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="description">Description</label> <input type="text"
					class="form-control" name="description" id="description" 
					form="trainingForm"/>
				</div>
				<div class="actions">
					<button type="submit" class="btn btn-success" form="trainingForm">Envoyer</button>
					<a href="home" class="btn btn-danger">Annuler</a>
				</div>
			</div>
		</div>
	</div>
</div>




<jsp:include page="/include/footer.jsp" />