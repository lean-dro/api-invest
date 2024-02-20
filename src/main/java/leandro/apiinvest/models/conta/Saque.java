package leandro.apiinvest.models.conta;

import java.util.Date;

public class Saque {
    private Date data;
    private Double valor;

    public Saque(Double valor) {
        this.data = new Date();
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
