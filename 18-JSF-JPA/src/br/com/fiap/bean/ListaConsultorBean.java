package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.ConsultorBO;
import br.com.fiap.entity.Consultor;
import br.com.fiap.exception.DBException;

@ManagedBean
public class ListaConsultorBean {

	private ConsultorBO bo;
	private List<Consultor> lista;

	@PostConstruct
	private void init(){
		bo = new ConsultorBO();
		lista = bo.listar();
	}

	public String excluir(int codigo){
		FacesMessage msg = null;
		try {
			bo.remover(codigo);
			msg = new FacesMessage("Consultor Excluido!");
		} catch (DBException e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter a mensagem após o redirect
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		
		//nome do arquivo ? redirect
		return "listar-consultor?faces-redirect=true";

	}

	public List<Consultor> getLista() {
		return lista;
	}

	public void setLista(List<Consultor> lista) {
		this.lista = lista;
	}



}
