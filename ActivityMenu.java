public class ActivityMenu {
    private Activity[] activity;
    private Communicator io;

    public ActivityMenu(Activity[] activity, Communicator communicator) {
        this.activity = activity;
        io = communicator;
    }

    public void run() throws TypeQException {
        int activityNo;
        boolean isTerminated = false;

        while (!isTerminated) {
            this.listMenuOptions();
            activityNo = this.getMenuChoice();
            activity[activityNo - 1].run();
        }
    }

    public void listMenuOptions() {
        io.tell("Here is the menu to choose your activity : ");
        for (int i = 0; i < this.activity.length; i++) {
            io.tell(" Type " + (i + 1) + " to " + activity[i].getName());
        }
        io.tell(" ");
        io.tell(" Type q for Quit ");
    }

    public int getMenuChoice() throws TypeQException {
        String menuOption = io.listen();

        while (isOptionValid(menuOption) == 0) {

            io.tell("Type your choice again:");
            menuOption = io.listen();
        }
        return isOptionValid(menuOption);
    }

    public int isOptionValid(String option) throws TypeQException {
        int intOption = 0;
        try {
            intOption = Integer.parseInt(option);
            if (0 < intOption && intOption <= this.activity.length)
                return intOption;
        } catch (NumberFormatException e) {
            if (option.contentEquals("q")) {
                throw new TypeQException();
            }
            io.tell("Its not an integer value!");
        }
        return intOption;
    }
}
