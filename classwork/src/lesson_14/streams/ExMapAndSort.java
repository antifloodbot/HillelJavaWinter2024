package lesson_14.streams;

import lesson_14.streamExample.businessObject.User;
import lesson_14.streamExample.businessObject.enumerators.Sex;
import lesson_14.streamExample.businessObject.service.UserService;

import java.util.Comparator;
import java.util.List;

public class ExMapAndSort {
    public static void main(String[] args) {
        List<User> users = UserService.getUserList();
        users.forEach(User::print);


        System.out.println("--------------");

        List<String> userFullName = users.stream()
                .filter(u -> u.getSex().equals(Sex.MALE))
                .peek(u -> u.setFullName(u.getFirstName() + " " + u.getLastName()))
                .sorted(Comparator.comparing(User::getFirstName))
                .map(User::getFullName)
                .toList();

        userFullName.forEach(System.out::println);

    }
}
