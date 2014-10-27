<jsp:include page="/include/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <div class="col-sm-12">
        <div class="panel panel-primary">
            <div class="table-responsive">
                <table class="table table-hover table-striped table-align">
                    <thead>
                    <tr>
                        <th>index</th>
                        <th>id</th>
                        <th>duration</th>
                        <th>location</th>
                        <th>formationType</th>
                        <th>available</th>
                        <th>certification</th>
                        <th>category</th>
                        <th>sellerId</th>
                        <th>contact</th>
                        <th>summary</th>
                        <th>name</th>
                        <th>startDate</th>
                        <th>endDate</th>
                        <th>difficulty</th>
                        <th>price</th>
                        <th>priceLMT</th>
                        <th>description</th>
                        <th>prerequis</th>
                        <th>introduction</th>
                        <th>target</th>
                        <th>program</th>
                        <th>objectives</th>
                        <th>activities</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty trainings}">
                        <c:forEach items="${trainings}" var="training" varStatus="loop">
                            <tr>
                                <td>${loop.index+1}</td>
                                <td>${training.id}</td>
                                <td>${training.duration}</td>
                                <td>${training.location}</td>
                                <td>${training.trainingType}</td>
                                <td>${training.available}</td>
                                <td>${training.certification}</td>
                                <td>${training.category}</td>
                                <td>${training.sellerId}</td>
                                <td>${training.contact}</td>
                                <td>${training.summary}</td>
                                <td>${training.name}</td>
                                <td>${training.startDate}</td>
                                <td>${training.endDate}</td>
                                <td>${training.difficulty}</td>
                                <td>${training.price}</td>
                                <td>${training.priceLMT}</td>
                                <td>${training.description}</td>
                                <td>${training.prerequis}</td>
                                <td>${training.introduction}</td>
                                <td>${training.target}</td>
                                <td>${training.program}</td>
                                <td>${training.objectives}</td>
                                <td>${training.activities}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/include/footer.jsp"/>