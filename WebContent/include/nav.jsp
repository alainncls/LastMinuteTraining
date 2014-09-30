<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Accueil</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-navbar-collapse">
			<!-- Menu -->
			<ul class="nav navbar-nav">
				<!-- liste des liens en fonction des droits d'accès -->
				<li><a href="#">Home</a></li>
				<li><a href="#">GED</a></li>
				<li><a href="#">Webinar</a></li>
			</ul>
			<button type="button" class="btn btn-success navbar-btn navbar-right" data-toggle="modal" data-target="#loginModal">Log In</button>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>

<!-- Modal de login -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="LoginModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span>
				</button>
				<ul class="nav nav-tabs" role="tablist">
					<li class="active"><a href="#signin" data-toggle="tab">Sign In</a></li>
					<li ><a href="#signup" data-toggle="tab">Register</a></li>
				</ul>
			</div>
			<div class="modal-body">
				<div class="tab-content">
					<div class="tab-pane active fade in" id="signin">
						<form class="form-horizontal">
							<!-- Sign In Form -->
							<!-- Text input-->
							<div class="form-group">
								<label for="inputLogin" class="col-sm-4 control-label">Login:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputLogin" name="login" />
								</div>
							</div>
							<!-- Password input-->
							<div class="form-group">
								<label for="inputPassword" class="col-sm-4 control-label">Mot de passe:</label>
								<div class="col-sm-8">
									<input type="password" class="form-control" id="inputPassword" name="password" />
								</div>
							</div>
							<!-- Button -->
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="submit" name="buttonLogin" class="btn btn-success">Sign In</button>
								</div>
							</div>
						</form>
					</div>
					<div class="tab-pane fade" id="signup">
						<form class="form-horizontal">
							<!-- Sign Up Form -->
							<!-- Text input-->
							<div class="form-group">
								<label for="inputEmailNew" class="col-sm-4 control-label">Email:</label>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="inputEmailNew" name="emailNew" />
								</div>
							</div>
							<!-- Text input-->
							<div class="form-group">
								<label for="inputLoginNew" class="col-sm-4 control-label">Login:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="inputLoginNew" name="loginNew" />
								</div>
							</div>
							<!-- Password input-->
							<div class="form-group">
								<label for="inputPasswordNew" class="col-sm-4 control-label">Password:</label>
								<div class="col-sm-8">
									<input type="password" class="form-control" id="inputPasswordNew" name="passwordNew" />
								</div>
							</div>
							<div class="form-group">
								<label for="inputPasswordSecondNew" class="col-sm-4 control-label">Re-Enter Password:</label>
								<div class="col-sm-8">
									<input type="password" class="form-control" id="inputPasswordSecondNew" name="passwordSecondNew" />
								</div>
							</div>
							<!-- Button -->
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="submit" name="buttonRegister" class="btn btn-success">Sign Up</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>