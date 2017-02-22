package br.com.fiap.loja;

import javax.swing.JOptionPane;

import br.com.fiap.bo.EstoqueBOStub;
import br.com.fiap.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.bo.EstoqueBOStub.Listar;
import br.com.fiap.bo.EstoqueBOStub.ListarResponse;
import br.com.fiap.bo.EstoqueBOStub.ProdutoDTO;

public class TerminalBuscaPreco {

	public static void main(String[] args) {
		
		try {
			EstoqueBOStub bo = new EstoqueBOStub();
			
			//1 - pesquisar por código
			//2 - listar
			if(Integer.parseInt(JOptionPane.showInputDialog("1 - Pesquisar por código \n2 - Listar"))
					==1){
			ConsultarProduto valores = new ConsultarProduto();
			valores.setCdProduto(Integer.parseInt(JOptionPane.showInputDialog("Código do produto")));
			
			ConsultarProdutoResponse response = bo.consultarProduto(valores);
			
			ProdutoDTO dto = response.get_return();
			
			JOptionPane.showMessageDialog(null,
					"Descrição: "+ dto.getDescricao() +
					"\nPreço unitário: "+ dto.getPrecoUnitario() +
					"\nQuantidade em estoque: "+ dto.getQuantidade());
			}else{
				ListarResponse response = bo.listar(new Listar());
				
				for (ProdutoDTO dto : response.get_return()) {
					JOptionPane.showMessageDialog(null,
							"Descrição: "+ dto.getDescricao() +
							"\nPreço unitário: "+ dto.getPrecoUnitario() +
							"\nQuantidade em estoque: "+ dto.getQuantidade());
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
