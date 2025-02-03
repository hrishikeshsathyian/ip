package softess;

public abstract class Command {


    protected UserInterface ui;
    public Command(UserInterface ui) {
        this.ui = ui;
    }
    public abstract void trigger();
}
