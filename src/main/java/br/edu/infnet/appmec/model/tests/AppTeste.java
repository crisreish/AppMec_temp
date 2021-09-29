package br.edu.infnet.appmec.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.io.ClassPathResource;

import br.edu.infnet.appmec.model.domain.Caldeira;
import br.edu.infnet.appmec.model.domain.Condensador;
import br.edu.infnet.appmec.model.domain.Pedido;
import br.edu.infnet.appmec.model.domain.Solicitante;
import br.edu.infnet.appmec.model.exceptions.CentroCustoInvalidoException;
import br.edu.infnet.appmec.model.exceptions.CentroTrabalhoInvalidoException;
import br.edu.infnet.appmec.model.exceptions.EquipEmGarantiaException;
import br.edu.infnet.appmec.model.exceptions.NumSerieNuloException;

public class AppTeste {

	public static void main(String[] args) {

		String dir = System.getProperty("user.dir");
		String arq = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+".txt";

		try {
			try {
				InputStream resource = new ClassPathResource("static/pedidos.txt").getInputStream();

				FileWriter fileW = new FileWriter(dir + arq);
				BufferedWriter escrita = new BufferedWriter(fileW);

				BufferedReader leitura = new BufferedReader(new InputStreamReader(resource));

				String linha = leitura.readLine();

				while (linha != null) {

					String[] campos = linha.split(";");

					switch (campos[0].toUpperCase()) {
						case "0":
							Solicitante solicitanteP1 = new Solicitante(campos[2], campos[3], String.valueOf(campos[4]));

							Pedido p1 = new Pedido();
							p1.setDescricao(campos[1]);
							p1.setSolicitante(solicitanteP1);

							escrita.write(p1.obterPedido()+"\r\n");

							break;

						case "B":
							Caldeira b1 = new Caldeira(campos[1], Float.valueOf(campos[2]), "S".equalsIgnoreCase(campos[3]));
							b1.setGarantia("S".equalsIgnoreCase(campos[4]));
							b1.setDescricao(campos[5]);
							b1.setNumserie(Integer.valueOf(campos[6]));

							escrita.write(b1.obterEquipamento());

							break;

						case "C":
							Condensador c1 = new Condensador(campos[1], Float.valueOf(campos[2]), "S".equalsIgnoreCase(campos[3]));
							c1.setDescricao(campos[4]);
							c1.setNumserie(Integer.valueOf(campos[5]));
							c1.setGarantia("S".equalsIgnoreCase(campos[6]));

							escrita.write(c1.obterEquipamento());

							break;

						default:
							System.out.println("Entrada inválida!!!");
							break;
					}

					linha = leitura.readLine();
				}

				leitura.close();
				escrita.close();
				fileW.close();

			} catch (CentroCustoInvalidoException |
					CentroTrabalhoInvalidoException |
					EquipEmGarantiaException |
					NumSerieNuloException |
					IOException e) {
				System.out.println(e.getMessage());
			}

		} finally {
			System.out.println("Processamento finalizado: "+(dir + arq)+"!");
		}
	}
}
