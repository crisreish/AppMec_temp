package br.edu.infnet.appmec.model.domain;

import javax.persistence.Entity;

import br.edu.infnet.appmec.model.exceptions.CentroCustoInvalidoException;
import br.edu.infnet.appmec.model.exceptions.CentroTrabalhoInvalidoException;
import br.edu.infnet.appmec.model.exceptions.EquipEmGarantiaException;
import br.edu.infnet.appmec.model.exceptions.NumSerieNuloException;

@Entity
public class Caldeira extends Equipamento {

    private String descricao;
    private boolean garantia;
    private int numserie;

    public Caldeira() {

    }

    public Caldeira(String descricao, float valor, boolean garantia) {
        super(descricao, valor, garantia);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(";");
        sb.append(this.descricao);
        sb.append(";");
        sb.append(this.garantia ? "S" : "N");
        sb.append(";");
        sb.append(this.numserie);

        return sb.toString();
    }

    @Override
    public float calcularValorBruto() throws NumSerieNuloException {

        if(this.numserie <= 0) {
            throw new NumSerieNuloException("[Caldeira] A caldeira informada é inválida: " + this.numserie);
        }

        float valorDescricao = 0;
        if("refrataria".equalsIgnoreCase(this.descricao)) {
            valorDescricao = 100;
        }

        float valorGarantia = 100;
        if(this.garantia) {
            valorGarantia = 200;
        }

        float valorNumserie = this.numserie * 0.05f;

        return this.getValor() + valorDescricao + valorGarantia + valorNumserie;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isGarantia() {
        return garantia;
    }

    public void setGarantia(boolean garantia) {
        this.garantia = garantia;
    }

    public float getNumserie() {
        return numserie;
    }

    public void setNumserie(int numserie) {
        this.numserie = numserie;
    }

    @Override
    public void setModelo(String novo) {

    }
}