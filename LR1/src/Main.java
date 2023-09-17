public class Main {
    public static void main(String[] args) {
        Clock clock1 = new Clock(5290);
        Clock clock2 = new Clock(10,20,5);
        System.out.println("Clock 1: "+clock1);
        System.out.println("Clock 2: "+clock2);
        System.out.println(clock2.getTotalSeconds());
        System.out.println(clock1.compareTo(clock2));
    }
}