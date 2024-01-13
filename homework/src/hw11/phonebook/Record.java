package hw11.phonebook;

public class Record {
    private String name;
    private String phoneNumber;

    public Record(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
