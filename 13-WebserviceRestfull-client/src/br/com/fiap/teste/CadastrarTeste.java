package br.com.fiap.teste;

import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class CadastrarTeste {

	public static void main(String[] args) {
		
		//Testar o cadastro através do webservice restfull
		ProdutoRepository rep = new ProdutoRepository();		
		ProdutoTO produto = new ProdutoTO(0, "Sabonete", 10, 1000);
		
		try {
			rep.cadastrar(produto);
			System.out.println("Sucesso! ");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deu Ruim");
		}
		
	}

}
