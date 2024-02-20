package leandro.apiinvest.models.investimento;

import java.util.Date;

public interface IInvestimentoServico {

    public Double simular(Double valorFixo, Date dataFinal);
}
