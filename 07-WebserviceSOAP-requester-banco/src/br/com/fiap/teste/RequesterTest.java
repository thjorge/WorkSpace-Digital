package br.com.fiap.teste;

import br.com.fiap.bo.TimeBOStub;
import br.com.fiap.bo.TimeBOStub.Cadastrar;
import br.com.fiap.bo.TimeBOStub.Time;

public class RequesterTest {

	public static void main(String[] args){

		try {
			//Instanciar o Stub
			TimeBOStub bo = new TimeBOStub();
			
			//Instanciar o time
			Time time = new Time();
			time.setNome("Time de teste");
			time.setTurma("2TDSA");
			time.setTitulos(3);
			
			//Intanciar a classe com o mesmo nome do método
			Cadastrar entity = new Cadastrar();
			entity.setTime(time);
			
			//Chamar o método cadastrar do stub
			bo.cadastrar(entity);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

}
