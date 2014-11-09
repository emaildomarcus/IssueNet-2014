package com.issuenet.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.issuenet.controller.businessObjects.LoginBO;
import com.issuenet.model.beans.UsuarioBean;

/**
 * Servlet implementation class loginSrv
 */
/*@WebServlet(description = "servletResponsavel pela autenticação de um usuário", urlPatterns = { "/login" })*/
public class LoginSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UsuarioBean usuario = new UsuarioBean();
		
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("passwd"));
/*		System.out.println(request.getParameterNames().nextElement() + "\n");*/
		
		//Marreta para teste
		usuario.setIdUsuario((long) 1);
		usuario.setNome("Rodrigo Moreira Martins");
		
		LoginBO bo = new LoginBO(usuario);
		
		if(bo.autenticaUsuario(usuario))
		{
			System.out.println("[LoginSrv][doPost] - Usuário autenticado com sucesso.");
		}
		else 
		{
			System.out.println("[LoginSrv][doPost] - Usuário não foi autenticado com sucesso. Por favor tente novamente.");
		}
	
		System.out.println("Login : " + usuario.getLogin() +" \nPassword : " + usuario.getSenha());
	}

}
