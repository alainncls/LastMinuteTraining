<jsp:include page="/include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-6 jumbotron color-blue margin">
		<h1>Utilisateurs</h1>
		<p>
			Des tonnes de
			<del>pigeons</del>
			<ins>clients</ins>
			à gérer !
		</p>
		<p>
			<a class="btn btn-primary btn-lg" role="button">Gestion des
				utilisateurs</a>
		</p>
	</div>

	<div class="col-sm-6 jumbotron color-red margin">
		<h1>Commandes</h1>
		<p>Accès aux commandes passées</p>
		<p>
			<a class="btn btn-primary btn-lg" role="button">Consultation des
				commandes</a>
		</p>
	</div>
</div>


<div class="row">
	<div class="col-sm-6 jumbotron color-yellow margin">
		<h1>Fournisseurs</h1>
		<p>Accès aux organismes de formation</p>
		<p>
			<a class="btn btn-primary btn-lg" role="button">Gestion des
				fournisseurs</a>
		</p>
	</div>

	<div class="col-sm-6 jumbotron color-darkblue margin">
		<h1>Factures</h1>
		<p>L'ensemble des factures (clients / vendeurs)</p>
		<p>
			<a class="btn btn-primary btn-lg" role="button">Consultation des
				factures</a>
		</p>
	</div>
</div>
<div class="row">
	<div class="col-sm-12 jumbotron color-green margin">
		<h1>Catalogue</h1>
		<p>Accès au catalogue de formations</p>
		<p>
			<a class="btn btn-primary btn-lg" role="button">Gestion du
				catalogue</a>
		</p>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />