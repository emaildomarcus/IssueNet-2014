<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html >
<!-- PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" -->
<html>

<!-- Bootstrap local core CSS -->
<!-- <link href="css/bootstrap.min.css" rel="stylesheet" />
Custom styles for this template
<link href="css/signin.css" rel="stylesheet" /> -->

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
<!-- <link href="/bootstrap/img/favicon.ico" rel="shortcut icon"> -->
<link href="icons/girasol_16x16.ico" rel="shortcut icon">
<link href="/bootstrap/img/apple-touch-icon.png" rel="apple-touch-icon">
<link href="/bootstrap/img/apple-touch-icon-72x72.png"
	rel="apple-touch-icon" sizes="72x72">
<link href="/bootstrap/img/apple-touch-icon-114x114.png"
	rel="apple-touch-icon" sizes="114x114">

<!-- CSS code from Bootply.com editor -->

<style type="text/css">
.modal-footer {
	border-top: 0px;
}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=application.getInitParameter("appName")%></title>
</head>
<body>

	<!--login modal-->
	<div id="loginModal" class="modal show" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h1 class="text-center">Issue Net 2014</h1>
					<h1 class="text-center">Login</h1>
				</div>
				<div class="modal-body">
					<form name="loginFrm" class="form col-md-12 center-block"><!-- method="post" action="login" -->
						<div class="form-group">
							<input name="login" type="text" class="form-control input-lg" placeholder="Email" maxlength="20">
						</div>
						<div class="form-group">
							<input name="passwd" type="password" class="form-control input-lg" placeholder="Password" maxlength="16">
						</div>
						<div class="form-group">
							<button type="submit" id="signIn" form="loginFrm" formmethod="post" formaction="login"
								class="btn btn-primary btn-lg btn-block" >Sign
								In</button>

							<span class="pull-right"><a href="novoUsuario.jsp">Register</a></span><span>
								<a href="#">Need help?</a>
							</span>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<div class="col-md-12">
						<button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type='text/javascript'
		src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type='text/javascript'
		src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

	<!-- JavaScript jQuery code from Bootply.com editor  -->

	<script type='text/javascript'>
		$(document).ready(function() {

		});
	</script>

	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');
		ga('create', 'UA-40413119-1', 'bootply.com');
		ga('send', 'pageview');
	</script>
	<!-- Verificar como fazer o envio dos campos do formulário para o servlet -->
	<script>
		function enviaForm() {
			var form = document.getElementById("loginFrm");
			alert(document.attributes.getNamedItem("login").nodeValue());
			alert(form.getAttribute("passwd"));
			form.submit();
		}
	</script>
</body>
</html>