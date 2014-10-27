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
                        <th>name</th>
                        <th>avatar</th>
                        <th>mail</th>
                        <th>phone</th>
                        <th>margin</th>
                        <th>sub</th>
                        <th>address</th>
                        <th>town</th>
                        <th>cp</th>
                        <th>iban</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty vendors}">
                        <c:forEach items="${vendors}" var="vendor" varStatus="loop">
                            <tr>
                                <td>${loop.index+1}</td>
                                <td>${vendor.id}</td>
                                <td>${vendor.name}</td>
                                <td>${vendor.avatar}</td>
                                <td>${vendor.mail}</td>
                                <td>${vendor.phone}</td>
                                <td>${vendor.margin}</td>
                                <td>${vendor.sub}</td>
                                <td>${vendor.address}</td>
                                <td>${vendor.town}</td>
                                <td>${vendor.cp}</td>
                                <td>${vendor.iban}</td>
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