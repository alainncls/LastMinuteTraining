<jsp:include page="/include/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <div class="col-sm-12">
        <h3>Passer par LastMinuteTraining.com, c'est s'assurer d'avoir
            les meilleurs prix du marché sur les meilleures formations ERP
            / SAP du moment</h3>
        <h4>Client&egrave;le satisfaite &agrave; 97%</h4>
    </div>
</div>
<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-primary">
            <div class="panel-heading">Les prochaines formations</div>
            <div class="table-responsive">
                <table class="table table-hover table-striped table-align">
                    <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prix</th>
                        <th>Prix LMT</th>
                        <th>Date</th>
                        <th>Durée</th>
                        <th>Difficulté</th>
                        <th>Places restantes</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty trainings}">
                        <c:forEach items="${trainings}" var="training" varStatus="loop">
                            <tr>
                                <td class="trainingName"><a href="404?id=${training.id}">${training.name}</a></td>
                                <td>${training.price}€</td>
                                <td>${training.priceLMT}€</td>
                                <td>${training.startDate}</td>
                                <td>${training.duration}jours</td>
                                <td><c:forEach begin="1" end="${training.difficulty}">
                                    <i class="fa fa-star"></i>
                                </c:forEach></td>
                                <td>${training.available}</td>
                                <td><a href="404" class="btn btn-warning btn-sm"><i
                                        class="fa fa-shopping-cart"></i> Acheter</a></td>
                                <td data-toggle="collapse" href="#col${loop.index}"><i
                                        class="fa fa-chevron-down"></i></td>
                            </tr>
                            <tr id="col${loop.index}" class="panel-collapse collapse">
                                <td colspan="8">${training.available}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <jsp:include page="/include/searchTraining.jsp"/>
    </div>
</div>
<jsp:include page="/include/footer.jsp"/>