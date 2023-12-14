package command;
import menu.*;
import logger.LOGGER;
import java.util.logging.*;
public class StartMenuCommand implements Command {
    public static Logger logger = LOGGER.LOGGER;
    public void execute() {
        logger.info("StartMenuCommand Command executed");
        Menu.createStartMenu();
    }

    //public String getCommandName(){return this.name};
}
