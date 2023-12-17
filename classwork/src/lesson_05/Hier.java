package lesson_05;

import java.util.Objects;

public class Hier {
    String name;
    String phone;
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hier hier = (Hier) o;
        return Objects.equals(name, hier.name) &&
                Objects.equals(phone, hier.phone) &&
                Objects.equals(age, hier.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, age);
    }

    @Override
    public String toString() {
        return "Hier{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
