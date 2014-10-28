<jsp:include page="/include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Mes informations</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post">
					<div class="form-group">
						<label for="inputLastName">Nom de l'entreprise</label> <input
							type="text" class="form-control" id="inputClientName"
							name="inputClientName" value="EPF Oenologie" />
					</div>
					<div class="form-group">
						<label for="inputLastName">Nom</label> <input type="text"
							class="form-control" id="inputLastName" name="inputLastName"
							value="Fex" />
					</div>
					<div class="form-group">
						<label for="inputFirstName">Prénom</label> <input type="text"
							class="form-control" id="inputFirstName" name="inputName"
							value="Jean" />
					</div>
					<div class="actions">
						<button type="submit" class="btn btn-success btn-xs">Enregistrer</button>
						<a href="home" class="btn btn-danger btn-xs">Annuler</a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Mes dernières factures</h3>
			</div>
			<div class="panel-body">OK, une idée comme ça hein !</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-12">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Mes informations de contact</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post">
					<div class="form-group">
						<label for="inputMail">Mon adresse mail</label> <input type="text"
							class="form-control" id="inputMail" name="inputMail"
							value="jean.fex@epf.fr" />
					</div>
					<div class="form-group">
						<label for="inputMobile">Mon numéro de portable</label> <input
							type="tel" class="form-control" id="inputMobile"
							name="inputMobile" value="06 41 13 90 52" />
					</div>
					<div class="form-group">
						<label for="inputID">Mon identifiant LMT (à rappeler dans
							toutes vos communications avec LMT)</label> <input type="text"
							class="form-control" id="inputID" name="inputID"
							disabled="disabled" value="00038736" />
					</div>
					<div class="form-group">
						<label for="inputNewsletter">Je souhaite recevoir des
							offres et informations de la part de LMT : </label>
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-primary active"> <input
								type="radio" name="options" id="newsletterYes" checked>
								Yes
							</label> <label class="btn btn-primary"> <input type="radio"
								name="options" id="newsletterNo"> No
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="inputNewsletter">Je souhaite recevoir par SMS
							les offres de dernière minute de LMT : </label>
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-primary active"> <input
								type="radio" name="smsYes" id="smsYes" checked> Yes
							</label><label class="btn btn-primary"> <input type="radio"
								name="smsNo" id="smsNo"> No
							</label>
						</div>
					</div>
					<div class="actions">
						<button type="submit" class="btn btn-success btn-xs">Enregistrer</button>
						<a href="home" class="btn btn-danger btn-xs">Annuler</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Mes moyens de paiement</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post">
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="inputCB">Mon n° de carte bancaire pro</label> <input
									type="text" class="form-control" id="inputCB" name="inputCB"
									value="0000 3333 4444 9999" />
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="inputCBExp">Date d'exp. de ma carte bancaire
									pro</label> <input type="text" class="form-control" id="inputCBExp"
									name="inputCBExp" value="10/17" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group">
								<label for="inputBank">Organisme payeur</label> <input
									type="text" class="form-control" id="inputBank"
									name="inputBank" value="Caisse d'Epargne" />
							</div>
							<div class="actions">
								<button type="submit" class="btn btn-success btn-xs">Enregistrer</button>
								<a href="home" class="btn btn-danger btn-xs">Annuler</a>
							</div>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>

	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Modifier mon mot de passe</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post">
					<div class="form-group">
						<label for="inputOldPass">Mot de passe actuel</label> <input
							type="password" class="form-control" id="inputOldPass"
							name="inputOldPass" placeholder="********" />
					</div>
					<div class="form-group">
						<label for="inputNewPass">Nouveau mot de passe</label> <input
							type="password" class="form-control" id="inputNewPass"
							name="inputNewPass" placeholder="********" />
					</div>
					<div class="form-group">
						<label for="inputNewPass2">Nouveau mot de passe (encore)</label> <input
							type="password" class="form-control" id="inputNewPass2"
							name="inputNewPass2" placeholder="********" />
					</div>

					<div class="actions">
						<button type="submit" class="btn btn-success btn-xs">Enregistrer</button>
						<a href="home" class="btn btn-danger btn-xs">Annuler</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />