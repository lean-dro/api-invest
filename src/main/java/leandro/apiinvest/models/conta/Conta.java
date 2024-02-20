package leandro.apiinvest.models.conta;

import  leandro.apiinvest.util.ContaUtils;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Conta {

    private UUID id;
    private String numero;
    private String agencia;
    private Date dataCriacao;
    private Double saldo;
    protected Extrato extrato;


    public Conta() {
        this.id = new UUID(
                ThreadLocalRandom.current().nextLong(1_000_000L,2_000_000L ),
                ThreadLocalRandom.current().nextLong(3_000_000L,4_000_000L )
        );
        this.numero = ContaUtils.gerarNumeroConta();
        this.agencia = "AGENCIA COELHO";
        this.dataCriacao = new Date();
        this.saldo = 0.;
        this.extrato = new Extrato();

    }

    public UUID getId() {
        return id;
    }


    public String getTipoConta(){
        return this.getClass().getSimpleName();
    }


    public abstract Double getSaldo();
    public abstract Double sacar(Double valor);
    public abstract void depositar(Double valor);

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }


}
