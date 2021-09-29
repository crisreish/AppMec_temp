package br.edu.infnet.appmec.model.tests;

import br.edu.infnet.appmec.model.domain.Caldeira;
import br.edu.infnet.appmec.model.domain.Condensador;
import br.edu.infnet.appmec.model.exceptions.CentroCustoInvalidoException;
import br.edu.infnet.appmec.model.exceptions.CentroTrabalhoInvalidoException;
import br.edu.infnet.appmec.model.exceptions.EquipEmGarantiaException;
import br.edu.infnet.appmec.model.exceptions.NumSerieNuloException;

public class EquipamentoTeste {

	public static void main(String[] args) {
		try {
			Caldeira b1 = new Caldeira("Caldeira Inox", 100, true);
			b1.setDescricao("vapor superaquecido");
			b1.setNumserie(5025);
			b1.setGarantia(true);
			System.out.printf("CALDEIRA >>> %s", b1.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException | CentroCustoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Caldeira b2 = new Caldeira("Caldeira cerâmica", 100, true);
			b2.setGarantia(true);
			b2.setDescricao("vapor baixa pressao");
			b2.setNumserie(5045);
			System.out.printf("CALDEIRA >>> %s", b2.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException | CentroCustoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Caldeira b3 = new Caldeira("Caldeira Especial", 100, true);
			b3.setGarantia(false);
			b3.setDescricao("vapor toxico");
			b3.setNumserie(5055);
			System.out.printf("CALDEIRA >>> %s", b3.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException | CentroCustoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Condensador c1 = new Condensador("Condensador Inox", 150F, true);
			c1.setGarantia(false);
			c1.setDescricao("vapor superaquecido");
			c1.setNumserie(6045);
			System.out.printf("CONDENSADOR >>> %s", c1.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException | CentroCustoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Condensador c2 = new Condensador("Condensador cerâmico", 200F, true);
			c2.setGarantia(true);
			c2.setDescricao("vapor superaquecido");
			c2.setNumserie(6025);
			System.out.printf("CONDENSADOR >>> %s", c2.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException | CentroCustoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Condensador c3 = new Condensador("Condensador Especial", 230F, true);
			c3.setGarantia(false);
			c3.setDescricao("vapor toxico");
			c3.setNumserie(6055);
			System.out.printf("CONDENSADOR >>> %s", c3.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException | CentroCustoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Condensador c4 = new Condensador("Condensador Smart", 290F, true);
			c4.setGarantia(true);
			c4.setDescricao("vapor variavel");
			c4.setNumserie(6055);
			System.out.printf("CONDENSADOR >>> %s", c4.obterEquipamento());
		} catch (NumSerieNuloException | EquipEmGarantiaException | CentroTrabalhoInvalidoException | CentroCustoInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
