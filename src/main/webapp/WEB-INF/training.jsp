<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="container">
	<div class="container-fluid">
		<div class="row">
			<c:if test="${not empty training}">
				<div class="jumbotron col-md-8">
					<div class="container">

						<h2>
							${training.name}<span class="level level-${training.level}">text_level</span>
						</h2>
						<dl>
							<dt>Solution:</dt>
							<dd>${training.solution}</dd>
							<dt>Delivery Method:</dt>
							<dd>${training.method}</dd>
							<dt>Duration:</dt>
							<dd>${training.duration.count}${training.duration.unit}</dd>
							<dt>Delivery Languages:</dt>
							<dd>${training.language}</dd>
							<dt>Rating:</dt>
							<dd>
								<td><c:forEach begin="1" end="${training.evaluation}">
										<i class="fa fa-star"></i>
									</c:forEach></td>
							</dd>
						</dl>
					</div>
				</div>
				<div class="jumbotron col-md-3">
					<div class="container">
						<h2>Réserver</h2>
						<ul class="sap">
							<li><div>
									<dt>Date:</dt>
									<dd>${training.date.startDate}-${training.date.endDate}</dd>
								</div></li>
							<li><div>
									<dt>Prix:</dt>
									<dd>${training.price}</dd>
								</div></li>
							<li><div>
									<dt>Lieux:</dt>
									<dd>${training.location}</dd>
								</div></li>
						</ul>
					</div>
				</div>
				<div class="jumbotron col-md-8">
					<div class="container">
						<h2>Description</h2>
						<div class="span6 col-md-6">
							<h4>Objectifs</h4>
							<ul class="sap">${training.description}
							</ul>
						</div>
						<div class="span6 col-md-6">
							<h4>Public</h4>
							<ul class="sap">
								<c:forEach items="${training.audience}" var="train">
									<li>${train}</li>
								</c:forEach>
								</td>
							</ul>
						</div>
						<div class="span6 col-md-6">
							<h4>Prérequis</h4>
							<h5>Essentiels</h5>
							<ul class="sap">
								<!-- True if its not just a text -->
								<c:if
									test="${fn:length(training.prerequisites.essential[0]) gt 0}">
									<c:if
										test="${fn:length(training.prerequisites.essential[0].requirement) eq 2}">
										<c:forEach items="${training.prerequisites.essential}"
											var="ess">
											<li><a href="/trainings/${ess.requirement.url_text}">${ess.requirement.url_text}</a></li>
										</c:forEach>
									</c:if>
									<c:if
										test="${training.prerequisites.essential[0].requirement.class.simpleName == 'String'}">
										<c:forEach items="${training.prerequisites.essential}"
											var="rec">
											<li>${rec.requirement}</li>
										</c:forEach>
									</c:if>
								</c:if>
								<c:if
									test="${fn:length(training.prerequisites.essential[0]) eq 0}">
										Empty
								</c:if>
							</ul>
							<h5>Recommended</h5>
							<ul class="sap">
								<!-- True if its not just a text -->
								<c:if
									test="${fn:length(training.prerequisites.recommended[0]) gt 0}">
									<c:if
										test="${fn:length(training.prerequisites.recommended[0].requirement) eq 2}">
										<c:forEach items="${training.prerequisites.essential}"
											var="rec">
											<li><a href="/trainings/${rec.requirement.url_text}">${rec.requirement.url_text}</a></li>
										</c:forEach>
									</c:if>
									<c:if
										test="${training.prerequisites.recommended[0].requirement.class.simpleName == 'String'}">
										<c:forEach items="${training.prerequisites.recommended}"
											var="rec">
											<li>${rec.requirement}"</li>
										</c:forEach>
									</c:if>
								</c:if>
								<c:if
									test="${fn:length(training.prerequisites.recommended[0]) eq 0}">
										Empty
								</c:if>
							</ul>
						</div>

						<div class="span6 col-md-6">
							<h4>Cours basés sur les versions des logiciels</h4>
							<ul class="sap">
							<c:forEach items="${training.release}" var="release">
								<li>${release}</li>
								</c:forEach>
							</ul>
						</div>
						<div class="span6 col-md-6">
							<h4>Contenu</h4>
							<ul class="sap">
								<c:forEach items="${training.content}" var="content">
									<li>${content.key}</li>
									<c:if test="${fn:length(content.value) gt 0}">
										<ul>
											<c:forEach items="${content.value}" var="value">
											<li>${value}</li>
										</c:forEach>
										</ul>
									</c:if>
								</c:forEach>
							</ul>
						</div>
						<div class="span6 col-md-6">
							<h4>Informations additionnelles</h4>
						</div>

					</div>
				</div>
				<div class="jumbotron col-md-3">
					<div class="container">
						<h2>Related Curricula</h2>
						<ul class="sap">
							<c:forEach items="${training.relatedCurricula}" var="related"
								varStatus="loop">
								<li><a href="${related}">${loop.index}</a></li>
							</c:forEach>
							</td>
						</ul>
					</div>
				</div>

			</c:if>
		</div>
	</div>
</div>
</div>
<jsp:include page="/include/footer.jsp" />