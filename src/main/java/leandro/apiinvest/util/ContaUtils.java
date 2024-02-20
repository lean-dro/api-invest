package leandro.apiinvest.util;

import java.util.Random;

public class ContaUtils {

    public static String gerarNumeroConta(){
        Random numRand = new Random();
        StringBuilder numConta = new StringBuilder();

        for(int i = 0; i < 9; i++){
            numConta.append("%d".formatted(numRand.nextInt(0, 9)));
        };

        return numConta.toString();
    }
}
