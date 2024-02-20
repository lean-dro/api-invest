package leandro.apiinvest.models.conta;

import java.util.Date;

public class Deposito {
    private Date data;
    private Double valor;

    public Deposito(Double valor) {
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
