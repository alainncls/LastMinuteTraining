<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>

<div class="container">
	<div class="panel panel-primary">
		<div class="panel-heading">
			<div class="row">
				<div class="col-md-12">
					<h1 class="panel-title">Ajouter un organisme de formation</h1>
				</div>
			</div>
		</div>

		<div class="panel-body">
			<div class="row">
				<div class="col-md-4">
					<form role="form" action="addVendeur" method="POST">
						<div class="form-group">
							<label for="name">Nom de l'organisme</label> <input
								type="text" class="form-control" name="name" id="name"
								placeholder="Nom de l'organisme" />
						</div>
						<div class="form-group">
							<label for="avatar">Avatar</label> <input type="text"
								class="form-control" name="avatar" id="avatar" placeholder="Avatar"
								required="required" />
						</div>
						<div class="form-group">
							<label for="mail">Adresse mail</label> <input type="email"
								class="form-control" name="mail" id="mail"
								placeholder="exemple@epf.fr" required="required" />
						</div>
						<div class="form-group">
							<label for="tel">Num�ro de t�l�phone</label> <input
								type="text" maxlength="10" class="form-control" name="tel" id="tel"
								placeholder="xx xx xx xx xx" required="required" />
						</div>
						<div class="form-group">
							<label for="adresse">Adresse</label> <input type="text"
								class="form-control" name="adresse" id="adresse" 
								required="required"/>
						</div>
						<div class="form-group">
							<label for="cp">Code Postal</label> <input type="number" maxlength="5"
								class="form-control" name="cp" id="cp" 
								required="required"/>
						</div>
						<div class="form-group">
							<label for="ville">Ville</label> <input type="text"
								class="form-control" name="ville" id="ville" 
								required="required"/>
						</div>
						<div class="form-group">
							<label for="marge">Marge</label> <input type="number"
								class="form-control" name="marge" id="marge" 
								placeholder="xxx &euro;" required="required"/>
						</div>
						<div class="form-group">
							<label for="abonnement">IBAN</label> <input type="number"
								class="form-control" name="iban" id="iban" 
								required="required"/>
						</div>
						<div class="form-group">
							<label for="abonnement">Abonnement</label> 
							<input class="radio-inline" type="radio" name="abonnement" id="abonnementY" value="1">Oui
                    		<input class="radio-inline" type="radio" name="abonnement" id="abonnementN" value="0" checked="true">Non
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