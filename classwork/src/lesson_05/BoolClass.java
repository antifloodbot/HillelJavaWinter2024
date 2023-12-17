package lesson_05;

public class BoolClass {
    private boolean test1;
    private Boolean test2;

    public boolean isTest1() {
        return test1;
    }

    public void setTest1(boolean test1) {
        this.test1 = test1;
    }

    public Boolean getTest2() {
        return test2;
    }

    public void setTest2(Boolean test2) {
        this.test2 = test2;
    }
}
class Run {
    public static void main(String[] args) {
        BoolClass boolClass = new BoolClass();
        System.out.println(boolClass.isTest1()); // default false
        System.out.println(boolClass.getTest2()); // default null
        boolClass.setTest1(true);
        boolClass.setTest2(null);
        System.out.println("--------------");
        System.out.println(boolClass.isTest1());
        System.out.println(boolClass.getTest2());

    }
}
