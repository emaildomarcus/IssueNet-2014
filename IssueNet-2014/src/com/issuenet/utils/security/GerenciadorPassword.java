package com.issuenet.utils.security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class GerenciadorPassword 
{
	private static MessageDigest md5 = null;
	
	public GerenciadorPassword() 
	{
		try 
		{
			Properties defaultProps = new Properties();
			FileInputStream in = new FileInputStream("login.properties");
			defaultProps.load(in);
			in.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("[GerenciadorPassword][Constructor] - Falha ao instanciar stream para acessar o arquivo password.properties.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[GerenciadorPassword][Constructor] - Não foi possivel carregar o conteúdo do arquivo password.properties.");
			e.printStackTrace();
		}
	}
	
	static {
		try {
			md5 = MessageDigest.getInstance(System
					.getProperty("algoritmoEncriptacao"));
		} catch (NoSuchAlgorithmException e) {
			System.out
					.println("[GerenciadorPassword][static] - Falha ao tentar obter instancia da classe "
							+ md5.getClass());
			e.printStackTrace();
		}

	}

	private char[] encriptaMD5(byte[] senha) {
		/*
		 * Leia mais em: Criptografia MD5
		 * http://www.devmedia.com.br/criptografia-md5/2944#ixzz3IRyhtjad
		 */
		char[] saida = new char[senha.length * 2];
		String hexString;
		for (int i = 0; i < senha.length; i++) {
			hexString = "00" + Integer.toHexString(senha[i]);
			hexString.toUpperCase().getChars(hexString.length() - 2,
					hexString.length(), saida, i * 2);
		}

		return saida;
	}
}
