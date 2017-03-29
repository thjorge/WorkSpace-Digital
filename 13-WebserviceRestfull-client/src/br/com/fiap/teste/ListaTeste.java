package br.com.fiap.teste;



import java.util.List;
import br.com.fiap.repository.ProdutoRepository;
import br.com.fiap.to.ProdutoTO;

public class ListaTeste {

	public static void main(String[] args) {
		//Listar todos os produtos
		ProdutoRepository rep = new ProdutoRepository();

		try {
			List<ProdutoTO> listar = rep.listar();
			for(ProdutoTO produtoTO : listar){
				System.out.println(produtoTO.getNome() + " R$ " + produtoTO.getPreco());
			}
		} catch (Exception e) {
			System.err.println("Deu Ruim!");
			e.printStackTrace();
		}


	}

}
