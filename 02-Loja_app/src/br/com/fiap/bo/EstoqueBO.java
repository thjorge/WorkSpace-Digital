package br.com.fiap.bo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.dto.ProdutoDTO;

public class EstoqueBO {
	
	private static Logger log = LoggerFactory.getLogger(EstoqueBO.class);
	private Map<Integer,ProdutoDTO> banco = new HashMap<>();
	
	public EstoqueBO() {
		log.debug("Inserindo produtos");
		banco.put(401,new ProdutoDTO (401,12,346,"Camiseta Masculina manga curta branca"));
		banco.put(402,new ProdutoDTO (402,16.50,122,"Camiseta Feminina manga longa rosa"));
	}
	
	public ProdutoDTO consultarProduto(int cdProduto){
		if(banco.get(cdProduto)!=null){
			log.debug("Retornando o produto");
			return banco.get(cdProduto);
		}else{
			log.error("Produto nullo");
			return new ProdutoDTO (cdProduto,0,0,"Produto não cadastrado em nosso sistema");
		}		
	}
		
}
