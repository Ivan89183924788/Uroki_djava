package lambda_virajenie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainStrimLambda {
    public static void main(String[] args){
        List<Integer> amounts= Arrays.asList(100,250,500,75,999);

        Predicate<Integer> isHighAmount=amount->amount>200;

        List<Integer> highAmounts=filterHighAmountsSync(amounts,isHighAmount);
        System.out.println("Высокие суммы: "+highAmounts);
    }
    private static List<Integer> filterHighAmountsSync(List<Integer> amounts,Predicate<Integer> predicate){
        System.out.println("[SYNC] Фильтрация сумм...");
        return amounts.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
