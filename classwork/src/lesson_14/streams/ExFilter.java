package lesson_14.streams;

import lesson_14.streamExample.businessObject.User;
import lesson_14.streamExample.businessObject.enumerators.Sex;
import lesson_14.streamExample.businessObject.service.UserService;
import java.util.List;
import java.util.function.Predicate;

public class ExFilter {
    public static void main(String[] args) {
        List<User> users = UserService.getUserList();
        users.forEach(User::print);
        System.out.println("-------------");

        Long f = users.stream().filter(u -> u.getSex().equals(Sex.FEMALE)).count();
        Long m = users.stream().filter(u -> u.getSex().equals(Sex.MALE)).count();

        System.out.println("f : " + f);
        System.out.println("m : " + m);
        System.out.println("total: " + (m + f));

        List<User> fUsers = users.stream().filter(u -> u.getSex().equals(Sex.FEMALE)).toList();
        System.out.println("---------");
        fUsers.forEach(User::print);

        Predicate<User> isMale = (u) -> u.getSex().equals(Sex.MALE);
        Predicate<User> isAdult = (u) -> u.getAge() > 18;

        System.out.println("---------------");
        List<User> mUsers = users.stream().filter(isMale.and(isAdult)).toList();
        mUsers.forEach(User::print);
    }
}
