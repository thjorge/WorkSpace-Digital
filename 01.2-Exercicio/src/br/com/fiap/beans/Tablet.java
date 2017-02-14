package br.com.fiap.beans;

import br.com.fiap.interfaces.Eletronico;

public class Tablet extends Produto implements Eletronico {

	private String modelo;
	private String marca;
	private String so;
	private boolean have3g;
	
	public Tablet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tablet(int codigo, String titulo, double preco, String modelo, String marca, String so, boolean have3g) {
		super(codigo, titulo, preco);
		this.modelo = modelo;
		this.marca = marca;
		this.so = so;
		this.have3g = have3g;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public boolean isHave3g() {
		return have3g;
	}

	public void setHave3g(boolean have3g) {
		this.have3g = have3g;
	}

	@Override
	public double calcGarantia() {
		return this.getPreco()*0.05;
	}
		
}
