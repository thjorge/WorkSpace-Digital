package br.com.fiap.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.dao.PerfumeDAO;
import br.com.fiap.dao.impl.PerfumeDAOImpl;
import br.com.fiap.entity.Perfume;
import br.com.fiap.factory.EntityManagerFactorySingleton;

@Path("/perfume")
public class PerfumeResource {

	private EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
	
	// /rest/perfume GET
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Perfume> listar(){
		EntityManager em = fabrica.createEntityManager();
		PerfumeDAO dao = getDAO(em);
		List<Perfume> lista = dao.listar();
		return lista;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Perfume perfume, @Context UriInfo uriInfo){
		EntityManager em = fabrica.createEntityManager();
		PerfumeDAO dao = getDAO(em);
		dao.cadastrar(perfume);
		try {
			dao.cadastrar(perfume);
			dao.salvar();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
		//Construir a URL para acessar o perfume
		UriBuilder url = UriBuilder.fromPath(uriInfo.getPath());
		url.path(String.valueOf(perfume.getCodigo()));
		return Response.created(url.build()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Perfume buscar(@PathParam("id") Integer codigo){
		EntityManager em = fabrica.createEntityManager();
		PerfumeDAO dao = getDAO(em);
		return dao.pesquisar(codigo);
	}
	
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo) {
		EntityManager em = fabrica.createEntityManager();
		PerfumeDAO dao = getDAO(em);
		try {
			dao.remover(codigo);
			dao.salvar();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	@PUT
	public Perfume atualizar(){
		
		return null;
	}
	
	public PerfumeDAO getDAO(EntityManager em){
		return new PerfumeDAOImpl(em);
	}
	
}
