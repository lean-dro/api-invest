package leandro.apiinvest.models.cliente;

import leandro.apiinvest.models.conta.Conta;
import leandro.apiinvest.models.conta.ContaInvestimento;
import leandro.apiinvest.models.conta.ContaPoupanca;
import leandro.apiinvest.models.tipoConta.TipoContaEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Cliente {

    public UUID id;
    private String nome;
    private Date nascimento;
    private List<Conta> listaContas;

    public String getNome() {
        return nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public UUID getId() {
        return id;
    }

    public Cliente(String nome, Date nascimento) {
        this.id = new UUID(
            ThreadLocalRandom.current().nextLong(1_000_000L,2_000_000L ),
            ThreadLocalRandom.current().nextLong(3_000_000L,4_000_000L )
        );
        this.nome = nome;
        this.nascimento = nascimento;
        listaContas = new ArrayList<Conta>();
    }

    public Conta buscarConta(String idConta){


        Conta conta = listaContas.stream().filter(
                c->c.getId().toString().equals(idConta)
        ).findFirst().get();


        return conta;
    }

    public Conta abrirConta(TipoContaEnum tipoConta){
        Conta novaConta;
        if (tipoConta == TipoContaEnum.INVESTIMENTO){
            novaConta = new ContaInvestimento();
            listaContas.add(novaConta);
        }else{
            novaConta = new ContaPoupanca();
            listaContas.add(novaConta);
        }
        return novaConta;
    }
}
