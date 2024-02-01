package lesson_15.task;

import java.util.List;

public class SubscriberStream {
    //        Створити інтерфейс (SubscriberService) та його реалізацію (SubscriberServiceImpl) для вибірки даних та вивести ці дані на консоль.
//        a) відомості про абонентів, у яких час внутрішньоміських розмов перевищує заданий;
//        b) відомості про абонентів, які користувалися міжміським зв'язком;
//        c) відомості про абонентів ПІБ, номер телефону, баланс - де перший бука прізвища передається як параметр
//        d) сумарне споживання трафіку інтернету для певного міста
//        e) кількість абонентів з негативним балансом
    public List<Subscriber> cityCallsMoreThanLimit(List<Subscriber> subscribers, int cityLimit) {
        return subscribers.stream()
                .filter(subscriber -> subscriber.getCityCallDurationMin() > cityLimit)
                .toList();
    }

    public List<Subscriber> intercityCall(List<Subscriber> subscribers) {
        return subscribers.stream()
                .filter(subscriber -> subscriber.getCityCallDurationMin() > 0)
                .toList();
    }

    public List<String> startWith(List<Subscriber> subscribers, String firstLetter) {
        return subscribers.stream()
                .filter(subscriber -> subscriber.getLastName().startsWith(firstLetter))
                .map(s -> s.getLastName()
                .concat(" ").concat(s.getFirstName())
                        .concat(" ").concat(s.getPhoneNumber())
                        .concat(" ").concat(String.valueOf(s.getBalance())))
                        .toList();
    }

    public long cityInternetTraffic(List<Subscriber> subscribers, String cityName) {
        return subscribers.stream()
                .filter(subscriber -> subscriber.getCity().equals(cityName))
                .mapToLong(s -> s.getInternetTrafficGb().longValue()).sum();
    }

    public Long negativeBalance(List<Subscriber> subscribers) {
        return subscribers.stream()
                .filter(subscriber -> subscriber.getBalance() < 0)
                .count();
    }
}
