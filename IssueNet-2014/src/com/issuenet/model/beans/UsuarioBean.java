package com.issuenet.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="USUARIO")
public class UsuarioBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5326810486171577194L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_USUARIO",unique=true, updatable=false)
	private Long idUsuario 		= 0l	;
	
	@Column(name="NOME_USUARIO", nullable=false, updatable=true, length=120)
	private String nome 		= ""	;
	
	@Column(name="LOGIN", nullable=false, updatable=true, length=20)
	private String login 		= "" 	;
	
	@Transient
	private String senha 		= "" 	;
	
	@Column(name="SENHA", nullable=false, length=255)
//	@Password(methodName="MD5")
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
