<jsp:include page="/include/header.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>

<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="panel-title">Ajouter un organisme de formation</h1>
                </div>
            </div>
        </div>

        <div class="panel-body">
            <div class="row">
                <div class="col-md-4">
                    <form name="vendorForm" role="form" action="addVendor" method="POST" onsubmit="return validateForm()">
                        <div class="form-group">
                            <label for="name">Nom de l'organisme</label> <input
                                type="text" class="form-control" name="name" id="name"
                                placeholder="Nom de l'organisme"/>
                        </div>
                        <div class="form-group">
                            <label for="avatar">Avatar</label> <input type="file"
                                                                      class="form-control" name="avatar" id="avatar"/>
                        </div>
                        <div class="form-group">
                            <label for="mail">Adresse mail</label> <input type="email"
                                                                          class="form-control" name="mail" id="mail"
                                                                          placeholder="exemple@epf.fr"
                                                                          required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="phone">Numéro de téléphone</label> <input
                                type="text" maxlength="10" class="form-control" name="phone" id="phone"
                                placeholder="xx xx xx xx xx" required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="address">Adresse</label> <input type="text"
                                                                        class="form-control" name="address" id="address"
                                                                        required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="cp">Code Postal</label> <input type="number" maxlength="5"
                                                                       class="form-control" name="cp" id="cp"
                                                                       required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="town">Ville</label> <input type="text"
                                                                   class="form-control" name="town" id="town"
                                                                   required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="margin">Marge</label> <input type="number"
                                                                    class="form-control" name="margin" id="margin"
                                                                    required="required"/>
                        </div>
                        <div class="form-group">
                            <label for="iban">IBAN</label> <input type="text" maxlength="34"
                                                                  class="form-control" name="iban" id="iban"
                                                                  required="required"/>
                        </div>
                        <div class="form-group">
                            <label>Abonnement</label><br>
                            <label class="radio-inline">
                                <input type="radio" name="sub" id="subY" value="Oui">Oui
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="sub" id="subN" value="Non" checked="true">Non
                            </label>
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