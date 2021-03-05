import java.io.Console;

public class Communicator {
    private Console console;

    public Communicator(Console console) {
        this.console = console;
    }

    public void tell(String message) {
        console.writer().println(message);
    }

    public void print(String message) {
        console.writer().print(message);
    }

    public String listen() {
        String input = "";
        do {
            console.writer().print("> ");
            console.flush();
            input = console.readLine();
        } while (input.trim().isEmpty());

        return input;
    }

    public int listenInt() throws TypeQException {
        do {
            var input = listen();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                tell("Its not an integer value, please enter Integer !!");

            }
        } while (true);
    }

}
