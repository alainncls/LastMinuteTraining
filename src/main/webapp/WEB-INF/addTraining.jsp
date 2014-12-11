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
						<label for="name">Intitulé de la formation</label>
						<input type="text" class="form-control" name="name" id="name"
						placeholder="Intitulé de la fromation" />
					</div>
					<div class="form-group">
						<label for="price">Prix</label> <input type="number"
						class="form-control" name="price" id="price" placeholder="Prix"
						required="required" />
					</div>
					<div class="form-group">
						<label for="available">Nombre de places</label> <input type="number"
						class="form-control" name="available" id="available"
						required="required" />
					</div>
					<div class="form-group">
						<label for="level">Niveau de la formation</label> 
						<select
							type="text" class="form-control level" name="level" id="level">
							<option class="level level-1" value="1">Overview</option>
							<option class="level level-2" value="2">Foundation</option>
							<option class="level level-3" value="3">Detailed</option>
							<option class="level level-4" value="4">Delta Knowledge</option>
							<option class="level level-5" value="5">Consultant Academy</option>
							<option class="level level-6" value="6">Certification</option>
							<option class="level level-9" value="9">Grouped Offering</option>
						</select>
					</div>
					<div class="form-group">
						<label for="difficulty">Difficulté </label>
						<div class="ratingstars" name="difficulty" id="difficulty"></div>
					</div>
					<div class="form-group">
						<label for="summary">Résumé</label> <input type="text"
						class="form-control" name="summary" id="summary"
						/>
					</div>
					<div class="form-group">
						<label for="category">Catégorie</label> <input type="text"
						class="form-control" name="category" id="category" placeholder="SAP ERP, SAP NetWeaver, ..."
						required="required" />
					</div><br><br>
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
					type="date" class="form-control" name="date['startDate']" id="startDate" 
					required="required" form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="date.endDate">Fin de la formation</label> <input type="date"
					class="form-control" name="date['endDate']" id="endDate" 
					required="required" form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="duration">Durée</label> <input type="number"
					class="form-control input-sm" style="width:70%;" name="duration['count']" id="duration0" 
					required="required" form="trainingForm"/> 
					<select class="form-control input-sm" style="width:30%;" name="duration['unit']" id="duration1" form="trainingForm">
						<option value="heures">heures</option>
						<option value="jours">jours</option>
					</select>
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
				</div><br><br>
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
					<label for="target">Utilisateurs cibles</label> <input type="text"
					class="form-control" name="audience[0]" id="audience0"
					form="trainingForm"/>
				</div>
				<div class="form-group" id="pasteTarget">
                    <span class="input-group-btn">
                        <button id="addTarget" type="button" onclick="addLine('audience','pasteTarget')" class="btn btn-info btn-sm">Ajouter une cible</button>
                    </span>
                </div>
				<div class="form-group">
					<label for="notes">Notes</label> <input type="text"
					class="form-control" name="notes[0]" id="notes0"
					placeholder="La certification n'est disponible qu'en anglais" 
					form="trainingForm"/>
				</div>
				<div class="form-group" id="pasteNotes">
                    <span class="input-group-btn">
                        <button id="addNotes" type="button" onclick="addLine('notes','pasteNotes')" class="btn btn-info btn-sm">Ajouter une note</button>
                    </span>
                </div>
				<div class="form-group">
					<label for="url">Lien de la formation</label> <input type="text"
					class="form-control" name="url" id="url" placeholder="training.sap.com/course/lumira-classroom-014-fr-en"
					form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="solution">Logiciel(s)</label> <input type="text"
					class="form-control" name="solution[0]" id="solution0"
					form="trainingForm"/>
				</div>
				<div class="form-group" id="pasteSol">
                    <span class="input-group-btn">
                        <button id="addSolution" type="button" onclick="addLine('solution','pasteSol')" class="btn btn-info btn-sm">Ajouter un logiciel</button>
                    </span>
                </div>
				<div class="form-group">
					<label for="release">Version du logiciel</label> <input type="text"
					class="form-control" name="release" id="release"
					form="trainingForm"/>
				</div>
				<div class="form-group" id="pasteRelease">
                    <span class="input-group-btn">
                        <button id="addRelease" type="button" onclick="addLine('release','pasteRelease')" class="btn btn-info btn-sm">Ajouter une version</button>
                    </span>
                </div>
				<div class="form-group">
					<label for="description">Description</label> <input type="text"
					class="form-control" name="description" id="description" 
					form="trainingForm"/>
				</div>
				<div class="form-group">
					<label for="academys">Curriculum</label> 
					<div class="row col-md-12">
						<div class="form-group" id="divrelated0">
							<input type="text" class="form-control"
								name="relatedCurricula[0]" id="relatedCurricula0"
								form="trainingForm" placeholder="Nom"
								style="width: 45%;!important"/> 
							<input type="text" class="form-control col-md-5" 
							name="academys[0]" id="academy0" placeholder="URL"
							style="width: 45%;!important" form="trainingForm"
							value="${related}" />
						</div>
					</div>
				</div>
				<div class="form-group" id="pasteCuri">
                    <span class="input-group-btn">
                        <button id="addCurriculum" type="button" onclick="addLine('relatedCurricula', 'pasteCuri')" class="btn btn-info btn-sm">Ajouter un curriculum</button>
                    </span>
                </div>
                <div class="form-group" style="display: inline-block;">
					<label for="description">Contenu</label><br> 
					<span id="addBig" class="button fa fa-side fa-plus"> Ajouter une partie</span><br>
				</div>
				<div class="form-group">
					<label for="essential">Prérequis essentiels</label>
					<span id="addBig2" class="button fa fa-side fa-plus"> Ajouter un prérequis</span><br> 
					<input type="text" class="form-control" 
					name="prerequisites['essential']" id="essential" 
					form="trainingForm"/><br>
				</div>

				<div class="form-group">
					<label for="recommended">Prérequis recommandés</label>
					<span id="addBig3" class="button fa fa-side fa-plus"> Ajouter un prérequis</span><br> 
					<input type="text" class="form-control" 
					name="prerequisites['recommended']" id="recommended" 
					form="trainingForm"/><br>
				</div>
				<br><br>
				<div class="actions">
					<button type="submit" class="btn btn-success" form="trainingForm">Envoyer</button>
					<a href="home" class="btn btn-danger">Annuler</a>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	function addLine(name, divName){
		var counter = 1;
		var fullName = 'div'+name+counter;
		if (name=="relatedCurricula"){
			var newRow2 = '<div class="form-group" id="'+fullName+'">'+
			'<div class="row">'+
			'<div class="col-md-10">'+
			'<input type="text" class="form-control " name="'+name+'['+counter+']" id="'+name+counter+'" form="trainingForm"'+
			'style="width: 50%;!important"/><input type="text" class="form-control col-md-5" name="academys['+counter+']"'+
			'id="academy'+counter+'" style="width: 50%;!important" form="trainingForm"/>'+
			'</div>'+
			'<div class="col-sm-1">'+
			'<button id="'+counter+'" type="button" onclick="suppr(this.id,\''+name+'\')" class="btn btn-danger"><span class="fa fa-times"></span></button>'+
			'</div>'
			'</div>'+ 
			'</div>';
		}
		else{
			var newRow2 = '<div class="form-group" id="'+fullName+'">'+
			'<div class="row">'+
			'<div class="col-md-10">'+
			'<input type="text" class="form-control " name="'+name+'['+counter+']" id="'+name+counter+'" form="trainingForm"/>'+
			'</div>'+
			'<div class="col-sm-1">'+
			'<button id="'+counter+'" type="button" onclick="suppr(this.id,\''+name+'\')" class="btn btn-danger"><span class="fa fa-times"></span></button>'+
			'</div>'
			'</div>'+ 
			'</div>';
		}
		
		counter++;
		$('#'+divName+'').before(newRow2);
	}
</script>
<script>
	function suppr(nb, name){
		
    //test = id du div row
    var test = $('#'+name+nb).parents('div').parents('div').parents('div').attr('id');
    var el = document.getElementById(test);
    el.parentNode.removeChild(el);
}
</script>
<script>
	$("#level option:selected").each(function() {
		var e = document.getElementById("level");
		var strUser = e.options[e.selectedIndex].value;
		$('#level').addClass(" level-"+strUser+"")
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
<script>
	function supprDouble(id) {
		$("#divrelated" + id).parent().remove();
		$("#divrelated" + id).remove();
	}
</script>
<script type="text/javascript">
	addSmall();
	var index=0;
	var index2=0;
	$("#addBig")
	.click(
		function() {
			count = $('ul button').size();
			after = '<br><input type="text" class="form-control col-sm-10" form="trainingForm" name="content[\'partie'+index+'\']"></input><span class="col-sm-1 delBig fa fa-side fa-trash"></span><ul><span id="addSmall-"'
			+ count.toString()
			+ "' class='span fa fa-side fa-plus small'>Ajouter une sous-partie</span></ul><br><br>";
			$(this).after(after);index++;
			$("[id^=addSmall]").unbind("click");
			addSmall();
			$(".delBig").click(function() {
				$(this).prev().remove();
				$(this).next().remove();
				$(this).remove();
			});
		});
	
	$("#addBig2")
	.click(
		function() {
			count = $('ul button').size();
			after = '<br>'
					+'<input type="text" class="form-control" form="trainingForm"'
					+'name=\"prerequisites[\'essential\']\"></input>'
					+'<span class="col-sm-1 delBig fa fa-side fa-trash"></span><ul><br><br>';
			$(this).after(after);index++;
			$(".delBig").click(function() {
				$(this).prev().remove();
				$(this).next().remove();
				$(this).remove();
			});
		});
	
	$("#addBig3")
	.click(
		function() {
			count = $('ul button').size();
			after = '<br>'
					+'<input type="text" class="form-control" form="trainingForm"'
					+'name=\"prerequisites[\'recommended\']\"></input>'
					+'<span class="col-sm-1 delBig fa fa-side fa-trash"></span><ul><br><br>';
			$(this).after(after);index++;
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
					'<input type="text" class="form-control" form="trainingForm" name="content[\'sous-partie'+index2+'\']"><span class="col-md-2 delSmall fa fa-side fa-trash"></span>');
				index2++;$(".delSmall").click(function() {
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