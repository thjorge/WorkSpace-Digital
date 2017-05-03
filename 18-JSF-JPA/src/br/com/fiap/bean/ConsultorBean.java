package br.com.fiap.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

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
		consultor.setDataAdimissao(Calendar.getInstance());
		bo = new ConsultorBO();
	}

	public String cadastrar(){
		FacesMessage msg;
		try {
		if(consultor.getCodigo() == 0){	
			bo.cadastrar(consultor);
			msg = new FacesMessage("Consultor Cadastrado com Sucesso!");
		}else{
			bo.atualizar(consultor);
			msg = new FacesMessage("Consultor" + consultor.getNome()+ " atualizado!!");
		}		
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro no Cadastro");
			return "cadastro-consultor"; //nome da pagina
		}
		//Mensagem na Tela
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Manter a mensagem em uma nova requisição
		FacesContext.getCurrentInstance().getExternalContext()
										 .getFlash().setKeepMessages(true);
		return "listar-consultor?faces-redirect=true"; //nome da pagina
	}

	public Consultor getConsultor() {
		return consultor;
	}

	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}

}
