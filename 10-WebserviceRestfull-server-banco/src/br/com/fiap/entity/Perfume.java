package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PERFUME")
@SequenceGenerator(name="sqPerfume", sequenceName="SQ_PERFUME",allocationSize=1)
public class Perfume {

	@Id
	@Column(name="CD_PERFUME")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sqPerfume")
	private int codigo;
	
	@Column(name="NM_PERFUME")
	private String nome;
	
	@Column(name="DS_AROMA")
	private String aroma;
	
	@Column(name="QT_ML")
	private float ml;

	
		
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
