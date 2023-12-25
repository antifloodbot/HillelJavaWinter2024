package hw8;

import java.util.ArrayList;
import java.util.List;

public class SubscriberServiceImpl implements SubscriberService {

    @Override
    public void fetchUserData(Subscriber subscriber) {
        System.out.println(subscriber.toString());
    }

    @Override
    public List<Subscriber> filterSubscribersByCityCallDuration(List<Subscriber> subscribers, double minCityCallDuration) {
        List<Subscriber> filteredSubscribers = new ArrayList<>();
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getCityCallDuration() > minCityCallDuration) {
                filteredSubscribers.add(subscriber);
            }
        }
        return filteredSubscribers;
    }

    @Override
    public List<Subscriber> filterSubscribersByIntercityCallDuration(List<Subscriber> subscribers) {
        List<Subscriber> filteredSubscribers = new ArrayList<>();
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getIntercityCallDuration() > 0) {
                filteredSubscribers.add(subscriber);
            }
        }
        return filteredSubscribers;
    }

    @Override
    public void filterSubscribersByFirstLetter(List<Subscriber> subscribers, char startingLetter) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getLastName().startsWith(String.valueOf(startingLetter))) {
                System.out.printf("Full Name: %s %s, Phone number: %d, Balance: $%.2f%n",
                        subscriber.getLastName(), subscriber.getFirstName(),
                        subscriber.getPhoneNumber(), subscriber.getBalance());
            }
        }
    }

    @Override
    public List<Subscriber> filterSubscribersByNegativeBalance(List<Subscriber> subscribers) {
        List<Subscriber> filteredSubscribers = new ArrayList<>();
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getBalance() < 0) {
                filteredSubscribers.add(subscriber);
            }
        }
        return filteredSubscribers;
    }
}
