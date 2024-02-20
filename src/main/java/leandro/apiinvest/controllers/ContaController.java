package leandro.apiinvest.controllers;

import leandro.apiinvest.models.cliente.Cliente;
import leandro.apiinvest.models.conta.Conta;
import leandro.apiinvest.models.tipoConta.TipoContaEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    List<Conta> contas = new ArrayList<>();

    @PostMapping("/{idCliente}/nova/poupanca")
    public ResponseEntity criarContaPoupanca(@PathVariable String idCliente){

        Cliente cliente = ClienteController.clientes.stream().filter(
                c -> c.getId().toString().equals(idCliente)
        ).findFirst().orElse(null);


        if(cliente != null ){
            return ResponseEntity.ok(cliente.abrirConta(TipoContaEnum.POUPANCA));
        }else{
            return ResponseEntity.badRequest().body("Cliente Não encontrado");
        }

    }

    @PostMapping("/{idCliente}/nova/investimento")
    public Conta criarContaInvestimento(@PathVariable String idCliente){
        Cliente cliente = ClienteController.clientes.stream().filter(
                c -> c.getId().toString().equals(idCliente)
        ).findFirst().orElse(null);


        if(cliente != null ){
            return cliente.abrirConta(TipoContaEnum.INVESTIMENTO);
        }else{
            return null;
        }
    }

}
