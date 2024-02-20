package leandro.apiinvest.models.investimento;

import java.util.Date;

public class Aplicacao {
    private Double valorAplicado;
    private Date dataAplicado;
    private Investimento investimento;

    public Aplicacao(Double valorAplicado, Investimento investimento) {
        this.valorAplicado = valorAplicado;
        this.dataAplicado = new Date();
        this.investimento = investimento;
    }

    public Double getValorAplicado() {
        return valorAplicado;
    }

    public void setValorAplicado(Double valorAplicado) {
        this.valorAplicado = valorAplicado;
    }

    public Date getDataAplicado() {
        return dataAplicado;
    }

    public void setDataAplicado(Date dataAplicado) {
        this.dataAplicado = dataAplicado;
    }

    public Investimento getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }
}
