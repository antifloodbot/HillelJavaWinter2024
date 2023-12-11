package lesson_04;

public class Stack {
    public static void main(SystemOutPrint[] args) {
        int k = 0; // 1 (k) - 1 (push)

        for (int i = 0; i < 5; i++){  // 2 (i) - 2 (push)
            fr(i); // push 3 -> pop 2
            k = i;
            for (int j = 0; j < 5; j++){ // 3 (j) - 3 (push)
                sec(j);
                k = j;
            } // pop j -> 2
        }  // pop i  -> 1

        int i = 5; //push (i) -> 2

        // stack 1 (k)
        if (false) {
            int d = 0; // 3 (d)
        } else {
            int d = 0; // 3 (d)
        } // pop d - 2

        int s = 9; // push s -> 3

        fr(s);

        // s pop
        // i pop
        // k pop
    } // 0 - FINISH

    private static void fr(int i){
        System.out.println(i); // new var (push -> pop)

    }

    private static void sec(int j){
        System.out.println(j); // new var (push -> pop)
    }
}
