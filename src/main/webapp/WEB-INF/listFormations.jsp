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
                    <c:if test="${not empty formations}">
                        <c:forEach items="${formations}" var="formation" varStatus="loop">
                            <tr>
                                <td>${loop.index+1}</td>
                                <td>${formation.id}</td>
                                <td>${formation.duration}</td>
                                <td>${formation.location}</td>
                                <td>${formation.formationType}</td>
                                <td>${formation.available}</td>
                                <td>${formation.certification}</td>
                                <td>${formation.category}</td>
                                <td>${formation.sellerId}</td>
                                <td>${formation.contact}</td>
                                <td>${formation.summary}</td>
                                <td>${formation.name}</td>
                                <td>${formation.startDate}</td>
                                <td>${formation.endDate}</td>
                                <td>${formation.difficulty}</td>
                                <td>${formation.price}</td>
                                <td>${formation.priceLMT}</td>
                                <td>${formation.description}</td>
                                <td>${formation.prerequis}</td>
                                <td>${formation.introduction}</td>
                                <td>${formation.target}</td>
                                <td>${formation.program}</td>
                                <td>${formation.objectives}</td>
                                <td>${formation.activities}</td>
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