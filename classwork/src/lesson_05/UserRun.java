package lesson_05;

public class UserRun {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();
        User user3 = user1;

        System.out.println(user1.equals(user2));
        System.out.println(user1.equals(user3));

        user2.setActive(true);
        user1.setId(12);

        System.out.println(user1.equals(user2));
        System.out.println(user1.equals(user3));

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        user1.setTest("new value");

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }
}
