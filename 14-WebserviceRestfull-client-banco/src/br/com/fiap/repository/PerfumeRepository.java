package br.com.fiap.repository;

import javax.ws.rs.core.MediaType;
import javax.xml.ws.WebServiceException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.entity.Perfume;

public class PerfumeRepository {

	private Client cliente = Client.create();
	private static final String URL = "http://localhost:8080/12-WebserviceRestfull-server-banco/rest/perfume/";

	private void cadastrar(Perfume perfume){

		WebResource resource = cliente.resource(URL);
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class,perfume);

		if(response.getStatus() != 201){
			throw new WebServiceException("HTTP Status: " + response.getStatus());
		}
	}
	
}
