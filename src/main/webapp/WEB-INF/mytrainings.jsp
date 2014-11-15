<jsp:include page="/include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Formations en cours de vente</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="post" id="userForm">
                    <table class="table table-hover table-align">
                        <thead>
                        <tr>
                            <th>Prix de vente</th>
                            <th>Date début</th>
                            <th>Durée</th>
                            <th>Difficulté</th>
                            <th>Places restantes</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty trainings}">
                            <c:forEach items="${trainings}" var="training" varStatus="loop">
                                <c:if test="${training.vendorId}==${currentUser.id}">
                                    <tr class="tr-dark">
                                            <%-- <td colspan="8" class="trainingName"><a
                                                href="404?id=${training.id}">${training.name}</a></td> --%>
                                        <td colspan="8" class="trainingName"><a
                                                href="/LastMinuteTraining/trainings/${training.id}" target="_blank">${training.name}</a></td>
                                        <td class="td-chevron"><i
                                                class="fa fa-chevron-down chevron-toggle pull-right"
                                                data-toggle="collapse" href="#col${loop.index}"></i></td>
                                    </tr>
                                    <tr id="col${loop.index}"
                                        class="panel-collapse collapse tr-light">
                                        <td colspan="9">${training.description}</td>
                                    </tr>
                                    <tr class="tr-light">
                                        <td>${training.priceLMT}€</td>
                                        <td>${training.date.startDate}</td>
                                        <td>${training.duration.count} <c:if test="${training.duration.unit == 'days'}">jours</c:if><c:if test="${training.duration.unit == 'day'}">jour</c:if><c:if test="${training.duration.unit != 'day' && training.duration.unit != 'days'}">${training.duration.unit}</c:if></td>
                                        <td><c:forEach begin="1" end="${training.level}">
                                            <i class="fa fa-star"></i>
                                        </c:forEach></td>
                                        <td>${training.available}</td>
                                        <td colspan="3"><a href="404"
                                                           class="btn btn-warning btn-sm pull-right"><i
                                                class="fa fa-shopping-cart"></i> Acheter</a></td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </c:if>
                        </tbody>
                    </table>

				</form>
			</div>
		</div>
	</div>

	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Mes anciennes formations</h3>
			</div>
			<div class="panel-body">OK, une idée comme ça hein !</div>
		</div>
	</div>
</div>

<jsp:include page="/include/footer.jsp" />