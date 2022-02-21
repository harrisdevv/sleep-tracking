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
				<a href="#" class="navbar-brand"> Sleep Tracking
					App</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Sleep</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="<%=request.getContextPath()%>/logout"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container ${is_admin}">
			<h3 class="text-center">List of User</h3>
			<hr>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Username</th>
						<th>Password</th>
						<th>isAdmin</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Sleep sleep: sleeps) {  -->
					<c:forEach var="user" items="${listUser}">
						<tr>
							<td><c:out value="${user.firstName}" /></td>
							<td><c:out value="${user.lastName}" /></td>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.password}" /></td>
							<td><c:out value="${user.isAdmin}" /></td>

							<td><a href="editUser?id=<c:out value='${user.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteUser?id=<c:out value='${user.id}' />">Delete</a></td>
							<td><button (click)="updateUser(user.id)" class="btn btn-success">Update</button>
          						<button (click)="deleteUser(user.id)" class="btn btn-warning">Delete</button></td> -->
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>

		<div class="container">
			<h3 class="text-center">List of Sleep</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new"
					class="btn btn-success">Add Sleep</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Date</th>
						<th>Sleep Time</th>
						<th>Wakeup Time</th>
						<th>Sleep Duration (min)</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Sleep sleep: sleeps) {  -->
					<c:forEach var="sleep" items="${listSleep}">
						<tr>
							<td><c:out value="${sleep.date}" /></td>
							<td><c:out value="${sleep.sleepTime}" /></td>
							<td><c:out value="${sleep.wakeUpTime}" /></td>
							<td><c:out value="${sleep.sleepDuration}" /></td>
							<td><a href="edit?id=<c:out value='${sleep.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${sleep.id}' />">Delete</a></td>
							<td><button (click)="updateSleep(sleep.id)" class="btn btn-success">Update</button>
          						<button (click)="deleteSleep(sleep.id)" class="btn btn-warning">Delete</button></td> -->
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
