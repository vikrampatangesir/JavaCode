import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        BankAccount bankAccount = new BankAccount();
        BankAccount bankAccount2 = new BankAccount();
        System.out.println("Hii");
        bankAccount.withdraw(50);
        bankAccount2.withdraw(50);

        CompletableFuture<String> completableFuture= CompletableFuture.supplyAsync(

                ()-> {
                    return "Hello from CompletableFuture"; }
        );
        System.out.println(completableFuture.get());



        CompletableFuture<String> completableFuture1= CompletableFuture.supplyAsync(

                ()-> {
                    return "Hello from CompletableFuture"; }
        );
        System.out.println(completableFuture.get());
        System.out.println(completableFuture1.get());
        CompletableFuture<String> stringCompletableFutureResult= completableFuture1.thenCombine
                (completableFuture1, (s1, s2) -> s1 + " " + s2);
        System.out.println(stringCompletableFutureResult.get());

        List<Integer> list = Arrays.asList(1, 4, 5, 6, 7, 9, 3, 2, 2);

        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collect.forEach(x->System.out.println(x));





    }

}
