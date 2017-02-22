package br.com.fiap.view;

import br.com.fiap.bo.CursoBOStub;
import br.com.fiap.bo.CursoBOStub.CalcularPS;
import br.com.fiap.bo.CursoBOStub.CalcularPSResponse;

public class ConsoleView {

	public static void main(String[] args) {
		
		try {
			CursoBOStub bo = new CursoBOStub();
			
			//Valores para enviar ao webservice
			CalcularPS valores = new CalcularPS();
			valores.setNac(5);
			valores.setAm(5);
			
			//Chama o webservice
			//O axis cria uma classe para 
			CalcularPSResponse response = bo.calcularPS(valores);
			
			//Recuperar o valor retornado pelo webservice
			double ps = response.get_return();
			
			System.out.println("Nota necessária na PS: " + ps);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
