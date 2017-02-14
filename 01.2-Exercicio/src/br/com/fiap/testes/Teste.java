package br.com.fiap.testes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Livro;
import br.com.fiap.beans.Tablet;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tablet objTablet = new Tablet(1,"Tablet bom e barato",1000,"SG13W","Samsung","Android",true);
		
		JOptionPane.showMessageDialog(null,
				"Código: " + objTablet.getCodigo() + 
				"\nDesc: " + objTablet.getTitulo() + 
				"\nPreço: " + objTablet.getPreco() +
				"\nModelo: " + objTablet.getModelo() +
				"\nMarca: " + objTablet.getMarca() + 
				"\nSO: " + objTablet.getSo() + 
				"\n3g?: " + objTablet.isHave3g() + 
				"\nValor para a garania " + objTablet.calcGarantia()
				);
		
		SimpleDateFormat fmtData = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dtLancamento = new GregorianCalendar(1998,Calendar.JUNE,9);
		
		Livro objLivro = new Livro(2,"50 tons de progs",45.50,"Kenzo","MasPorQ?",dtLancamento);
		
		JOptionPane.showMessageDialog(null,
				"Código: " + objLivro.getCodigo() + 
				"\nDesc: " + objLivro.getTitulo() + 
				"\nPreço: " + objLivro.getPreco() +
				"\nAutor: " + objLivro.getAutor() +
				"\nEditora: " + objLivro.getEditora() + 
				"\nData Lançamento: " + fmtData.format(objLivro.getDtLancamento().getTime())
				);
		
	}

}
