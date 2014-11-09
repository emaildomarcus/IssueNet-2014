package com.issuenet.controller.businessObjects;

import com.issuenet.model.beans.UsuarioBean;
import com.issuenet.model.dao.LoginDAO;
import com.issuenet.utils.security.GerenciadorPassword;

public class LoginBO 
{
	private LoginDAO d = new LoginDAO();
	private UsuarioBean cadastrado = null ;
	
	public LoginBO(UsuarioBean usuarioBean) 
	{
		
	}

	public boolean validaLogin(UsuarioBean usuario) {
		// Criar exceptions para erros e sucessos. Para entar poder retornar
		// elas e melhorar a troca de mensagens no sistema, encapsulando nas
		// Exceptions as mensagens de erro ou sucesso e algum poss�vel objeto.
//		return new Exception("Usu�rio N�o validado");
		
		//marreta para teste
		return true;
	}

	private boolean validaNomeUsuario(UsuarioBean usuarioBean) {
		// Valida se a nome est� vazio ou nulo
		if (usuarioBean.getNome().toLowerCase() == "" || usuarioBean.getNome().isEmpty()) {
			System.out
					.println("[LoginBO][ValidaNomeUsuario] - O campo Nome n�o pode estar vazio ou nulo");
			return false;
		} else {
			// Valida se a senha est� dentro do tamanho padr�o 8 <= senha <= 16
			if (usuarioBean.getNome().length() > Integer.parseInt(System
					.getProperty("tamanhoMaxNomeUsuario"))
					|| usuarioBean.getNome().length() < Integer.parseInt(System
							.getProperty("tamanhoMinNomeUsuario"))) {
				System.out
						.println("[LoginBO][ValidaNomeUsuario] - Tamanho do nome deve estar entre "
								+ System.getProperty("tamanhoMinNomeUsuario")
								+ " ou "
								+ System.getProperty("tamanhoMaxNomeUsuario"));
				return false;
			}
			return true;
		}
	}

	private boolean validaSenha(UsuarioBean usuarioBean) {
		// Valida se a senha est� vazia ou nula
		if (usuarioBean.getSenha() == "" || usuarioBean.getSenha().isEmpty()) {
			System.out
					.println("[LoginBO][ValidaSenha] - O campo Senha n�o pode estar vazio ou nulo");
			return false;
		} else {
			if (usuarioBean.getSenha().length() > Integer.parseInt(System
					.getProperty("tamanhoMaxSenha"))
					|| usuarioBean.getNome().length() < Integer.parseInt(System
							.getProperty("tamanhoMinSenha"))) {
				System.out
						.println("[LoginBO][ValidaSenha] - Tamanho da senha deve estar entre "
								+ System.getProperty("tamanhoMinSenha")
								+ " ou "
								+ System.getProperty("tamanhoMaxSenha"));
			}
			return true;
		}
	}

	private String encriptSenha(String senha) {
		GerenciadorPassword password = new GerenciadorPassword();
		System.out.println("[LoginBO][encriptaSenha] - Encriptando senha : " + password.getSenhaEncriptada(senha));
		return password.getSenhaEncriptada(senha);
	}

	private boolean validaUsuario(UsuarioBean usuario) {
		if (!validaNomeUsuario(usuario)) 
		{
			System.out.println("[LoginBO][ValidaUsuario] - Falha ao validar nome do usu�rio");
			return false;
		}
		else if (!validaLogin(usuario)) 
		{
			System.out.println("[LoginBO][ValidaUsuario] - Falha ao validar login do usu�rio");
			return false;
		}
		else if (!validaSenha(usuario)) 
		{
			System.out.println("[LoginBO][ValidaUsuario] - Falha ao validar senha do usu�rio");
			return false;
		}
		System.out.println("[LoginBO][ValidaUsuario] - Valida��o do usu�rio realizada com sucesso");
		return true ;
	}
	
	public boolean autenticaUsuario(UsuarioBean usuario) 
	{
		System.out.println("[LoginBO][autenticaUsuario] - Iniciando autentica��o");
		if(!validaUsuario(usuario))
		{
			System.out.println("[LoginBO][autenticarUsuario] - Usu�rio ou senha inv�lidos.");
			return false;
		}
		else 
		{
			//Gera a senha encriptada para comparar com a senha encriptada que � gravada no banco
			usuario.setSenhaMD5(this.encriptSenha(usuario.getSenha()));
			
			LoginDAO dao = new LoginDAO();
			cadastrado = dao.pesquisa(usuario);
			
			// Caso login e senha encriptada sejam identicos ( informado e gravado no banco) ser� aberta sess�o no servlet
			if(usuario.getLogin().toLowerCase()==cadastrado.getLogin().toLowerCase() && usuario.getSenhaMD5()==cadastrado.getSenhaMD5())
			{
				return true;
			}
			if (cadastrado.getLogin()==""||cadastrado.getLogin()==null) 
			{
				System.out.println("[LoginBO][autenticarUsuario] - Usu�rio ou senha incorretos.");
			}
		}
		
		return false;
	}
	
	
}
