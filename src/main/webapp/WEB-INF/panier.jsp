<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-sm-8">
		<c:if test="${not empty sessionScope.cart.orders}">
		<c:forEach items="${sessionScope.cart.orders}" var="order" varStatus="loop">
		${order}
	</c:forEach>
</c:if>
</div>

</div>

<jsp:include page="/include/footer.jsp" />