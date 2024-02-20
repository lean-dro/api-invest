package leandro.apiinvest.models.investimento;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Investimento implements IInvestimentoServico{

    private UUID idInvestimento;
    private String nomeInvestimento;
    private Double valorMinimoInvestimento;
    private Date dataVencimento;
    private Double taxaRentabilidadeAno;

    public Investimento(String nomeInvestimento, Double valorMinimoInvestimento, Date dataVencimento, Double taxaRentabilidadeAno) {
        this.idInvestimento = new UUID(
                ThreadLocalRandom.current().nextLong(1_000_000L,2_000_000L ),
                ThreadLocalRandom.current().nextLong(3_000_000L,4_000_000L )
        );
        this.nomeInvestimento = nomeInvestimento;
        this.valorMinimoInvestimento = valorMinimoInvestimento;
        this.dataVencimento = dataVencimento;
        this.taxaRentabilidadeAno = taxaRentabilidadeAno;
    }

    public UUID getIdInvestimento() {
        return idInvestimento;
    }

    public String getNomeInvestimento() {
        return nomeInvestimento;
    }

    public Double getValorMinimoInvestimento() {
        return valorMinimoInvestimento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public Double getTaxaRentabilidadeAno() {
        return taxaRentabilidadeAno;
    }
}
