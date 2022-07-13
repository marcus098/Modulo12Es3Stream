import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    /*
    Creare una lista di interi positivi formata da 10000 numeri casuali.
Eseguire le seguenti operazioni:
I. Ordinare i numeri in ordine crescente e stampare i primi 3 numeri.
II. Moltiplicare ogni numero per 3 e stampare i primi 3.
III. Aggiungere ad ogni numero il suo precedente e stampare i primi 3.
IV. Controllare se i primi 5 numeri sono ordinati
     */

    static String str = " ";

    public static void main(String[] args) {
        Random rnd = new Random();
        String str2 = " ";
        //List<Integer> integerList = IntStream.range(0,10000).boxed().collect(Collectors.toList());
        List<Integer> integerList = IntStream.range(0, 10000)
                .map(n -> rnd.nextInt(20000))
                .boxed()
                .collect(Collectors.toList());
        System.out.println(integerList);

        //punto 1
        //Ordinare i numeri in ordine crescente e stampare i primi 3 numeri.
        integerList
                .stream()
                .sorted()
                .limit(3)
                .forEach(System.out::println);

        //II. Moltiplicare ogni numero per 3 e stampare i primi 3.
        integerList
                .stream()
                .map(n -> n * 3)
                .limit(3)
                .forEach(System.out::println);
        System.out.println("-----------------");

        //III. Aggiungere ad ogni numero il suo precedente e stampare i primi 3.
        IntStream.range(0, integerList.size())
                .map(index -> index > 0 ? integerList.get(index) + integerList.get(index - 1) : integerList.get(index))
                .limit(3)
                .forEach(System.out::println);

        System.out.println("--------------");

        //IV. Controllare se i primi 5 numeri sono ordinati
        //List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        integerList
                .stream()
                .limit(5)
                .reduce((a, b) -> {
                    if (a > b)
                        setString(str2);
                    return b;
                });
        System.out.println("Numeri " + str + " ordinati");
    }

    public static void setString(String s){
        str = s.replaceAll("\\s", "non");
    }
}
