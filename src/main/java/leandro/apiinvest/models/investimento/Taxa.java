package leandro.apiinvest.models.investimento;

import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

public class Taxa {
    private String nome;
    private Double valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public static Double getCDI(){
        RestClient cliente = RestClient.create();
        Taxa resultado = cliente.get().
                uri("https://brasilapi.com.br/api/taxas/v1/CDI").
                retrieve().
                body(Taxa.class);

        return resultado.valor;
    }

    public static Double getSelic(){
        RestClient cliente = RestClient.create();
        Taxa resultado = cliente.get().
                uri("https://brasilapi.com.br/api/taxas/v1/Selic").
                retrieve().
                body(Taxa.class);

        return resultado.valor;
    }

    public static Integer getIOF(int dia){
        List<Integer> limitesRendimento = new ArrayList<>(List.of(
                96, 	 	63, 	 	30,
                        93, 	 	60, 	 	26,
                        90, 	 	56, 	 	23,
                        86, 	 	53, 	 	20,
                        83, 	 	50, 	 	16,
                        80, 	 	46, 	 	13,
                        76, 	 	43, 	 	10,
                        73, 	 	40, 	 	6,
                        70, 	 	36, 	 	3,
                        66, 	 	33, 	 	0
        ));

        if(dia > 30){
            return 0;
        }

        return limitesRendimento.get(dia-1);
    }

}

