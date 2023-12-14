package command;
import menu.*;

public class StartMenuCommand implements Command {
    public void execute() {
        Menu.createStartMenu();
    }

    //public String getCommandName(){return this.name};
}
