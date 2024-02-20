package leandro.apiinvest.controllers;

import leandro.apiinvest.models.conta.ContaPoupanca;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("contas/poupanca")
public class ContaPoupancaController {

    @GetMapping("{idConta}/simular")
    public Double simular(
            @PathVariable String idConta,
            @RequestParam Double valorFixo,
            @RequestParam String dataFinal)  {

        ContaPoupanca conta = (ContaPoupanca) ClienteController.clientes.stream().filter(
                cliente -> cliente.buscarConta(idConta) != null
        ).findFirst().get().buscarConta(idConta);



        if(conta == null) return null;


        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return conta.simular(valorFixo, formatador.parse(dataFinal));
        }catch (ParseException e){
            return null;
        }

    }

}
