package softess;

public class UserInterface {

    public UserInterface() {}

    public void showWelcomeMessage() {
        System.out.println("Hello! I'm softess.Softess");
        System.out.println("What can I do for you?\n");
    }

    public void showGoodByeMessage() {
        System.out.println("softess.Softess: Bye. Hope to see you again soon noob!");
    }

    public void showErrorMessage(String message) {
        String text = "Oops! Looks like something went wrong: \n %s".formatted(message);
        System.out.println(text);
    }
}
