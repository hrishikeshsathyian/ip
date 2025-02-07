package softess;

public class ExitCommand extends Command {

    public ExitCommand(UserInterface ui) {
        super(ui);
    }
    @Override
    public String trigger() {
        return super.ui.showGoodByeMessage();
    }
}
