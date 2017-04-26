package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.ConsultorBO;
import br.com.fiap.entity.Consultor;

@ManagedBean
public class ListaConsultorBean {

	private ConsultorBO bo;
	private List<Consultor> lista;

	@PostConstruct
	private void init(){
		bo = new ConsultorBO();
		lista = bo.listar();
	}

	public List<Consultor> getLista() {
		return lista;
	}

	public void setLista(List<Consultor> lista) {
		this.lista = lista;
	}
	
	
	
}
