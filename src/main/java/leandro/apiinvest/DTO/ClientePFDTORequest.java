package leandro.apiinvest.DTO;

import java.util.Date;

public record ClientePFDTORequest(String nome, Date dataNascimento, String cpf) {
}
