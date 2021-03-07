public class Program {
    public static void main(String[] args) {
        var console = System.console();
        var communicator = new Communicator(console);

        var activities = new Activity[2];
        activities[0] = new HelloWorld(communicator);
        activities[1] = new DrawStar(communicator);


        var menu = new ActivityMenu(activities, communicator);

        try {
            menu.run();
        } catch (TypeQException e) {
            System.exit(1);
        }
    }
}


