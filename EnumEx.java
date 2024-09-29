import java.util.Scanner;
public class EnumEx {
    public enum TrafficLight {
        RED("STOP!"), YELLOW("SLOW DOWN!"), GREEN("GO!");

        private String action;
        TrafficLight(String action) {
            this.action = action;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a traffic light color (RED, YELLOW, GREEN):");
        String input = sc.nextLine().toUpperCase();
        TrafficLight color = TrafficLight.valueOf(input);
        switch (color) {
            case RED:
                System.out.println(color.action);
                break;
            case YELLOW:
                System.out.println(color.action);
                break;
            case GREEN:
                System.out.println(color.action);
                break;
            default:
                System.out.println("Invalid traffic light color.");
                break;
        }
    }
}
