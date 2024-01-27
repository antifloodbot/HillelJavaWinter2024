package lesson_14.streams;

import lesson_14.streamExample.businessObject.User;
import lesson_14.streamExample.businessObject.enumerators.Sex;
import lesson_14.streamExample.businessObject.service.UserService;

import java.util.List;

public class MapStream {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ints.stream()
                .filter(i -> i % 2 == 0)
                .map(i -> i * i)
                .forEach(i -> System.out.print(i + " "));

        System.out.println("\n-----------------");
        List<User> users = UserService.getUserList();
        List<User> userList = users.stream()
                .filter(u -> u.getSex().equals(Sex.MALE))
                .map(u -> {
                    User user = new User(u);
                    user.setLastName(user.getLastName() + "_male");
                    return user;
                }).toList();

        users.forEach(User::print);
        System.out.println("----------------");
        userList.forEach(User::print);

        List<String> userStr = users.stream()
                .filter(u -> u.getSex().equals(Sex.FEMALE))
                .map(u -> u.getFirstName() + " " + u.getLastName())
                .toList();
        System.out.println("-------------");
        userStr.forEach(System.out::println);
    }
}
