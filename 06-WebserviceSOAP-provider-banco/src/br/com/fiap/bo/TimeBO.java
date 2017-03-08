package br.com.fiap.bo;

import javax.persistence.EntityManager;

import org.apache.axis2.AxisFault;

import br.com.fiap.dao.TimeDAO;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.entity.Time;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class TimeBO {

	public void cadastrar(Time time) throws AxisFault{
		//Instanciar o EntityManager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar o TimeDAOImpl
		TimeDAO dao = new TimeDAOImpl(em);
		
		try {
			//Usar o DAO para cadastrar o time
			dao.cadastrar(time);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			throw new AxisFault("Erro ao cadastrar");
		}finally {
			em.close();
		}
		
	}
	
	public Time pesquisar(Integer codigo){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		TimeDAO dao = new TimeDAOImpl(em);
		
		Time time = dao.pesquisar(codigo);
		em.close();
		return time;
	}
	
	public void alterar(Time time) throws AxisFault{
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		TimeDAO dao = new TimeDAOImpl(em);
		
		try {
			dao.alterar(time);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			throw new AxisFault("Erro ao atualizar");
		}
	}
	
}
