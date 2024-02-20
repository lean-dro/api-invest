package leandro.apiinvest.DTO;

import java.util.Date;

public record ClientePJDTORequest(String nome, Date dataNascimento, String cnpj) {
}
