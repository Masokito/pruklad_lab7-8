package command;
import logger.LOGGER;
import java.util.logging.*;

public interface Command {
    //String getName();
    public static Logger logger = LOGGER.LOGGER;
    void execute();
//    void execute();
}
