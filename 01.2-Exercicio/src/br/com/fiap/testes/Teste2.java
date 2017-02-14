package br.com.fiap.testes;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Livro;

public class Teste2 {

	public static String texto(String msg){
		return JOptionPane.showInputDialog(msg);
	}

	public static int inteiro(String msg){
		return Integer.parseInt(JOptionPane.showInputDialog(msg));
	}

	public static double decimal(String msg){
		return Double.parseDouble(JOptionPane.showInputDialog(msg));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Livro> livros = new ArrayList<Livro>();

		for(int c=0;c<3;c++){
			Livro livro = new Livro(
					inteiro("Código"),
					texto("Título"),
					decimal("Preço"),
					texto("Autor"),
					texto("Editora"),
					new GregorianCalendar(2016,05,12)
					);
			livros.add(livro);
		}

		for(Livro x : livros){
			JOptionPane.showMessageDialog(null,
					"Título: "+ x.getTitulo()+
					"\nAutor: "+ x.getAutor());
		}

	}

}
