public class HelloWorld implements Activity {
    private Communicator insCommunicator;
   
    public HelloWorld(Communicator communicator) {
        insCommunicator = communicator;
    }

    public void run() {
        insCommunicator.tell("Welcome! Could you please enter your name?");
        var name = insCommunicator.listen();
        insCommunicator.tell("Hello " + name + "!");
    }

    @Override
    public String getName() {
        return "Hello World";
    }
    
}
