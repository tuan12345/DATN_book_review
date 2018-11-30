<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url value="/assets/js/user-script.js" var="userScript" />
<form id="reviewChart">
	<div class="form-group">
		<label class="control-label col-lg-2"><b>Review Date</b><span
			class="required">*</span> </label>
		<div class="col-lg-8">
			<input class="form-control" id="reviewDate" name="reviewDate"
				type="date" required />
		</div>
		<div class="col-lg-2">
			<button type="submit" class="btn btn-success">Submit</button>
		</div>
	</div>
</form>
<p class="text-center" id ="chartMessager"></p>
<div id="chart"></div>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="${userScript}" type="text/javascript"></script>