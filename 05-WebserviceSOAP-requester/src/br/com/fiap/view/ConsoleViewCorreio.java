package br.com.fiap.view;

import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class ConsoleViewCorreio {

	public static void main(String[] args) {

		try {
			CalcPrecoPrazoWSStub bo = new CalcPrecoPrazoWSStub();

			//Valores para o webservice
			CalcPrazo valores = new CalcPrazo();
			valores.setNCdServico("40010");
			valores.setSCepDestino("05136110");
			valores.setSCepOrigem("05136130");

			CalcPrazoResponse response = bo.calcPrazo(valores);

			String prazo = response.getCalcPrazoResult().getServicos()
								   .getCServico()[0].getPrazoEntrega();

			System.out.println("Prazo de entrega : " + prazo);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
