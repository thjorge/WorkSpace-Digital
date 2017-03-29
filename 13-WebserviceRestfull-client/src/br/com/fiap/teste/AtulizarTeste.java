package br.com.fiap.teste;

import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class AtulizarTeste {

	public static void main(String[] args) {
		
		ProdutoRepository rep = new ProdutoRepository();
		
		ProdutoTO produto = new ProdutoTO(2, "Cavaquinho", 250, 1000);
		
		try {
			rep.atulizar(produto);
			System.out.println("Sucesso!");
		} catch (Exception e) {
			System.out.println("Deu ruim");
			e.printStackTrace();
		}
			
		
	}
	
}
