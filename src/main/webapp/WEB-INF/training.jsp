<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="container-fluid">
		<div class="row">
			<c:if test="${not empty training}">
				<div class="jumbotron col-md-8">
					<div class="container">

						<h2>
							${training}<span class="level level-3">text_level</span>
						</h2>
						<dl>
							<dt>Solution:</dt>
							<dd>SAP ERP</dd>
							<dt>Delivery Method:</dt>
							<dd>Classroom, Virtual Live Classroom</dd>
							<dt>Duration:</dt>
							<dd>2 days</dd>
							<dt>Delivery Languages:</dt>
							<dd>English, French</dd>
							<dt>Rating:</dt>
							<dd>
								<td><c:forEach begin="1" end="3">
										<i class="fa fa-star"></i>
									</c:forEach></td>
							</dd>
							<dt>NOTE:</dt>
							<dd>Please click on the schedule tab for more details. The
								details you’ll see may vary depending on the event you select.</dd>
						</dl>
					</div>
				</div>
				<div class="jumbotron col-md-3">
					<div class="container">
						<h2>Réserver</h2>
						<ul class="sap">
							<li><div><dt>Date:</dt>
							<dd>11/11/11</dd></div></li>
							<li><div><dt>Prix:</dt>
							<dd>1k£</dd></div></li>
								<li><div><dt>Lieux:</dt>
							<dd>La Defense</dd></div></li>
						</ul>
					</div>
				</div>
				<div class="jumbotron col-md-3">
					<div class="container">
						<h2>Related Curricula</h2>
						<ul class="sap">
							<li><a href="#">related</a></li>
							<li><a href="#">related</a></li>
						</ul>
					</div>
				</div>
				<div class="jumbotron col-md-8">
					<div class="container">
						<h2>Description</h2>
						<div class="span6 col-md-6">
							<h4>Objectifs</h4>
							<ul class="sap">
								<li>objectif</li>
							</ul>
						</div>
						<div class="span6 col-md-6">
							<h4>Public</h4>
							<ul class="sap">
								<li>person</li>
							</ul>
						</div>
						<div class="span6 col-md-6">
							<h4>Prérequis</h4>
							<h5>Essentiels</h5>
							<ul class="sap">
								<li>ess</li>
							</ul>
							<h5>Recommandé</h5>
							<ul class="sap">
								<li>rec</li>
							</ul>
						</div>
						<div class="span6 col-md-6">
							<h4>Cours basés sur les versions des logiciels</h4>
							<ul class="sap">
								<li>version</li>
							</ul>
						</div>
						<div class="span6 col-md-6">
							<h4>Contenu</h4>
							<ul class="sap">
								<li>content</li>
							</ul>
						</div>
						<div class="span6 col-md-6">
							<h4>Informations additionnelles</h4>
						</div>

					</div>
				</div>
			</c:if>
		</div>
	</div>
</div>
</div>
<jsp:include page="/include/footer.jsp" />