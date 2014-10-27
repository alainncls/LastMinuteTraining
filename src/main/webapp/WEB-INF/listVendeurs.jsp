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
                        <th>nom</th>
                        <th>avatar</th>
                        <th>mail</th>
                        <th>telephone</th>
                        <th>marge</th>
                        <th>abonnement</th>
                        <th>adresse</th>
                        <th>ville</th>
                        <th>codePostal</th>
                        <th>iban</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty vendors}">
                        <c:forEach items="${vendors}" var="vendor" varStatus="loop">
                            <tr>
                                <td>${loop.index+1}</td>
                                <td>${vendor.id}</td>
                                <td>${vendor.nom}</td>
                                <td>${vendor.avatar}</td>
                                <td>${vendor.mail}</td>
                                <td>${vendor.telephone}</td>
                                <td>${vendor.marge}</td>
                                <td>${vendor.abonnement}</td>
                                <td>${vendor.adresse}</td>
                                <td>${vendor.ville}</td>
                                <td>${vendor.codePostal}</td>
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