<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="row">
	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Informations générales</h3>
			</div>
			<div class="panel-body">
				<form role="form" method="POST" id="trainingForm">
					<div class="form-group">
						<label for="name">${training.name}</label> <input type="text"
							class="form-control" name="name" id="name"
							value="${training.name}" />
					</div>
					<div class="form-group">
						<label for="price">Prix</label> <input type="number"
							class="form-control" name="price" id="price"
							value="${training.price}" required="required" />
					</div>
					<div class="form-group">
						<label for="priceLMT">Prix via LMT (temporaire)</label> <input
							type="number" class="form-control" name="priceLMT" id="priceLMT"
							value="${training.priceLMT}" placeholder="400€"
							required="required" />
					</div>
					<div class="form-group">
						<label for="level">Niveau de la formation</label> <select
							type="text" class="form-control level " name="level" id="level"
							value="${training.level}">
							<option class="level level-1" value="1">Overview</option>
							<option class="level level-2" value="2">Foundation</option>
							<option class="level level-3" value="3">Detailed</option>
							<option class="level level-4" value="4">Delta Knowledge</option>
							<option class="level level-5" value="5">Consultant
								Academy</option>
							<option class="level level-6" value="6">Certification</option>
							<option class="level level-9" value="9">Grouped Offering</option>

						</select>
					</div>
					<div class="form-group">
						<label for="difficulty">Difficulté </label>
						<div class="ratingstars" name="difficulty" id="difficulty"
							value="${training.level}"></div>
					</div>
					<div class="form-group">
						<label for="summary">Résumé</label> <input type="text"
							class="form-control" name="summary" id="summary"
							value="${training.description}" />
					</div>
					<div class="form-group">
						<label for="category">Catégorie</label> <input type="text"
							class="form-control" name="category" id="category"
							value="${training.solution} }" required="required" />
					</div>
					<div class="actions">
						<button type="submit" class="btn btn-success">Envoyer</button>
						<a href="home" class="btn btn-danger">Annuler</a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Informations pratiques</h3>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label for="date.startDate">Début de la formation</label> <input
						type="date" class="form-control" name="startDate" id="startDate"
						required="required" form="trainingForm" />
				</div>
				<div class="form-group">
					<label for="date.endDate">Fin de la formation</label> <input
						type="date" class="form-control" name="endDate" id="endDate"
						required="required" form="trainingForm" />
				</div>
				<div class="form-group">
					<label for="language">Langue</label> <input type="text"
						class="form-control" name="language" id="language"
						required="required" form="trainingForm"
						value="${training.language}" />
				</div>
				<div class="form-group" id="pasteLang">
					<div class="form-group">
						<label for="location">Lieux de la formation</label> <input
							type="text" class="form-control" name="location" id="location"
							required="required" form="trainingForm"
							value="${training.location}" />
					</div>
					<div class="form-group">
						<label for="method">Type d'enseignement</label> <input type="text"
							class="form-control" name="method" id="method"
							placeholder="En classe, e-learning, ..." form="trainingForm"
							value="${training.method}" />
					</div>
					<div class="actions">
						<button type="submit" class="btn btn-success" form="trainingForm">Envoyer</button>
						<a href="home" class="btn btn-danger">Annuler</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Informations complémentaires</h3>
				</div>
				<div class="panel-body">
					<div class="form-group">
						<label for="target">Utilisateurs cibles</label>
						<c:forEach items="${training.audience}" var="audience"
							varStatus="loop">
							<div class="form-group" id="divaudience${loop.index}">
								<div class="row">
									<div class="col-md-10">
										<input type="text" class="form-control "
											name="audience[${loop.index}]" id="audience${loop.index}"
											value="${audience}" form="trainingForm">
									</div>
									<div class="col-sm-1">
										<button id="${loop.index}" type="button"
											onclick="suppr(this.id,'audience')" class="btn btn-danger">
											<span class="fa fa-times"></span>
										</button>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="form-group" id="pasteTarget">
							<span class="input-group-btn">
								<button id="addTarget" type="button"
									onclick="addLine('audience','pasteTarget')"
									class="btn btn-info btn-sm">Ajouter une cible</button>
							</span>
						</div>
						<div class="form-group">
							<label for="notes">Notes</label> <input type="text"
								class="form-control" name="notes[0]" id="notes0"
								placeholder="La certification n'est disponible qu'en anglais"
								form="trainingForm" />
						</div>
						<div class="form-group" id="pasteNotes">
							<span class="input-group-btn">
								<button id="addNotes" type="button"
									onclick="addLine('notes','pasteNotes')"
									class="btn btn-info btn-sm">Ajouter une note</button>
							</span>
						</div>
						<div class="form-group">
							<label for="url">Lien de la formation</label> <input type="text"
								class="form-control" name="url" id="url" value="${training.url}"
								form="trainingForm" />
						</div>
						<div class="form-group">
							<label for="solution">Logiciel(s)</label> <input type="text"
								class="form-control" name="solution" id="solution"
								form="trainingForm" value="${training.solution}" />
						</div>
						<div class="form-group">
							<label for="release">Version du logiciel</label>
							<c:forEach items="${training.release}" var="release"
								varStatus="loop">

								<div class="form-group" id="divrelease${loop.index}">
									<div class="row">
										<div class="col-md-10">
											<input type="text" class="form-control "
												name="release[${loop.index}]" id="release${loop.index}"
												value="${release}" form="trainingForm">
										</div>
										<div class="col-sm-1">
											<button id="${loop.index}" type="button"
												onclick="suppr(this.id,'release')" class="btn btn-danger">
												<span class="fa fa-times"></span>
											</button>
										</div>
									</div>
								</div>
							</c:forEach>
							<div class="form-group" id="pasteRelease">

								<span class="input-group-btn">
									<button id="addRelease" type="button"
										onclick="addLine('release','pasteRelease')"
										class="btn btn-info btn-sm">Ajouter une version</button>
								</span>
							</div>
							<div class="form-group">
								<label for="description">Description</label> <input type="text"
									class="form-control" name="description" id="description"
									form="trainingForm" value="${training.description}" />
							</div>
							<div class="form-group">
								<label>Curricula</label>
								<c:forEach items="${training.relatedCurricula}" var="related"
									varStatus="loop">
									<div class="row col-md-12">
										<div class="form-group" id="divrelated${loop.index}">
											<input type="text" class="form-control"
												name="relateds[${loop.index}]" id="related0"
												required="required" form="trainingForm"
												style="width: 45%;!important"
												value="${training.academys[loop.index]}" /> <input
												type="text" class="form-control col-md-5" name="academys[0]"
												id="academy0" required="required"
												style="width: 45%;!important" form="trainingForm"
												value="${related}" />
											<div class="col-sm-1">
												<button id="${loop.index}" type="button"
													onclick="supprDouble(this.id,'pasteRelated');$(this).remove();"
													class="btn btn-danger">
													<span class="fa fa-times"></span>
												</button>
											</div>
										</div>
									</div>
								</c:forEach>
								<div class="form-group" id="pasteRelated">
									<span class="input-group-btn">
										<button id="addRelated" type="button"
											onclick="addDouble('related', 'pasteRelated')"
											class="btn btn-info btn-sm">Ajouter un curriculum</button>
									</span>
								</div>

								<div class="form-group" style="display: inline-block;">
									<label for="description">Contenu</label><br> <span
										id="addBig" class="button fa fa-side fa-plus">Ajouter
										une partie</span><br> <br>
									<c:forEach items="${training.content}" var="content"
										varStatus="loop">

										<input type="text" class="form-control" value="${content.key}"></input>
										<span class='delBig fa fa-side fa-trash'></span>
										<ul>
											<span id="addSmall-${loop.index}"
												class="button fa fa-side fa-plus small ">Ajouter une
												sous-partie</span>
											<c:if test="${fn:length(content.value) gt 0}">


												<c:forEach items="${content.value}" var="value">
													<input type="text" class=" form-control col-md-10"
														value="${value}"></input>
													<span class=' col-md-1 delSmall fa fa-side fa-trash'></span>
												</c:forEach>
											</c:if>
										</ul>
									</c:forEach>
								</div>

								<div class="actions">
									<button type="submit" class="btn btn-success"
										form="trainingForm">Envoyer</button>
									<a href="home" class="btn btn-danger">Annuler</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<script>
					function addLine(name, divName) {
						var counter = $("[id^='" + divName + "']").length;
						var fullName = 'div' + name + counter;
						var newRow2 = '<div class="form-group" id="'+fullName+'">'
								+ '<div class="row">'
								+ '<div class="col-md-10">'
								+ '<input type="text" class="form-control " name="'+name+'['+counter+']" id="'+name+counter+'" form="trainingForm"/>'
								+ '</div>'
								+ '<div class="col-sm-1">'
								+ '<button id="'
								+ counter
								+ '" type="button" onclick="suppr(this.id,\''
								+ name
								+ '\')" class="btn btn-danger"><span class="fa fa-times"></span></button>'
								+ '</div>'
						'</div>' + '</div>';
						$('#' + divName + '').before(newRow2);
					}
				</script>
				<script>
					function suppr(nb, name) {

						//test = id du div row
						var test = $('#' + name + nb).parents('div').parents(
								'div').parents('div').attr('id');
						console.log(nb + name);
						var el = document.getElementById(test);

						el.parentNode.removeChild(el);
					}
				</script>
				<script>
					$("#level option[value=${training.level}]").attr(
							"selected", "selected");
					$("#level option:selected").each(function() {
						$('#level').addClass(" level-${training.level}")
					});
					$("#level")
							.change(
									function() {
										$("#level option:selected")
												.each(
														function() {
															$('#level')
																	.attr(
																			'class',
																			function(
																					i,
																					c) {
																				return c
																						.replace(
																								/(^|\s)level-\S+/g,
																								' level-'
																										+ $(
																												this)
																												.val());
																			});
														});
									});
					function adjustHeight(el) {
						el.style.height = (el.scrollHeight > el.clientHeight) ? (el.scrollHeight)
								+ "px"
								: "60px";
						console.log(el);
					}
				</script>
				<script>
					function addDouble(name, divName) {
						console.log(name + divName);
						var counter = $("[id^='" + name + "']").length;
						console.log(counter);
						var fullName = 'div' + name + counter;
						var newRow2 = '<div class="row col-md-12"><div class="form-group" id="'+fullName+'">'
								+ '<input type="text" class="form-control " style="width:45%;" name="related['
								+ counter
								+ ']" id="related'
								+ counter
								+ '" form="trainingForm" placeholder="Academie"/>'
								+ '<input type="text" class="form-control " style="width:45%;" name="academy['
								+ counter
								+ ']" id="academy'
								+ counter
								+ '" form="trainingForm"/ placeholder="URL">'
								+ '</div>'
								+ '<div class="col-sm-1">'
								+ '<button id="'
								+ counter
								+ '" type="button" onclick="supprDouble(this.id,\''
								+ "related"
								+ '\');$(this).remove();" class="btn btn-danger"><span class="fa fa-times"></span></button>'
						'</div>' + '</div></div>';
						$('#' + divName + '').before(newRow2);
					}
				</script>
				<script>
					function supprDouble(id) {
						$("#divrelated" + id).parent().remove();
						$("#divrelated" + id).remove();
					}
				</script>
				<script type="text/javascript">
					addSmall();
					$("#addBig")
							.click(
									function() {
										count = $('ul button').size();
										after = "<br><input type='text' class='form-control col-sm-10'></input><span class='col-sm-1 delBig fa fa-side fa-trash'></span><ul><span id='addSmall-"
												+ count.toString()
												+ "' class='span fa fa-side fa-plus small'>Ajouter une sous-partie</span></ul>";
										$(this).after(after);
										$("[id^=addSmall]").unbind("click");
										addSmall();
										$(".delBig").click(function() {
											$(this).prev().remove();
											$(this).next().remove();
											$(this).remove();
										});
									});
					function addSmall() {
						$("[id^=addSmall]")
								.click(
										function(event) {
											a = this.id;
											$("#" + a)
													.after(
															"<input type='text' class='form-control col-md-10'><span class='col-md-2 delSmall fa fa-side fa-trash'></span>");
											$(".delSmall").click(function() {
												$(this).prev().remove();
												$(this).remove();
											});
										})
					};
				</script>

				<script type="text/javascript">
					$(".delSmall").click(function() {
						$(this).prev().remove();
						$(this).remove();
					});
				</script>
				<script type="text/javascript">
					$(".delBig").click(function() {
						$(this).prev().remove();
						$(this).next().remove();
						$(this).remove();
					});
				</script>
				<jsp:include page="/include/footer.jsp" />