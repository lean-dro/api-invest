package leandro.apiinvest.models.cliente;

import java.util.Date;
import java.util.UUID;

public class ClientePJ extends Cliente{


    public String cnpj;
    public ClientePJ(String nome, Date nascimento,String cnpj)
    {
        super(nome, nascimento);
        this.cnpj = cnpj;
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}