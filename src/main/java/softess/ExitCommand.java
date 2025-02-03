package softess;

public class ExitCommand extends Command {

    public ExitCommand(UserInterface ui) {
        super(ui);
    }
    @Override
    public void trigger() {
        super.ui.showGoodByeMessage();
    }
}
