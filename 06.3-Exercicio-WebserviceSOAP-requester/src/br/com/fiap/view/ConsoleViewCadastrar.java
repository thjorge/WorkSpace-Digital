package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import br.com.fiap.bo.ClienteBOStub;
import br.com.fiap.bo.ClienteBOStub.Cadastrar;
import br.com.fiap.bo.ClienteBOStub.Cliente;

public class ConsoleViewCadastrar {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		try {
			//Instanciar o Stub com todas as classes
			ClienteBOStub bo = new ClienteBOStub();
		
			//Instanciar o Cliente
			Cliente cli = new Cliente();
			System.out.println("Cadastro de Cliente "
					+ "\nInforme o nome:");
			cli.setNome(teclado.next());
			
			cli.setDataNascimento(new GregorianCalendar(1998,Calendar.JUNE,9));
			
			System.out.println("Email:");
			cli.setEmail(teclado.next());
			
			//Set do cliente na classe de mesmo nome do método
			Cadastrar entity = new Cadastrar();
			entity.setCli(cli);
			
			//Cadastrar pelo método
			bo.cadastrar(entity);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			teclado.close();
		}		
	}
	
}
