package br.edu.infnet.appmec.model.tests;

import br.edu.infnet.appmec.model.domain.Solicitante;

public class SolicitanteTeste {

	public static void main(String[] args) {

		Solicitante s1 = new Solicitante("Cristiane Andrade", "cristiane.andrade@al.infnet.edu.br", "amrj222");
		System.out.println("Solicitante: " + s1);
	}
}