package leandro.apiinvest.models.conta;

import java.util.ArrayList;
import java.util.List;

public class Extrato {
    private List<Saque> saques;
    private List<Deposito> depositos;

    public Extrato() {
        this.saques = new ArrayList<>();
        this.depositos = new ArrayList<>();
    }

    public void adicionarSaque(Double valor){
        this.saques.add(
                new Saque(valor)
        );
    }

    public void adicionarDeposito(Double valor){
        this.depositos.add(
                new Deposito(valor)
        );
    }



}
