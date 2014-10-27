<jsp:include page="/include/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>

<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="panel-title">Ajouter une training</h1>
                </div>
            </div>
        </div>

        <div class="panel-body">
            <div class="row">
                <div class="col-md-4">
                    <form role="form" action="addTraining" method="POST">
                        <div class="form-group">
                            <label for="name">Intitul&eacute; de la formation</label> <input
                                type="text" class="form-control" name="name" id="name"
                                placeholder="Intitul&eacute; de la fromation"/>
                        </div>
                        <div class="form-group">
                            <label for="introduced">Prix</label> <input type="number"
                                                                        class="form-control" name="price" id="price"
                                                                        placeholder="Prix"
                                                                        required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="introduced">Prix via LMT</label> <input type="number"
                                                                                class="form-control" name="priceLMT"
                                                                                id="priceLMT"
                                                                                placeholder="Prix LMT"
                                                                                required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="name">D&eacute;but de la formation</label> <input
                                type="date" class="form-control" name="startDate" id="startDate"/>
                        </div>
                        <div class="form-group">
                            <label for="name">Fin de la formation</label> <input type="date"
                                                                                 class="form-control" name="endDate"
                                                                                 id="endDate"/>
                        </div>
                        <div class="form-group">
                            <label for="difficulty">Difficult&eacute;e</label> <input type="number"
                                                                              class="rating-stars" name="difficulty"
                                                                              id="difficulty"/>
                        </div>
                        <div class="form-group">
                            <label for="name">Description</label> <input type="text"
                                                                         class="form-control" name="description"
                                                                         id="description"/>
                        </div>

                        <div class="actions">
                            <button type="submit" class="btn btn-success">Envoyer</button>
                            <a href="home" class="btn btn-danger">Annuler</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/include/footer.jsp"/>