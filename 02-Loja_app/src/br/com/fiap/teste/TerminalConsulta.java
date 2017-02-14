package br.com.fiap.teste;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.fiap.bo.EstoqueBO;
import br.com.fiap.config.PropertySingleton;
import br.com.fiap.dto.ProdutoDTO;

public class TerminalConsulta {

	public static final Logger log = LoggerFactory.getLogger(TerminalConsulta.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.warn("Inicio da aplica��o");
		Scanner teclado = new Scanner(System.in);
		DateFormat fmtData = DateFormat.getDateInstance(java.text.DateFormat.MEDIUM);
		Calendar hoje = Calendar.getInstance();
		DecimalFormat dfReais = new DecimalFormat("R$ #,###0.00");
		
		String empresa = PropertySingleton.getInstance().getProperty("empresa");
		
		EstoqueBO estoque = new EstoqueBO();
		
		JOptionPane.showMessageDialog(null, empresa+"                  Data: "+ fmtData.format(hoje.getTime()));
		
		try{
			int cdProd = Integer.parseInt(JOptionPane.showInputDialog("Codigo do produo"));
		
		ProdutoDTO prod = estoque.consultarProduto(cdProd);
		
		log.info("Mostrando o produto");
		JOptionPane.showMessageDialog(null, 
				"Pre�o unit�rio: "+ dfReais.format(prod.getPrecoUnitario())+
				"\nQuantidade: "+ prod.getQuantidade()+
				"\nDescri��o: "+ prod.getDescricao()
				);
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Valor digitado errado");
		}
		teclado.close();
		log.warn("Fim da aplica��o");
	}
	
}
