import java.util.Scanner;

public class Main {




    public static void main(String[] args) {

        MovieStreamer streamer = new MovieStreamer();

        Scanner sc = new Scanner(System.in);
        System.out.println("*********Hello*********");
        System.out.println("The system is off");
        System.out.println("The internet is off");
        System.out.println("The disk is empty and has 100 empty cells");
        System.out.println("***********************");
        int index = 1;
        while (true) {
            System.out.println("Choose Action");
            System.out.println("0 - exit");
            System.out.println("1 - Add File Request");
            System.out.println("2 - Change Disk Size");
            System.out.println("3 - Turn Off System");
            System.out.println("4 - Turn On System");
            System.out.println("5 - Turn Off Internet");
            System.out.println("6 - Turn On Internet");
            String action = sc.next();
            switch (action) {
                case("0"):
                    System.exit(0);
                    break;
                case ("1"):
                    System.out.println("Insert File Size");
                    int flieSize = sc.nextInt();
                    File f = new File(index++, flieSize);
                    streamer.addDownloadQueue(f);
                    break;
                case ("2"):
                    System.out.println("Insert Disk Size");
                    int diskSize = sc.nextInt();
                    streamer.setAvailableSpace(diskSize);
                    break;
                case ("3"):
                    streamer.turnSystemOff();
                    break;
                case ("4"):
                    streamer.turnSystemOn();
                    break;
                case ("5"):
                    streamer.turnInternetOff();
                    break;
                case ("6"):
                    streamer.turnInternetOn();
                    break;
            }
        }




    }



}
