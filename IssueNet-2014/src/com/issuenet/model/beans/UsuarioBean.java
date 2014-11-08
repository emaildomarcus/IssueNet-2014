package com.issuenet.model.beans;

public class UsuarioBean 
{
	private Long idUsuario 		= 0l	;
	private String nome 		= ""	;
	private String login 		= "" 	;
	private String senha 		= "" 	;
	private String senhaMD5 	= "" 	;
	
	public Long getIdUsuario() 
	{
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) 
	{
		this.idUsuario = idUsuario;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public void setLogin(String login) 
	{
		this.login =login;		
	}
	
	public String getLogin() 
	{
		return login;
	}

	public void setSenha(String passwd) 
	{
		this.senha =passwd;
	}
	public String getSenha() {
		return senha;
	}
	public String getSenhaMD5() 
	{
		return senhaMD5;
	}
	public void setSenhaMD5(String senhaMD5) 
	{
		this.senhaMD5 = senhaMD5;
	}
}
