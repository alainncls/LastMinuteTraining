<jsp:include page="/include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-6">
		<div class="fakejumbo color-blue">
			<h1>Clients</h1>
			<p>Affichage de la liste des clients</p>
			<p>
				<a class="btn btn-primary btn-sm" role="button" href="/admin/users">Affichage
					des utilisateurs</a>
			</p>
		</div>
	</div>

	<div class="col-sm-6">
		<div class="fakejumbo color-yellow">
			<h1>Fournisseurs</h1>
			<p>Affichage des organismes de formation</p>
			<p>
				<a class="btn btn-primary btn-sm" role="button"
					href="/admin/vendors">Gestion des fournisseurs</a>
			</p>
		</div>
	</div>


</div>


<div class="row">
	<div class="col-sm-6">
		<div class="fakejumbo color-darkblue">
			<h1>Factures clients</h1>
			<p>Affichage des factures clients</p>
			<p>
				<a class="btn btn-primary btn-sm" role="button" href="/work">Factures
					clients</a>
			</p>
		</div>
	</div>
	<div class="col-sm-6">
		<div class="fakejumbo color-darkblue">
			<h1>Factures fournisseurs</h1>
			<p>Affichage des factures fournisseurs</p>
			<p>
				<a class="btn btn-primary btn-sm" role="button" href="/work">Factures
					fournisseurs</a>
			</p>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-6">
		<div class="fakejumbo color-green">
			<h1>Catalogue</h1>
			<p>Gestion du catalogue de formations</p>
			<p>
				<a href="/admin/trainings" class="btn btn-primary btn-sm"
					role="button" href="/work">Gestion du catalogue</a>
			</p>
		</div>
	</div>
	<div class="col-sm-6">
		<div class="fakejumbo color-red">
			<h1>Commandes</h1>
			<p>Affichage des commandes passées</p>
			<p>
				<a class="btn btn-primary btn-sm" role="button" href="/work">Consultation
					des commandes</a>
			</p>
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />