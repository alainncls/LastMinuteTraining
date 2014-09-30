<jsp:include page="/include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-sm-6">
		<div class="table-responsive">
			<table class="table table-hover table-striped table-condensed">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Prix</th>
						<th>Prix via SM</th>
						<th>Date</th>
						<th>Difficulté</th>
					</tr>
				</thead>
				<tbody>
					<!-- <c:forEach items="${formations}" var="formation">
					<tr>
						<td><a href="addformation?id=${formation.id}">${formation.name}</a></td>
						<td>${formation.prix}</td>
						<td>${formation.prixReduc}</td>
						<td>${formation.date_debut}</td>
						<td>${formation.niveau}</td>
					</tr>
					</c:forEach> -->
				<tr>
					<td><a href="addformation?id=1">Formation 1</a></td>
					<td>1000€</td>
					<td>100€</td>
					<td>20/02/2014</td>
					<td>Tada magic !</td>
				</tr>
				<tr>
					<td><a href="addformation?id=2">Formation 2</a></td>
					<td>2000€</td>
					<td>200€</td>
					<td>20/02/2014</td>
					<td>Tada magic !</td>
				</tr>
				<tr>
					<td><a href="addformation?id=3">Formation 3</a></td>
					<td>3000€</td>
					<td>300€</td>
					<td>20/02/2014</td>
					<td>Tada magic !</td>
				</tr>
				<tr>
					<td><a href="addformation?id=4">Formation 4</a></td>
					<td>4000€</td>
					<td>400€</td>
					<td>20/02/2014</td>
					<td>Tada magic !</td>
				</tr>
				<tr>
					<td><a href="addformation?id=5">Formation 5</a></td>
					<td>5000€</td>
					<td>500€</td>
					<td>20/02/2014</td>
					<td>Tada magic !</td>
				</tr>
				<tr>
					<td><a href="addformation?id=6">Formation 6</a></td>
					<td>6000€</td>
					<td>600€</td>
					<td>20/02/2014</td>
					<td>Tada magic !</td>
				</tr>
				<tr>
					<td><a href="addformation?id=7">Formation 7</a></td>
					<td>7000€</td>
					<td>700€</td>
					<td>20/02/2014</td>
					<td>Tada magic !</td>
				</tr>
				<tr>
					<td><a href="addformation?id=8">Formation 8</a></td>
					<td>8000€</td>
					<td>800€</td>
					<td>20/02/2014</td>
					<td>Tada magic !</td>
				</tr>
				<tr>
					<td><a href="addformation?id=9">Formation 9</a></td>
					<td>9000€</td>
					<td>900€</td>
					<td>20/02/2014</td>
					<td>Tada magic !</td>
				</tr>
				<tr>
					<td><a href="addformation?id=10">Formation 10</a></td>
					<td>10000€</td>
					<td>1000€</td>
					<td>20/02/2014</td>
					<td>Tada magic !</td>
				</tr>
			</tbody>
			</table>
		</div>
	</div>
	<div class="col-sm-6">
		<div class="row">
			<div class="col-sm-12">
				<form class="form-inline pull-right" role="search" method="post">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
			<div class="col-sm-12">
				<jsp:include page="/include/calendar.jsp" />
			</div>
		</div>
	</div>
</div>
<jsp:include page="/include/footer.jsp" />