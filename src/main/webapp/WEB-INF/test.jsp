<jsp:include page="/include/header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="container">

<div class="col-sm-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Informations pratiques</h3>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<label for="date.startDate">D�but de la formation</label> <input
					type="date" class="form-control" name="startDate" id="startDate" 
					required="required" form="trainingForm" value="11/11/2011"/>
				</div>
				<div class="form-group">
					<label for="date.endDate">Fin de la formation</label> <input type="date"
					class="form-control" name="endDate" id="endDate" 
					required="required" form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="language">Langue</label> <input type="text"
					class="form-control" name="language[0]" id="language0"
					required="required" form="trainingForm"/>
				</div>
				<div class="form-group" id="pasteLang">
                    <span class="input-group-btn">
                        <button id="addLang" type="button" onclick="addLine('language', 'pasteLang')" class="btn btn-info btn-sm">Ajouter une langue</button>
                    </span>
                </div>
				<div class="form-group">
					<label for="location">Lieux de la formation</label> <input type="text"
					class="form-control" name="location" id="location"
					required="required" form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="method">Type d'enseignement</label> <input type="text"
					class="form-control" name="method" id="method"
					placeholder="En classe, e-learning, ..." 
					form="trainingForm" />
				</div>
				<div class="actions">
					<button type="submit" class="btn btn-success" form="trainingForm">Envoyer</button>
					<a href="home" class="btn btn-danger">Annuler</a>
				</div>
			</div>
		</div>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<div class="row">
				<div class="col-md-12">
					<h1 class="panel-title">Modifier une formation</h1>
				</div>
			</div>
		</div>

		<div class="panel-body">
			<div class="row">
				<div class="col-md-4">
					<form role="form" action="editTraining" method="POST">
						<div class="form-group">
							<label for="name">Intitulé de la formation</label> <input
								type="text" class="form-control" name="name" id="name"
								placeholder="${training.name}" value="${training.name}" />
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
								<option class="level level-9" value="9">Grouped
									Offering</option>

							</select>
						</div>
						<div class="form-group">
							<label for="price">Prix</label> <input type="number"
								class="form-control" name="price" id="price"
								placeholder="${training.price}" value="${training.price}"
								required="required" />
						</div>
						<div class="form-group">
							<label for="price">Prix via LMT</label> <input type="number"
								class="form-control" name="priceLMT" id="priceLMT"
								placeholder="${training.priceLMT}" value="${training.priceLMT}"
								required="required" />
						</div>
						<div class="form-group">
							<label for="date.startDate">Début de la formation</label> <input
								type="date" class="form-control" name="date.startDate"
								id="date.startDate" placeholder="${training.startDate}"
								value="${training.startDate}" />
						</div>
						<div class="form-group">
							<label for="date.endDate">Fin de la formation</label> <input
								type="date" class="form-control" name="date.endDate"
								id="date.endDate" placeholder="${training.endDate}" />
						</div>
						<div class="form-group">
							<label for="description">Description</label>
							<textarea class="form-control" name="description"
								id="description" onkeyup="adjustHeight(this)">
								${training.description}
								</textarea>
						</div>
						<div class="form-group">
							<label for="description">Contenu</label><br> <span
								id="addBig" class="button fa fa-side fa-plus">Ajouter une
								partie</span><br> <br>
							<c:forEach items="${training.content}" var="content"
								varStatus="loop">

								<input type="text" class="" value="${content.key}"></input>
								<span class='delBig fa fa-side fa-trash'></span>
								<ul>
									<span id="addSmall-${loop.index}"
										class="button fa fa-side fa-plus small">Ajouter une
										sous-partie</span>
									<c:if test="${fn:length(content.value) gt 0}">


										<c:forEach items="${content.value}" var="value">
											<input type="text" class="col-md-10" value="${value}"></input>
											<span class=' col-md-1 delSmall fa fa-side fa-trash'></span>
										</c:forEach>
									</c:if>
								</ul>
							</c:forEach>
						</div>
						<div class="form-group">
							<label for="description">Cours basés sur les versions du
								logiciel:</label><br>
							<ul>
								<input class="col-md-10" type="text" value="" />
								<span class="addLogiciel col-md-1 fa fa-side fa-plus"></span>

								<c:forEach items="${training.release}" var="release">
									<input class="col-md-10" type="text" value="${release}" />
									<span class='delLogiciel col-md-1 fa fa-side fa-trash'></span>
								</c:forEach>
							</ul>
						</div>
						<div class="form-group">
							<label for="target">Utilisateurs cibles</label>
							<c:forEach items="${training.audience}" var="audience"
								varStatus="loop">
								<input type="text" class="form-control"
									name="audience[${loop.index}]" id="audience${loop.index}"
									form="trainingForm" value="${audience}" />
							</c:forEach>
						</div>
						<div class="form-group" id="pasteTarget">
							<span class="input-group-btn">
								<button id="addTarget" type="button"
									onclick="addLine('audience','pasteTarget')"
									class="btn btn-info btn-sm">Ajouter une cible</button>
							</span>
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
<script>
	$("#level option[value=${training.level}]").attr("selected", "selected");
	$("#level option:selected").each(function() {
		$('#level').addClass(" level-${training.level}")
	});
	$("#level").change(
			function() {
				$("#level option:selected").each(
						function() {
							$('#level').attr(
									'class',
									function(i, c) {
										return c.replace(/(^|\s)level-\S+/g,
												' level-' + $(this).val());
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

<script type="text/javascript">
	addSmall();
	$("#addBig")
			.click(
					function() {
						count = $('ul button').size();
						after = "<br><input type='text' class='col-sm-10'></input><span class='col-sm-1 delBig fa fa-side fa-trash'></span><ul><span id='addSmall-"
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
											"<input type='text' class='col-md-10'><span class='col-md-2 delSmall fa fa-side fa-trash'></span>");
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
<script type="text/javascript">
	$(".addLogiciel")
			.click(
					function() {
						$(this)
								.after(
										"<input class='col-md-10' type='text' value='''/><span class='delLogiciel col-md-1 fa fa-side fa-trash'></span>");
						$(".delLogiciel").click(function() {
							$(this).prev().remove();
							$(this).remove();
						});
					});
	$(".delLogiciel").click(function() {
		$(this).prev().remove();
		$(this).remove();
	});
</script>
<script type="text/javascript">
	$(".addPublic")
			.click(
					function() {
						$(this)
								.after(
										"<input class='col-md-10' type='text' value='''/><span class='delPublic col-md-1 fa fa-side fa-trash'></span>");
						$(".delPublic").click(function() {
							$(this).prev().remove();
							$(this).remove();
						});
					});
	$(".delPublic").click(function() {
		$(this).prev().remove();
		$(this).remove();
	});
</script>
<script>
	function addLine(name, divName) {
		var counter = 1;
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

		counter++;
		$('#' + divName + '').before(newRow2);
	}
</script>
<script>
	function suppr(nb, name) {

		//test = id du div row
		var test = $('#' + name + nb).parents('div').parents('div').parents(
				'div').attr('id');
		var el = document.getElementById(test);
		el.parentNode.removeChild(el);
	}
</script>
<script>
	$("#level option[value=${training.level}]").attr("selected", "selected");
	$("#level option:selected").each(function() {
		$('#level').addClass(" level-${training.level}")
	});
	$("#level").change(
			function() {
				$("#level option:selected").each(
						function() {
							$('#level').attr(
									'class',
									function(i, c) {
										return c.replace(/(^|\s)level-\S+/g,
												' level-' + $(this).val());
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
<jsp:include page="/include/footer.jsp" />