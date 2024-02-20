package leandro.apiinvest.models.investimento;

import java.util.Calendar;
import java.util.Date;

public class TesouroDireto extends Investimento{
    public TesouroDireto(String nomeInvestimento, Double valorMinimoInvestimento, Date dataVencimento, Double taxaRentabilidadeAno) {
        super(nomeInvestimento, valorMinimoInvestimento, dataVencimento, taxaRentabilidadeAno);
    }

    @Override
    public Double simular(Double valorFixo, Date dataFinal) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(new Date());


        Double rendimentoDiario = getTaxaRentabilidadeAno()/12/31;

        Double acumulo = valorFixo;

        Double rendimento = 0.;
        int diasRendimento = 1;

        Calendar calendarioFinal = Calendar.getInstance();
        calendarioFinal.setTime(dataFinal);

        while(calendario.getTime().getTime() < calendarioFinal.getTime().getTime()){
            calendario.add(Calendar.DAY_OF_YEAR, 1);
            diasRendimento++;
            rendimento += (acumulo * (rendimentoDiario/100));

        }

        Double impostos = 0.;
        Double ir = 0.;
        if(diasRendimento < 180){
            ir = 22.5;
        }else if(diasRendimento < 360){
            ir = 20.;
        }else if(diasRendimento < 720){
            ir = 17.5;
        }else{
            ir = 15.;
        }

        if(diasRendimento < 30){
            impostos += rendimento * (Taxa.getIOF(diasRendimento)/100.);
        }

        impostos += rendimento * (ir/100);

        acumulo += rendimento-impostos;



        return acumulo;


    }
}
