package lesson_14.comp;

import lesson_14.streamExample.businessObject.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        userList.add(new User("Ivan"));
        userList.add(new User("Sveta"));
        userList.add(new User("Anna", "3",34));
        userList.add(new User("Anna", "3",12));
        userList.add(new User("Alex", "3",12));
        userList.add(new User("Alex", "2",43));
        userList.add(new User("Alex", "1",34));
        userList.add(new User("Petr", "1",44));

        Comparator<User> userComparator = Comparator.comparing(User::getFirstName);
        Comparator<User> ageComparator = Comparator.comparing(User::getAge);

        userList.forEach(System.out::println);
        System.out.println("---------------");
        System.out.println();
        userList.sort(userComparator
                .thenComparing(User::getLastName)
                .thenComparing(ageComparator));
//                .reversed());

        userList.forEach(System.out::println);
    }
}
