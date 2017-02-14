package br.com.fiap.teste;

import br.com.fiap.config.PropertySingleton;

public class Teste {

	public static void main(String[] args) {
		//Recuperar uma das propriedades do arquivo
		
		String user = PropertySingleton.getInstance().getProperty("usuario");
		
		String url = PropertySingleton.getInstance().getProperty("url");
		
		System.out.println("Seu usuário é: "+user +"\t"+url);

	}

}
