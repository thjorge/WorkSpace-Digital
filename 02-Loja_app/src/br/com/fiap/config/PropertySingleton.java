package br.com.fiap.config;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertySingleton {
	
	private static Logger log = LoggerFactory.getLogger(PropertySingleton.class);
	private static Properties prop;
	
	//Ctor privado, não será possível instanciar
	private PropertySingleton(){
		
	}
	
	public static Properties getInstance(){
		if(prop == null){
			//Instancia o Properties
			prop = new Properties();
			try{
				log.debug("Carregando o arquivo de propriedades");
				//Carrega as informações do arquivo config.properties
				prop.load(Properties.class.getResourceAsStream("/config.properties"));
			}catch(IOException e){
				e.printStackTrace();
			}			
		}		
		log.trace("Retornando as propriedades");
		return prop;
	}
	
}
