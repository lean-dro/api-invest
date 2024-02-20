package leandro.apiinvest.DTO;

public record TesouroDiretoDTORequest(
        String nomeInvestimento,
        Double valorMinimoInvestimento,
        String dataVencimento,
        Double taxaRentabilidade
) {
}
