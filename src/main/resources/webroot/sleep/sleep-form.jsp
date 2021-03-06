<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="#" class="navbar-brand">Sleep Tracking App</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Sleeps</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${sleep != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${sleep == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${sleep != null}">
            			Edit Sleep
            		</c:if>
						<c:if test="${sleep == null}">
            			Add New Sleep
            		</c:if>
					</h2>
				</caption>

				<c:if test="${sleep != null}">
					<input type="hidden" name="id" value="<c:out value='${sleep.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Date</label> <input type="date"
						value="<c:out value='${sleep.date}' />" class="form-control"
						name="date" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Sleep time (00:00:00)</label> <input type="text"
						value="<c:out value='${sleep.sleepTime}' />" class="form-control"
						name="sleep_time" required="required" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Wakeup time (00:00:00)</label> <input type="text"
						value="<c:out value='${sleep.wakeUpTime}' />" class="form-control"
						name="wakeup_time" required="required" minlength="5">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Sleep duration</label> <input type="text"
						value="<c:out value='${sleep.sleepDuration}' />" class="form-control"
						name="total_sleep_duration" required="required" minlength="1">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>
