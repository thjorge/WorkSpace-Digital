package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.ConsultorBO;
import br.com.fiap.entity.Consultor;
import br.com.fiap.exception.DBException;

@ManagedBean
public class ConsultorBean {

	private Consultor consultor;
	private ConsultorBO bo;
	
	@PostConstruct
	private void inicializacao(){
		consultor = new Consultor();
		bo = new ConsultorBO();
	}

	public void cadastrar(){
		try {
			bo.cadastrar(consultor);
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	public Consultor getConsultor() {
		return consultor;
	}

	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}

}
