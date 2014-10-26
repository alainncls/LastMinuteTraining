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
                    <c:if test="${not empty vendeurs}">
                        <c:forEach items="${vendeurs}" var="vendeur" varStatus="loop">
                            <tr>
                                <td>${loop.index+1}</td>
                                <td>${vendeur.id}</td>
                                <td>${vendeur.nom}</td>
                                <td>${vendeur.avatar}</td>
                                <td>${vendeur.mail}</td>
                                <td>${vendeur.telephone}</td>
                                <td>${vendeur.marge}</td>
                                <td>${vendeur.abonnement}</td>
                                <td>${vendeur.adresse}</td>
                                <td>${vendeur.ville}</td>
                                <td>${vendeur.codePostal}</td>
                                <td>${vendeur.iban}</td>
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