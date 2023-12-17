package hw5;

public class Employee {
    private String fullName;
    private String jobTitle;
    private String email;
    private int phoneNumber;
    private int age;

    public Employee(String pib, String jobTitle, String email, int phoneNumber, int age) {
        this.fullName = pib;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getPib() {
        return fullName;
    }

    public void setPib(String pib) {
        this.fullName = pib;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
