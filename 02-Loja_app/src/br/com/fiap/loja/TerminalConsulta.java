package br.com.fiap.loja;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TerminalConsulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		DateFormat fmtData = DateFormat.getDateInstance(java.text.DateFormat.MEDIUM);
		Calendar hoje = Calendar.getInstance();
		
		int prod = 0;
		
		System.out.println("FIAP                  Data: "+fmtData.format(hoje.getTime()));
		System.out.println("******************************************");
		System.out.print("Codigo do produo: ");
		prod = teclado.nextInt();
		
		switch (prod) {
		case 401:
			System.out.println("Descrição : Camiseta Masculina manga curta branca");
			break;
		case 402:
			System.out.println("Descrição : Camiseta Feminina manga longa rosa");
			break;
		default:
			break;
		}
		teclado.close();
	}

}
