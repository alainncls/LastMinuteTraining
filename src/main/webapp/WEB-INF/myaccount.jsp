<jsp:include page="/include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Mes informations</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post" id="userForm">
						<c:if test="${sessionScope.status=='vendor'}">
						<div class="form-group">
							<label for="name">Nom de l'entreprise</label> <input
								type="text" class="form-control" id="name"
								name="name" value="${currentUser.name}" />
						</div>
						</c:if>
						<c:if test="${sessionScope.status=='client'}">
							<div class="form-group">
								<label for="lastName">Nom</label> <input type="text"
									class="form-control" id="lastName" name="lastName"
									value="${currentUser.lastName}" />
							</div>
							<div class="form-group">
								<label for="firstName">Prénom</label> <input type="text"
									class="form-control" id="firstName" name="firstName"
									value="${currentUser.firstName}" />
							</div>
						</c:if>
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
					<div class="form-group">
						<label for="address">Mon adresse postale</label> <input type="text"
							class="form-control" id="address" name="address"
							value="${currentUser.address}" form="userForm" />
					</div>
					<div class="form-group">
						<label for="town">Ville</label> <input type="text"
							class="form-control" id="town" name="town"
							value="${currentUser.town}" form="userForm"/>
					</div>
					<div class="form-group">
						<label for="town">Code postal</label> <input type="text"
							class="form-control" id="cp" name="cp"
							value="${currentUser.cp}" form="userForm"/>
					</div>
					<div class="form-group">
						<label for="mail">Mon adresse mail</label> <input type="text"
							class="form-control" id="mail" name="mail"
							value="${currentUser.mail}" form="userForm"/>
					</div>
					<div class="form-group">
						<label for="phone">Mon numéro de portable</label> <input
							type="tel" class="form-control" id="phone"
							name="phone" value="${currentUser.phone}" form="userForm"/>
					</div>
					<div class="form-group">
						<label for="id">Mon identifiant LMT (à rappeler dans
							toutes vos communications avec LMT)</label> <input type="text"
							class="form-control" id="id" name="id"
							disabled="disabled" value="${sessionScope.id}" form="userForm"/>
					</div>
					<div class="form-group">
						<label for="inputNewsletter">Je souhaite recevoir des
							offres et informations de la part de LMT : </label>
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-sm btn-primary active"> <input
								type="radio" name="newsletter" value="1" id="newsletterYes" checked="checked" form="userForm"/>
								Oui
							</label> <label class="btn btn-sm btn-primary"> <input type="radio"
								name="newsletter" value="0" id="newsletterNo" form="userForm"/> Non
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="inputNewsletter">Je souhaite recevoir par SMS
							les offres de dernière minute de LMT : </label>
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-sm btn-primary active"> <input
								type="radio" name="sms" value="1" id="smsYes" checked="checked" form="userForm"/> Oui
							</label><label class="btn btn-sm btn-primary"> <input type="radio"
								name="sms" value="0" id="smsNo" form="userForm"/> Non
							</label>
						</div>
					</div>
					<div class="actions">
						<button type="submit" class="btn btn-success btn-xs" form="userForm">Enregistrer</button>
						<a href="home" class="btn btn-danger btn-xs">Annuler</a>
					</div>
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
				<c:if test="${sessionScope.status=='client'}">
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="inputCB">Mon n° de carte bancaire pro</label> <input
									type="text" class="form-control" id="cardNumber" name="cardNumber"
									value="${currentUser.cardNumber}" form="userForm"/>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="inputCBExp">Date d'exp. de ma carte bancaire
									pro</label> <input type="text" class="form-control" id="expirationDate"
									name="expirationDate" value="${currentUser.expirationDate}" form="userForm"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="form-group">
								<label for="inputBank">Organisme payeur</label> <input
									type="text" class="form-control" id="bank"
									name="bank" value="${currentUser.bank}" form="userForm"/>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${sessionScope.status=='vendor'}">
					<div class="row">
						<div class="col-sm-7">
							<div class="form-group">
								<label for="iban">Mon n° IBAN</label> <input
									type="text" class="form-control" id="iban" name="iban"
									value="${currentUser.iban}" form="userForm"/>
							</div>
						</div>
					</div>
				</c:if>
				<div class="actions">
					<button type="submit" class="btn btn-success btn-xs" form="userForm">Enregistrer</button>
					<a href="home" class="btn btn-danger btn-xs">Annuler</a>
				</div>
			</div>
		</div>
	</div>

	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Modifier mon mot de passe</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post" id="pwdForm">
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
						<button type="submit" class="btn btn-success btn-xs" form="pwdForm">Enregistrer</button>
						<a href="home" class="btn btn-danger btn-xs">Annuler</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
$(function () {
    $('#iban').inputmask({
    	  mask: 'FR99 **** **** **** **** **** *99'
    	});
});
</script>

<jsp:include page="/include/footer.jsp" />