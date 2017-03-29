package br.com.fiap.teste;

import br.com.fiap.repository.ProdutoRepository;

public class RemoverTeste {

	public static void main(String[] args) {
		ProdutoRepository rep = new ProdutoRepository();
		
		try {
			rep.remover(1);
			System.out.println("Sucesso!");
		} catch (Exception e) {
			System.out.println("Deu ruim!");
			e.printStackTrace();
		}
		

	}

}
