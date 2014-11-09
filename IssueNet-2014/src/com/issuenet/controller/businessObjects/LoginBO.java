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
		// Exceptions as mensagens de erro ou sucesso e algum possível objeto.
//		return new Exception("Usuário Não validado");
		
		//marreta para teste
		return true;
	}

	private boolean validaNomeUsuario(UsuarioBean usuarioBean) {
		// Valida se a nome está vazio ou nulo
		if (usuarioBean.getNome().toLowerCase() == "" || usuarioBean.getNome().isEmpty()) {
			System.out
					.println("[LoginBO][ValidaNomeUsuario] - O campo Nome não pode estar vazio ou nulo");
			return false;
		} else {
			// Valida se a senha está dentro do tamanho padrão 8 <= senha <= 16
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
		// Valida se a senha está vazia ou nula
		if (usuarioBean.getSenha() == "" || usuarioBean.getSenha().isEmpty()) {
			System.out
					.println("[LoginBO][ValidaSenha] - O campo Senha não pode estar vazio ou nulo");
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
			System.out.println("[LoginBO][ValidaUsuario] - Falha ao validar nome do usuário");
			return false;
		}
		else if (!validaLogin(usuario)) 
		{
			System.out.println("[LoginBO][ValidaUsuario] - Falha ao validar login do usuário");
			return false;
		}
		else if (!validaSenha(usuario)) 
		{
			System.out.println("[LoginBO][ValidaUsuario] - Falha ao validar senha do usuário");
			return false;
		}
		System.out.println("[LoginBO][ValidaUsuario] - Validação do usuário realizada com sucesso");
		return true ;
	}
	
	public boolean autenticaUsuario(UsuarioBean usuario) 
	{
		System.out.println("[LoginBO][autenticaUsuario] - Iniciando autenticação");
		if(!validaUsuario(usuario))
		{
			System.out.println("[LoginBO][autenticarUsuario] - Usuário ou senha inválidos.");
			return false;
		}
		else 
		{
			//Gera a senha encriptada para comparar com a senha encriptada que é gravada no banco
			usuario.setSenhaMD5(this.encriptSenha(usuario.getSenha()));
			
			LoginDAO dao = new LoginDAO();
			cadastrado = dao.pesquisa(usuario);
			
			// Caso login e senha encriptada sejam identicos ( informado e gravado no banco) será aberta sessão no servlet
			if(usuario.getLogin().toLowerCase()==cadastrado.getLogin().toLowerCase() && usuario.getSenhaMD5()==cadastrado.getSenhaMD5())
			{
				return true;
			}
			if (cadastrado.getLogin()==""||cadastrado.getLogin()==null) 
			{
				System.out.println("[LoginBO][autenticarUsuario] - Usuário ou senha incorretos.");
			}
		}
		
		return false;
	}
	
	
}
