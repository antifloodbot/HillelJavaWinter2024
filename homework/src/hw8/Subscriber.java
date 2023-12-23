package hw8;

public class Subscriber {
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private long phoneNumber;
    private int contractNumber;
    private double balance;
    private double cityCallDuration;
    private double intercityCallDuration;
    private double internetTraffic;

    public Subscriber(int id, String firstName, String lastName, String city, long phoneNumber,
                      int contractNumber, double balance, double cityCallDuration,
                      double intercityCallDuration, double internetTraffic) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.contractNumber = contractNumber;
        this.balance = balance;
        this.cityCallDuration = cityCallDuration;
        this.intercityCallDuration = intercityCallDuration;
        this.internetTraffic = internetTraffic;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCityCallDuration() {
        return cityCallDuration;
    }

    public void setCityCallDuration(double cityCallDuration) {
        this.cityCallDuration = cityCallDuration;
    }

    public double getIntercityCallDuration() {
        return intercityCallDuration;
    }

    public void setIntercityCallDuration(double intercityCallDuration) {
        this.intercityCallDuration = intercityCallDuration;
    }

    public double getInternetTraffic() {
        return internetTraffic;
    }

    public void setInternetTraffic(double internetTraffic) {
        this.internetTraffic = internetTraffic;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", contractNumber=" + contractNumber +
                ", balance=" + balance +
                " $, callDuration=" + cityCallDuration +
                " min, intercityCallDuration=" + intercityCallDuration +
                " min, internetTraffic=" + internetTraffic +
                " GB}";
    }
}
