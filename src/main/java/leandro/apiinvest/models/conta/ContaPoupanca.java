package leandro.apiinvest.models.conta;

import leandro.apiinvest.models.investimento.IInvestimentoServico;
import leandro.apiinvest.models.investimento.Taxa;

import java.util.Calendar;
import java.util.Date;

public class ContaPoupanca extends Conta implements IInvestimentoServico {

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

    @Override
    public Double simular(Double valorFixo, Date dataFinal) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(new Date());
        int diaAniversario = calendario.get(Calendar.DAY_OF_MONTH);
        Double acumulo = valorFixo;

        while(calendario.getTime().getTime() <= dataFinal.getTime()){
            calendario.add(Calendar.DAY_OF_YEAR, 1);
            if(calendario.get(Calendar.DAY_OF_MONTH) == diaAniversario){
                if(Taxa.getCDI() > 8.5){
                    acumulo *= 1.005;
                }else{
                    acumulo *=  (Taxa.getSelic() * (70/100.));
                }
            }

        }

        return acumulo;
    }
}
