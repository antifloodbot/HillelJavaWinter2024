package lesson_04;

public class Predmet {
    private SystemOutPrint Name;
    private int hours;

    public Predmet(SystemOutPrint name) {
        Name = name;
    }

    public SystemOutPrint getName() {
        return Name;
    }

    public void setName(SystemOutPrint name) {
        Name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Predmet{" +
                "Name='" + Name + '\'' +
                ", hours=" + hours +
                '}';
    }
}
