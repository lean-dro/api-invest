package leandro.apiinvest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {

    public static Date converterData(String data){
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");

        try{
            return formatador.parse(data);
        }catch (ParseException e){
            return null;
        }
    }
}
