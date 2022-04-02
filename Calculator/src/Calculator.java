import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

//  Изначальный код
//      BinaryOperator<Integer> devide = (x, y) -> x / y;
//  вызывает ошибку ArithmeticException при делении на 0, в случае когда y = 0.
//  В данном случае можно написать полноценный блок кода с проверкой и вывести
//  соответствующее сообщение, вернув при этом 0.

//    BinaryOperator<Integer> devide = (x, y) -> {
//        if (y == 0) {
//            System.out.println("Деление на ноль невозможно");
//            return 0;
//        } else {
//            return x / y;
//        }
//    };
//
//    Либо в тернарном операторе вызвать метод обработки этой ошибки, вернув 0

    BinaryOperator<Integer> devide = (x, y) -> y == 0 ? divideByZeroError(y) : x / y;

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;

    private static int divideByZeroError(int y) {
        System.out.println("Деление на ноль невозможно");
        return 0;
    }

}
