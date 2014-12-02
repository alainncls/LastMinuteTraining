<jsp:include page="/include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-6">
		<div class="fakejumbo color-blue marginright">
			<h1>Utilisateurs</h1>
			<p>Gestion des clients</p>
			<p>
				<a class="btn btn-primary btn-sm" role="button" href="/admin/users">Gestion des
					utilisateurs</a>
			</p>
		</div>
	</div>

	<div class="col-sm-6">
		<div class="fakejumbo color-red marginleft">
			<h1>Commandes</h1>
			<p>Accès aux commandes passées</p>
			<p>
				<a class="btn btn-primary btn-sm" role="button">Consultation des
					commandes</a>
			</p>
		</div>
	</div>
</div>


<div class="row">
	<div class="col-sm-6">
		<div class="fakejumbo color-yellow marginright">
			<h1>Fournisseurs</h1>
			<p>Accès aux organismes de formation</p>
			<p>
				<a class="btn btn-primary btn-sm" role="button" href="/admin/vendors">Gestion des
					fournisseurs</a>
			</p>
		</div>
	</div>
	<div class="col-sm-6">
		<div class="fakejumbo color-darkblue marginleft">
			<h1>Factures</h1>
			<p>L'ensemble des factures (clients / vendeurs)</p>
			<p>
				<a class="btn btn-primary btn-sm" role="button">Consultation des
					factures</a>
			</p>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-12 fakejumbo color-green">
		<h1>Catalogue</h1>
		<p>Accès au catalogue de formations</p>
		<p>
			<a href="/admin/trainings" class="btn btn-primary btn-sm" role="button">Gestion du
				catalogue</a>
		</p>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />