<jsp:include page="/include/header.jsp" />

<div class="container">
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
								placeholder="${training.name}" />
						</div>
						<div class="form-group">
							<label for="level">Niveau de la formation</label> <select
								type="text" class="form-control level " name="level" id="level">
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
							<label for="price">Prix</label> <input type="number"
								class="form-control" name="price" id="price"
								placeholder="${training.price}" required="required" />
						</div>
						<div class="form-group">
							<label for="price">Prix via LMT</label> <input type="number"
								class="form-control" name="priceLMT" id="priceLMT"
								placeholder="${training.priceLMT}" required="required" />
						</div>
						<div class="form-group">
							<label for="date.startDate">Début de la formation</label> <input
								type="date" class="form-control" name="date.startDate"
								id="date.startDate" placeholder="${training.startDate}" />
						</div>
						<div class="form-group">
							<label for="date.endDate">Fin de la formation</label> <input
								type="date" class="form-control" name="date.endDate"
								id="date.endDate" placeholder="${training.endDate}" />
						</div>
						<div class="form-group">
							<label for="level">Difficulté </label>
							<div class="ratingstars" name="level" id="level"></div>
						</div>
						<div class="form-group">
							<label for="description">Description</label> <input type="text"
								class="form-control" name="description" id="description"
								placeholder="${training.description}" />
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
$("#level option[value=${training.level}]").attr("selected","selected");
$( "#level option:selected" ).each(function() {
	$('#level').addClass(" level-${training.level}")
});
$( "#level" ).change(function () {
 $( "#level option:selected" ).each(function() {
	 $('#level').attr('class',
	           function(i, c){
	              return c.replace(/(^|\s)level-\S+/g, ' level-'+$(this).val() );
	           });
  });
})
</script>

<jsp:include page="/include/footer.jsp" />