package leandro.apiinvest.models.cliente;

import java.util.Date;

public class ClientePF extends Cliente{
    private String cpf;


    public ClientePF(String nome, Date nascimento, String cpf)
    {
        super(nome, nascimento);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
