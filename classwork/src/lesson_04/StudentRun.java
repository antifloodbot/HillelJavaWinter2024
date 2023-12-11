package lesson_04;

public class StudentRun {
    public static void main(SystemOutPrint[] args) {
        Student st = new Student();
        System.out.println(st);
        st.setFirstName("Oleksandr");
        st.setLastName("Stepurko");
        st.setAge(40);
        System.out.println(st);

        Student stud = new Student("Ivan", "Ivanov");

        System.out.println(stud);
    }
}
