package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.axis2.AxisFault;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class ClienteBO {

	public void cadastrar(Cliente cli) throws AxisFault{
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ClienteDAO dao = new ClienteDAOImpl(em);
		
		try {
			dao.cadastrar(cli);
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			throw new AxisFault("Erro ao cadastrar");
		}finally {
			em.close();
		}
	}
	
	public void atualizar(Cliente cli) throws AxisFault{
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ClienteDAOImpl dao = new ClienteDAOImpl(em);
		
		try {
			dao.alterar(cli);
			dao.salvar();
		}catch (DBException e) {
			e.printStackTrace();
			throw new AxisFault("Erro ao atualizar");
		} finally {
			em.close();
		}
	}

	public void remover(Integer i) throws AxisFault{
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ClienteDAOImpl dao = new ClienteDAOImpl(em);
	
		try {
			dao.remover(i);
			dao.salvar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AxisFault("Erro ao remover");
		}finally {
			em.close();
		}
	}
	
	public Cliente buscar(Integer i) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
		ClienteDAOImpl dao = new ClienteDAOImpl(em);
	
		Cliente cli = dao.pesquisar(i);
		em.close();
		return cli;
	}
	
	public List<Cliente> listar(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ClienteDAOImpl dao = new ClienteDAOImpl(em);
		
		ArrayList<Cliente> clientes = (ArrayList<Cliente>) dao.listar();
		em.close();

		return clientes;
	}
	
}
