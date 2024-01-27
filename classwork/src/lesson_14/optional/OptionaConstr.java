package lesson_14.optional;

import lesson_05.User;

import java.util.Optional;

public class OptionaConstr {
    public static void main(String[] args) {
        User us = new User();
        Optional<User> oUser = Optional.of(us);
        oUser.ifPresent(oUser.get()::printUser);

        oUser.ifPresent(us::printUser);
        Optional<User> user = Optional.ofNullable(us);

        Optional<User> userEmpty = Optional.empty();

        Optional<String> optionalString = Optional.of("Hello, World!");
        optionalString.ifPresent(value -> System.out.println("Значення: " + value));

        Optional<String> optionalString2 = Optional.of("Hello, World!");
        if (optionalString2.isPresent()) {
            System.out.println("Значення присутнє");
        } else {
            System.out.println("Значення відсутнє");
        }
    }
}
