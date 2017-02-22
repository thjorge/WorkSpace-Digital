package br.com.fiap.bo;

import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.AxisFault;
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

	public ProdutoDTO consultarProduto(int cdProduto) throws AxisFault{
		ProdutoDTO prod = banco.get(cdProduto);
		if (prod == null){
			log.error("Produto nullo");
			throw new AxisFault("Produto não cadastrado");
		}				
		log.debug("Retornando o produto");
		return prod;
	}

}
