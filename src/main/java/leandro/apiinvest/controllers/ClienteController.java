package leandro.apiinvest.controllers;

import leandro.apiinvest.DTO.ClientePFDTORequest;
import leandro.apiinvest.DTO.ClientePJDTORequest;
import leandro.apiinvest.models.cliente.Cliente;
import leandro.apiinvest.models.cliente.ClientePF;
import leandro.apiinvest.models.cliente.ClientePJ;
import leandro.apiinvest.models.tipoConta.TipoContaEnum;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    public static List<Cliente> clientes = new ArrayList<>();


    @GetMapping
    public List<Cliente> listarClientes(){
        return clientes;
    }

    @PostMapping("/novo/pj")
    public Cliente cadastrarNovoClientePJ(@RequestBody ClientePJDTORequest novoCliente){

        ClientePJ novoClientePJ = new ClientePJ(
                novoCliente.nome(),
                novoCliente.dataNascimento(),
                novoCliente.cnpj());
        novoClientePJ.abrirConta(TipoContaEnum.INVESTIMENTO);
        novoClientePJ.abrirConta(TipoContaEnum.POUPANCA);
        clientes.add(novoClientePJ);

        return novoClientePJ;
    }

    @PostMapping("/novo/pf")
    public Cliente cadastrarNovoClientePF(@RequestBody ClientePFDTORequest novoCliente){

        ClientePF novoClientePF = new ClientePF(
                novoCliente.nome(),
                novoCliente.dataNascimento(),
                novoCliente.cpf());

        novoClientePF.abrirConta(TipoContaEnum.INVESTIMENTO);
        novoClientePF.abrirConta(TipoContaEnum.POUPANCA);
        clientes.add(novoClientePF);

        return novoClientePF;
    }
}
