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
				<li><!-- Button trigger modal -->
					<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#loginModal">LogIn</button>
				</li>
			</ul>

			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
</nav>

<!-- Modal de login -->
<div class="modal fade bs-modal-sm" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="LoginModal" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<br>
			<div class="bs-example bs-example-tabs">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#signin" data-toggle="tab">Sign In</a></li>
					<li class=""><a href="#signup" data-toggle="tab">Register</a></li>
				</ul>
			</div>
			<div class="modal-body">
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade active in" id="signin">
						<form class="form-horizontal">
							<fieldset>
								<!-- Sign In Form -->
								<!-- Text input-->
								<div class="control-group">
									<label class="control-label" for="userid">Alias:</label>
									<div class="controls">
										<input required="" id="userid" name="userid" type="text" class="form-control" placeholder="JoeSixpack" class="input-medium" required="">
									</div>
								</div>

								<!-- Password input-->
								<div class="control-group">
									<label class="control-label" for="passwordinput">Password:</label>
									<div class="controls">
										<input required="" id="passwordinput" name="passwordinput" class="form-control" type="password" placeholder="********" class="input-medium">
									</div>
								</div>

								<!-- Multiple Checkboxes (inline) -->
								<div class="control-group">
									<label class="control-label" for="rememberme"></label>
									<div class="controls">
										<label class="checkbox inline" for="rememberme-0">
											<input type="checkbox" name="rememberme" id="rememberme-0" value="Remember me">
											Remember me
										</label>
									</div>
								</div>

								<!-- Button -->
								<div class="control-group">
									<label class="control-label" for="signin"></label>
									<div class="controls">
										<button id="signin" name="signin" class="btn btn-success">Sign In</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="tab-pane fade" id="signup">
						<form class="form-horizontal">
							<fieldset>
								<!-- Sign Up Form -->
								<!-- Text input-->
								<div class="control-group">
									<label class="control-label" for="Email">Email:</label>
									<div class="controls">
										<input id="Email" name="Email" class="form-control" type="text" class="input-large" required="" />
									</div>
								</div>

								<!-- Text input-->
								<div class="control-group">
									<label class="control-label" for="userid">Alias:</label>
									<div class="controls">
										<input id="userid" name="userid" class="form-control" type="text" placeholder="JoeSixpack" class="input-large" required="" />
									</div>
								</div>

								<!-- Password input-->
								<div class="control-group">
									<label class="control-label" for="password">Password:</label>
									<div class="controls">
										<input id="password" name="password" class="form-control" type="password" placeholder="********" class="input-large" required="" />
										<em>1-8 Characters</em>
									</div>
								</div>

								<!-- Text input-->
								<div class="control-group">
									<label class="control-label" for="reenterpassword">Re-Enter Password:</label>
									<div class="controls">
										<input id="reenterpassword" class="form-control" name="reenterpassword" type="password" placeholder="********" class="input-large" required="" />
									</div>
								</div>
								<!-- Button -->
								<div class="control-group">
									<label class="control-label" for="confirmsignup"></label>
									<div class="controls">
										<button id="confirmsignup" name="confirmsignup" class="btn btn-success">Sign Up</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<center>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</center>
			</div>
		</div>
	</div>
</div>