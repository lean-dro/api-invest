package leandro.apiinvest.DTO;

public record CDBDTORequest(
        String nomeInvestimento,
        String nomeInstituicao,
        Double valorMinimoInvestimento,
        String dataVencimento,
        Double taxaRentabilidade
) {
}
