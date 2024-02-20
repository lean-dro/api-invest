package leandro.apiinvest.controllers;

import leandro.apiinvest.DTO.CDBDTORequest;
import leandro.apiinvest.models.investimento.CDB;
import leandro.apiinvest.models.investimento.Investimento;
import leandro.apiinvest.models.investimento.TesouroDireto;
import leandro.apiinvest.util.DataUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

    public static List<Investimento> investimentos = new ArrayList<>(
            List.of(
                    new CDB(
                            "INVESTI COELHO",
                            350.,
                            DataUtils.converterData("2030-01-01"),
                            101.,
                            "COELHO BANK"
                    ),
                    new CDB(
                            "INVESTI COELHO 2.0",
                            300.,
                            DataUtils.converterData("2027-01-01"),
                            100.,
                            "COELHO BANK"
                    ),
                    new TesouroDireto(
                            "BRASIL INVESTI",
                            30.,
                            DataUtils.converterData("2040-01-01"),
                            5.8
                    ),
                    new TesouroDireto(
                            "BRASIL INVESTI 2.0",
                            38.,
                            DataUtils.converterData("2060-01-01"),
                            5.5
                    )
            )
    );

    @GetMapping
    public List<Investimento> listarInvestimentos(){
        return investimentos;
    }

    @PostMapping("/novo/cdb")
    public Investimento novoCDB(@RequestBody CDBDTORequest cdbDTO){
        CDB novoCDB = new CDB(
                cdbDTO.nomeInvestimento(),
                cdbDTO.valorMinimoInvestimento(),
                DataUtils.converterData(cdbDTO.dataVencimento()),
                cdbDTO.taxaRentabilidade(),
                cdbDTO.nomeInstituicao()
        );

        investimentos.add(novoCDB);

        return novoCDB;
    }

    @GetMapping("simular/{idInvestimento}")
    public Double simularInvestimento(@PathVariable String idInvestimento,
                                      @RequestParam Double valorFixo,
                                      @RequestParam String dataFinal){
        Investimento investimentoProcurado = investimentos.stream().filter(
                i -> i.getIdInvestimento().toString().equals(idInvestimento)
        ).findFirst().get();

        return investimentoProcurado.simular(valorFixo, DataUtils.converterData(dataFinal));

    }


}
