package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.fiap.dto.ProdutoDTO;

public class ProdutoBO {

	private static HashMap<Integer, ProdutoDTO> banco = new HashMap<>();
	private static int sequence = 3;
	
	static{
		banco.put(1, new ProdutoDTO(1, "Celular", 100, 5));
		banco.put(2, new ProdutoDTO(2, "Telefone", 1000, 5));
		banco.put(3, new ProdutoDTO(3, "Tablet", 200, 5));
	}
	
	public void cadastrar(ProdutoDTO produto){
		produto.setCodigo(++sequence);
		banco.put(sequence, produto);
	}
	
	public List<ProdutoDTO> listar(){
		return new ArrayList<ProdutoDTO>(banco.values());
	}
	
	public void atualizar(ProdutoDTO produto){
		banco.put(produto.getCodigo(), produto);
	}
	
	public void remover(int codigo){
		banco.remove(codigo);
	}
	
	public ProdutoDTO buscar(int codigo){
		return banco.get(codigo);
	}
	
}
