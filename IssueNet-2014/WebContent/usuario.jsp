<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css\page_layout.css" />
<script type="text/javascript" src="js/formValidation.js" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IssueNet-2014 - Usuário</title>
</head>
<body id="duascolunas" class="duascolunas-a">

	<div id="tudo">

		<div id="topo">
			<h1>
				<b class="dest">IssueNet </b> 2014
			</h1>
		</div>

		<div id="nav">
			<h2 class="dest">Menu</h2>

			<h3>Administração</h3>
			<ol>
				<li><a href="usuario.jsp">Usuários</a></li>
				<li><a href="tarefa.jsp">Tarefas</a></li>
				<li><a href="#">Critério de Avaliação</a></li>
			</ol>

			<h3>Categorias</h3>
			<ul>
				<li><a href="#">(X)HTML</a></li>
				<li><a href="#">Compêndio HTML</a></li>
				<li><a href="#">CSS</a></li>
				<li><a href="#">Especificações W3C</a></li>
				<li><a href="#">Mágicas</a></li>
				<li><a href="#">Pensamentos</a></li>
				<li><a href="#">Standards em gotas</a></li>
				<li><a href="#">Web Design</a></li>
			</ul>
		</div>

		<div id="principal">
			<h2>
				<b class="dest">Bem Vindo </b> Usuário
			</h2>
			<p>Dados de Usuário</p>
			<form name="dadosUsuario" method="post" action="/insereUsuario">
				<p>Id Usuario :</p>
				<input type="text" name="idUsuario" value="Id Usuário"
					onclick="limpaCampo()" />

				<p>Nome :</p>
				<input type="text" value="Nome do usuário" onclick="limpaCampo()" />

				<p>E-mail :</p>
				<input type="text" value="E-mail do usuário" onclick="limpaCampo()" />
				<p>
					<input type="reset" name="reset" value="Limpar"
						alt="Limpa os dados do formulário." /> <input type="submit"
						name="salvar" value="Salvar"
						alt="Envia os dados do usuário para aplicação gravar no banco de dados." />
			</form>
			<p class="linque">
				<a href="#">&laquo; Template anterior</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
					href="#">Tutorial</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="#">Pr&oacute;ximo
					template &raquo;</a>
			</p>

		</div>

		<div id="apoio">
			<h2 class="dest">Help</h2>

			<h3>Blogroll</h3>
			<ul>
				<li><a href="#">Blog do Z&eacute;</a></li>
				<li><a href="#">Viche</a></li>
				<li><a href="#">Sonhos...E Realidades</a></li>
			</ul>

			<h3>Links</h3>
			<ul>
				<li><a href="#">Site do Maujor</a></li>
				<li><a href="#">Firefox</a></li>
			</ul>

			<h3>Meta</h3>
			<ul>
				<li><a href="#">Login</a></li>
				<li><a href="#">XHTML V&aacute;lido</a></li>
				<li><a href="#">CSS V&aacute;lida</a></li>
				<li><a href="#">XFN</a></li>
				<li><a href="#">WordPress</a></li>
			</ul>
		</div>

		<div id="rodape">
			<p>
				<b class="dest">RODAP&Eacute;:</b> &copy; Blog do Maujor, todos os
				direitos reservados. Blog do Maujor is proudly powered by <a
					href="#">WordPress</a>.<br />Tema e script adaptados do tema
				redesenhado por <a href="#">Kaushal Sheth</a> e originalmente
				desenvolvido por <a href="#">Michael Martine</a>
			</p>

		</div>

	</div>
</body>
</html>