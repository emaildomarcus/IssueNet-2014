package com.issuenet.controller.businessObjects;

import com.issuenet.model.beans.UsuarioBean;

public class LoginBO 
{
	public LoginBO(UsuarioBean usuarioBean) 
	{
		
	}
	
	private boolean validaNomeUsuario(UsuarioBean usuarioBean) 
	{
		if (usuarioBean.getNome()=="" || usuarioBean.getNome().isEmpty()) 
		{
			return false;
		}
		else 
		{
			if (usuarioBean.getNome().length() > Integer.parseInt(System.getProperty("tamanhoMaxPassword"))) 
			{
				System.out.println("[LoginBO][ValidaNomeUsuario]");
			}
			return true;
		}
	}
	private boolean validaSenha(UsuarioBean usuarioBean) 
	{
		if (usuarioBean.getSenha()=="" || usuarioBean.getSenha().isEmpty()) 
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
}
