package br.com.fiap.entity;

public class Perfume {

	
	private int codigo;
	
	private String nome;
	
	private String aroma;
	
	private float ml;
	
	public Perfume() {
		super();
	}

	public Perfume(int codigo, String nome, String aroma, float ml) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.aroma = aroma;
		this.ml = ml;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAroma() {
		return aroma;
	}

	public void setAroma(String aroma) {
		this.aroma = aroma;
	}

	public float getMl() {
		return ml;
	}

	public void setMl(float ml) {
		this.ml = ml;
	}
	
}
