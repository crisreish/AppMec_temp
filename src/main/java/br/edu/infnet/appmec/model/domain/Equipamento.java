package br.edu.infnet.appmec.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.edu.infnet.appmec.model.exceptions.CentroCustoInvalidoException;
import br.edu.infnet.appmec.model.exceptions.CentroTrabalhoInvalidoException;
import br.edu.infnet.appmec.model.exceptions.EquipEmGarantiaException;
import br.edu.infnet.appmec.model.exceptions.NumSerieNuloException;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Equipamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String centrab;
	private String centrocusto;
	private float valor;
	private Integer numserie;
	private Integer ciclo;
	private boolean garantia;
	private boolean critico;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToMany(mappedBy = "equipamentos")
	private List<Equipamento> equipamentos;
	public Equipamento() {
	}

	public Equipamento(String descricao, float valor, boolean garantia) {
		this.descricao = descricao;
		this.centrab = centrab;
		this.centrocusto = centrocusto;
		this.valor = valor;
		this.numserie = numserie;
		this.ciclo = ciclo;
		this.garantia = garantia;
		this.critico = critico;
	}
	public Equipamento(String descricao, String centrab, String centrocusto, float valor, int numserie, int ciclo,  boolean garantia, boolean critico) {
	}

	public Equipamento(String nome, float valor, boolean critico, int numserie, String centrocusto) {
	}

	public String obterEquipamento() throws NumSerieNuloException, CentroTrabalhoInvalidoException, CentroCustoInvalidoException, EquipEmGarantiaException {

		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.calcularValorBruto());
		sb.append("\r\n");

		return sb.toString();
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(this.descricao);
		sb.append(";");
		sb.append(this.centrab);
		sb.append(";");
		sb.append(this.centrocusto);
		sb.append(";");
		sb.append(this.valor);
		sb.append(";");
		sb.append(this.numserie);
		sb.append(";");
		sb.append(this.ciclo);
		sb.append(";");
		sb.append(this.garantia ? "S" : "N");
		sb.append(";");
		sb.append(this.critico ? "S" : "N");
		return sb.toString();
	}

	public abstract float calcularValorBruto() throws  NumSerieNuloException, CentroTrabalhoInvalidoException, CentroCustoInvalidoException, EquipEmGarantiaException;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCentrab() {
		return centrab;
	}
	public void setCentrab(String centrab) { this.centrab = centrab;}

	public String getCentrocusto() {
		return centrocusto;
	}
	public void setCentrocusto(String centrocusto) { this.centrocusto = centrocusto;}

	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}

	public int isNumserie() {
		return numserie;
	}
	public void setNumserie(int numserie) {
		this.numserie = numserie;
	}

	public int getCiclo() {return ciclo;}
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	public Boolean getGarantia() {
		return garantia;
	}
	public void setGarantia(Boolean garantia) {
		this.garantia = garantia;
	}

	public Boolean getCritico() {return critico;}
	public void setCritico(Boolean critico) {
		this.critico = critico;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Equipamento> getEquipamento() {
		List<Equipamento> equipamento = null;
		return equipamento;
	}

	public abstract void setModelo(String novo);
}