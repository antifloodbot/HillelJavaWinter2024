package lesson_03;

public class SwitchEx {
    public static void main(String[] args) {
        int week = 1;

//        System.out.println(day((byte)week));
//        System.out.println(dayNumber("sunday"));
//        System.out.println(dayNumber(week));

        dayWithBrake((byte)week);
    }

    // new view
    static String day(byte i) {
        return switch (i) {
            case 1, 2, 3, 4, 5 -> "Work day";
            case 6, 7 -> "Weekend";
            default -> "End off earth ....";
        };
    }

    static int dayNumber(String day){
        return switch (day.toLowerCase()) {
            case "понедельник", "monday" -> 1;
            case "sunday" -> 2;
            default -> 3;
        };
    }

    // old view
    static String dayWithBrake(byte i){
        switch (i) {
            case 1, 2, 3, 4, 5 : {
                System.out.println("Work day");
                break;
            }
            case 6, 7: {
                System.out.println("Weekend");
                break;
            }
        }
        return "";
    }
}
