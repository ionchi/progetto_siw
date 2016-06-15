<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="en" ><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Fondamentale il viewport per bootstrap (essendo un framework) -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<!-- Bootstrap -->
<link href="<c:url value='/resources/css/bootstrap.min.css' />"
	rel="stylesheet" media="screen">
<link href="<c:url value='/resources/css/main.css' />" rel="stylesheet"
	media="screen">
<!-- Modernizr -->
<script src="<c:url value='/resources/js/modernizr.js' />"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- respond.js per IE8 -->
<!--[if lt IE 9]>
	<script src="<c:url value='/resources/js/respond.min.js' />"></script>
    <![endif]-->
</head>
<header>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar top-bar"></span> <span class="icon-bar middle-bar"></span>
					<span class="icon-bar bottom-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}">Progetto
					SIW</a>
			</div>
			<div id="navbar"
				class="collapse navbar-collapse navbar-responsive-collapse">
				<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/about">About</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a
						href="${pageContext.request.contextPath}/default">Area
							personale <span class="sr-only"></span>
					</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<!--/.container-fluid -->
	</nav>
</header>

<body onload='document.loginForm.username.focus();'>
	<div class="container content">
		<div class="form">
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="alert alert-info">${msg}</div>
			</c:if>
			<form role="form" name="loginForm"
				action="<c:url value='j_spring_security_check' />" method="POST">
				<h2 style="text-align: center;">
					Esegui il login <small>"area riservata"</small>
				</h2>
				<hr class="colorgraph">
				<div class="form-group col-xs-12 col-md-8 col-md-offset-2">
					<input type="text" name='username' id="username"
						class="form-control input-lg" placeholder="Username" tabindex="1">
				</div>
				<div class="form-group col-xs-12 col-md-8 col-md-offset-2">
					<input type="password" name='password' id="password"
						class="form-control input-lg" placeholder="Password" tabindex="5">
				</div>
				<div class="row">
					<div class="col-xs-12 col-md-8 col-md-offset-2">
						<input class="btn btn-success btn-block btn-lg"
							name="
							submit" type="submit" value="Login" />
					</div>
				</div>
			</form>
		</div>
	</div>
	<footer class="footer navbar-fixed-bottom">
		<div class="container">
			<p class="footer">Progetto per il corso di Sistemi Informativi
				sul Web a.a. 2015-2016</p>
			<p class="footer">Realizzato da: Ion Chiriac e Giuseppe Matera</p>
		</div>
	</footer>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<c:url value='/resources/js/jquery-1.9.1.min.js' />"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
</body>