<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div id="form_login" class="panel panel-primary">
		<div class="panel-heading">
			<h3 class="panel-title">Login</h3>
		</div>
		<div class="panel-body">
			<form class="form-horizontal" method="post" action="login">
				<!-- Sign In Form -->
				<!-- Text input-->
				<div class="form-group">
					<label for="inputLogin" class="col-sm-4 control-label">Login:</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="inputLogin" name="login" value="${login}" />
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

		<c:if test="${error}">
			<div class="panel-footer">
				<p class="text-danger">Login ou Mot de passe incorrect</p>
			</div>
		</c:if>
	</div>
</div>
<jsp:include page="/include/footer.jsp" />