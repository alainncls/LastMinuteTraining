<div class="row">
    <div class="col-sm-12">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Filtre de recherche</h3>
            </div>
            <div class="panel-body">
                <%-- <pre>${debug}</pre> --%>
                <form role="form" method="post">
                    <div class="form-group">
                        <label for="inputName">Nom</label> <input type="text"
                                                                  class="form-control" id="inputName" name="inputName"/>
                    </div>
                    <div class="form-group">
                        <label for="inputPrereq">Pr�requis</label> <select multiple
                                                                           class="form-control chosen-select"
                                                                           id="inputPrereq"
                                                                           name="inputPrereq[]">
                        <c:forEach items="${prerequis}" var="prerequis">
                            <option value="${prerequis.id}" selected="${prerequis.selected}">${prerequis.name}</option>
                        </c:forEach>
                    </select>
                    </div>
                    <div class="form-group">
                        <label for="inputStart">Date D�but</label> <input type="date"
                                                                          class="form-control" id="inputStart"
                                                                          name="inputStart"/>
                    </div>
                    <div class="form-group">
                        <label for="inputEnd">Date Fin</label> <input type="date"
                                                                      class="form-control" id="inputEnd"
                                                                      name="inputEnd"/>
                    </div>
                    <div class="form-group">
                        <label for="inputPriceLMT">Prix LMT</label> <input type="number"
                                                                           class="form-control" id="inputPriceLMT"
                                                                           name="inputPriceLMT"/>
                    </div>
                    <div class="form-group">
                        <label for="inputDifficulty">Difficulty</label>

                        <div id="stars" class="starrr"></div>
                        <input type="hidden" class="form-control" id="count"
                               name="inputDifficulty"/>
                    </div>
                    <div class="form-group">
                        <label for="inputVendor">Organisme Formateur</label> <select
                            multiple class="form-control chosen-select" id="inputVendor"
                            name="inputVendor[]">
                        <c:forEach items="${vendors}" var="vendor">
                            <option value="${vendor.id}" selected="${vendor.selected}">${vendor.name}</option>
                        </c:forEach>
                    </select>
                    </div>
                    <div>
                        <input type="submit" class="btn btn-primary" name="search"
                               value="Rechercher"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%-- 	<div class="col-sm-9">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Resultats de la recherche</h3>
            </div>
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prix</th>
                            <th>Prix LMT</th>
                            <th>Date</th>
                            <th>Difficult&eacute;</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${formations}" var="formation">
                            <tr>
                                <td><a href="addformation?id=${formation.id}">${formation.name}</a></td>
                                <td>${formation.prix}</td>
                                <td>${formation.prixReduc}</td>
                                <td>${formation.date_debut}</td>
                                <td>${formation.niveau}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div> --%>
</div>
