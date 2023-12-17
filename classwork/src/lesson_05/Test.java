package lesson_05;

public class Test {
    public static void main(String[] args) {
        Print print = new Print();

        print.print();
        print.print("Hello ...");
    }
}

class Print{
    void print(){
        System.out.println("print");
    }

    void print(String srt){
        System.out.println(srt);
    }
}
