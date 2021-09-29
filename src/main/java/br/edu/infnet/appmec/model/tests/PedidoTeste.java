package br.edu.infnet.appmec.model.tests;

import br.edu.infnet.appmec.model.domain.Pedido;
import br.edu.infnet.appmec.model.domain.Solicitante;

public class PedidoTeste {

	public static void main(String[] args) {
		
		Solicitante solicitanteP1 = new Solicitante("Luis", "luis@amrj.com", "34");
		
		Pedido p1 = new Pedido();
		p1.setDescricao("Outro pedido");
		p1.setSolicitante(solicitanteP1);
		System.out.println("Pedido: " + p1);

		Pedido p2 = new Pedido("Pedido da Helena");
		p2.setSolicitante(null);
		System.out.println("Pedido: " + p2);
	}
}