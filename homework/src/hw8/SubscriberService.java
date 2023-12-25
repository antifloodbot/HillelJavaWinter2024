package hw8;

import java.util.List;

public interface SubscriberService {
    void fetchUserData(Subscriber subscriber);

    List<Subscriber> filterSubscribersByCityCallDuration(List<Subscriber> subscribers, double minCityCallDuration);

    List<Subscriber> filterSubscribersByIntercityCallDuration(List<Subscriber> subscribers);

    void filterSubscribersByFirstLetter(List<Subscriber> subscribers, char startingLetter);

    List<Subscriber> filterSubscribersByNegativeBalance(List<Subscriber> subscribers);
}
