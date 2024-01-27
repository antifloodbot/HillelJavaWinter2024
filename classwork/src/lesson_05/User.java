package lesson_05;

import java.util.Objects;

public class User {
    private int id;
    private String fullName;
    private String phone;
    private Boolean active;
    private static String test = "static";

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public  String getTest() {
        return test;
    }

    public  void setTest(String test) {
        User.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return
                id == user.id &&
                        Objects.equals(fullName, user.fullName) &&
                        Objects.equals(phone, user.phone) &&
                        Objects.equals(active, user.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, phone, active);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", active=" + active +
                ", test=" + test +
                '}';
    }

    public void printUser(User user) {
        System.out.println(user);
    }
}
