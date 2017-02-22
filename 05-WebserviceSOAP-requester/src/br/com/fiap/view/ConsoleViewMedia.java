package br.com.fiap.view;

import br.com.fiap.bo.CursoBOStub;
import br.com.fiap.bo.CursoBOStub.CalcularMedia;
import br.com.fiap.bo.CursoBOStub.CalcularMediaResponse;

public class ConsoleViewMedia {

	public static void main(String[] args) {
		
		try {
			CursoBOStub bo = new CursoBOStub();
			
			CalcularMedia valores = new CalcularMedia();
			valores.setNac(1);
			valores.setAm(10);
			valores.setPs(10);
			
			CalcularMediaResponse response = bo.calcularMedia(valores);
			
			double media = response.get_return();
			
			System.out.println("Sua média é: " + media);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
