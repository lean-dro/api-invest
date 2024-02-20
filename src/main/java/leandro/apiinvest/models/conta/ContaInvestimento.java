package leandro.apiinvest.models.conta;

import leandro.apiinvest.models.investimento.Aplicacao;

import java.util.ArrayList;
import java.util.List;

public class ContaInvestimento extends Conta {

    private List<Aplicacao> aplicacoes;

    public ContaInvestimento() {
        this.aplicacoes = new ArrayList<>();
    }

    @Override
    public Double getSaldo() {
        return null;
    }

    @Override
    public Double sacar(Double valor) {
        return null;
    }

    @Override
    public void depositar(Double valor) {

    }
}
