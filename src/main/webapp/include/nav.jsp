<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home">Accueil</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-navbar-collapse">
			<!-- Menu -->
			<ul class="nav navbar-nav">
				<!-- liste des liens en fonction des droits d'accï¿½s -->
				<li><a href="404">Base documentaire</a></li>
				<li><a href="work">Webinars</a></li>
				<li><a href="work">A propos</a></li>
				<li><a href="work">CGV</a></li>

				<c:if test="${sessionScope.status=='vendor'}">
					<li><a href="addTraining">Ajouter une formation</a></li>
				</c:if>


			</ul>
			<c:choose>
				<c:when test="${sessionScope.login==null}">
					<button type="button"
						class="btn btn-success navbar-btn navbar-right"
						data-toggle="modal" data-target="#loginModal">
						<span class="fa fa-sign-in"></span> Connexion
					</button>
				</c:when>
				<c:otherwise>
					<a class="btn btn-danger navbar-btn navbar-right" href="logout">
						<span class="fa fa-sign-out"></span> Déconnexion
					</a>
				</c:otherwise>
			</c:choose>
			<button type="button" class="btn btn-warning navbar-btn navbar-right"
				data-toggle="modal" data-target="#cartModal">
				<span class="fa fa-shopping-cart"></span> Mon Panier
			</button>
			<c:if test="${sessionScope.status!=null}">
				<a class="btn btn-info navbar-btn navbar-right" href="myaccount">
					<span class="fa fa-user"></span> Mon compte
				</a>
                <c:if test="${sessionScope.status=='vendor'}">
                    <a class="btn btn-file navbar-btn navbar-right" href="mytrainings">
                        <span class="fa fa-file-text"></span> Mes formations
                    </a>
                </c:if>
			</c:if>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>

<script>
	$(document).ready(function() {

		var menu = $('.navbar');
		var origOffsetY = menu.offset().top;

		function scroll() {
			if ($(window).scrollTop() >= origOffsetY) {
				$('.navbar').addClass('navbar-fixed-top');
				$('#page-content').addClass('navbar-padding');
			} else {
				$('.navbar').removeClass('navbar-fixed-top');
				$('#page-content').removeClass('navbar-padding');
			}
		}

		document.onscroll = scroll;
	});
</script>

<!-- Modal de login -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
	aria-labelledby="LoginModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span>
				</button>
				<ul class="nav nav-tabs" role="tablist">
					<li class="active"><a href="#signin" data-toggle="tab">Connexion</a></li>

					<li><a href="#signup" data-toggle="tab">S'enregistrer</a></li>
				</ul>
			</div>
			<div class="modal-body">
				<div class="tab-content">
					<div class="tab-pane active fade in" id="signin">
						<form class="form-horizontal" method="post" action="login">
							<!-- Sign In Form -->
							<!-- Text input-->
							<div class="form-group">
								<label for="inputLogin" class="col-sm-4 control-label">Login:</label>

								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputLogin"
										name="login" />

								</div>
							</div>
							<!-- Password input-->
							<div class="form-group">
								<label for="inputPassword" class="col-sm-4 control-label">Mot
									de passe:</label>


								<div class="col-sm-8">
									<input type="password" class="form-control" id="inputPassword"
										name="password" />
								</div>
							</div>
							<!-- Button -->
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="submit" name="buttonLogin"
										class="btn btn-success">Connexion</button>

								</div>
							</div>
						</form>
					</div>
					<div class="tab-pane fade" id="signup">
						<form class="form-horizontal" method="post" action="register">
							<!-- Sign Up Form -->
							<!-- Text input-->
							<div class="form-group">
								<label for="inputEmailNew" class="col-sm-4 control-label">Email:</label>

								<div class="col-sm-8">
									<input type="email" class="form-control" id="inputEmailNew"
										name="mail" />

								</div>
							</div>
							<!-- Text input-->
							<div class="form-group">
								<label for="inputLoginNew" class="col-sm-4 control-label">Login:</label>

								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputLoginNew"
										name="login" />

								</div>
							</div>
							<!-- Password input-->
							<div class="form-group">
								<label for="inputPasswordNew" class="col-sm-4 control-label">Mot de passe:</label>

								<div class="col-sm-8">
									<input type="password" class="form-control"
										id="inputPasswordNew" name="password" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPasswordSecondNew"
									class="col-sm-4 control-label">Entrer de nouveau le mot de passe:</label>

								<div class="col-sm-8">
									<input type="password" class="form-control"
										id="inputPasswordSecondNew" name="passwordSecond" />

								</div>
							</div>
							<div class="btn-group" data-toggle="buttons">
								<label class="btn btn-sm btn-primary active"> <input
									type="radio" name="status" value="client" id="statusClient"
									checked="checked" /> Client
								</label> <label class="btn btn-sm btn-primary"> <input
									type="radio" name="status" value="vendor" id="statusVendor" />
									Vendeur
								</label>
							</div>
							<!-- Button -->
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="submit" name="buttonRegister"
										class="btn btn-success">Sign Up</button>
								</div>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

</div>


<!-- Modal de mon panier -->
<div class="modal fade" id="cartModal" tabindex="-1" role="dialog"
	aria-labelledby="CartModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				Mon panier
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span>
				</button>

			</div>
			<div class="modal-body">
				Article 1<br> Article 2<br> Article 3<br>
			</div>
			<div class="modal-footer">
				<a href="404" class="btn btn-warning btn-sm">Passer ma commande
					<span class="fa fa-arrow-circle-right"></span>
				</a>
			</div>
		</div>
	</div>

</div>