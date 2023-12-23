package hw8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Users that exceed city calls limit");
        List<Subscriber> subscribers = new ArrayList<>();
        subscribers.add(new Subscriber(1, "Gubka", "Bob","Kiev", 931110011, 112233, 10.0, 10.1, 15, 100 ));
        subscribers.add(new Subscriber(2, "Vasia", "Pupkin", "Lviv", 923293740, 112234, -10, 13, 0, 14));
        subscribers.add(new Subscriber(3, "John", "Snow", "Vinnitsia" ,923533741, 1004, -100, 130, 344, 0.25));
        double minCityCallDuration = 10.0;
        SubscriberServiceImpl service = new SubscriberServiceImpl();
        List<Subscriber> filteredSubscribersByCityCallDuration = service.filterSubscribersByCityCallDuration(subscribers, minCityCallDuration);
        for (Subscriber filteredSubscriber : filteredSubscribersByCityCallDuration) {
            service.fetchUserData(filteredSubscriber);
        }

        System.out.println("Users with intercity calls");
        List<Subscriber> filteredSubscribersByIntercityCallDuration = service.filterSubscribersByIntercityCallDuration(subscribers);
        for (Subscriber filteredSubscriber : filteredSubscribersByIntercityCallDuration) {
            service.fetchUserData(filteredSubscriber);
        }

        System.out.println("Users filtered by first letter");
        service.filterSubscribersByFirstLetter(subscribers, 'B');

        System.out.println("Users with negative balance");
        List<Subscriber> filteredSubscribersByNegativeBalance = service.filterSubscribersByNegativeBalance(subscribers);
        for (Subscriber filteredSubscriber : filteredSubscribersByNegativeBalance) {
            service.fetchUserData(filteredSubscriber);
        }
    }
}
