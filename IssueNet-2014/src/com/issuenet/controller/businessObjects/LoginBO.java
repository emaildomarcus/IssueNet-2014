package com.issuenet.controller.businessObjects;

import com.issuenet.model.beans.UsuarioBean;

public class LoginBO {
	public LoginBO(UsuarioBean usuarioBean) {

	}

	public Exception validaLogin(UsuarioBean usuario) {
		// Criar exceptions para erros e sucessos. Para entar poder retornar
		// elas e melhorar a troca de mensagens no sistema, encapsulando nas
		// Exceptions as mensagens de erro ou sucesso e algum poss�vel objeto.
		return new Exception("Usu�rio N�o validado");
	}

	private boolean validaNomeUsuario(UsuarioBean usuarioBean) {
		// Valida se a nome est� vazio ou nulo
		if (usuarioBean.getNome() == "" || usuarioBean.getNome().isEmpty()) {
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

}
