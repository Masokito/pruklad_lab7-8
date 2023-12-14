package command;
import java.util.*;
import logger.LOGGER;
import java.util.logging.*;
public class EndProgramCommand implements Command{

    public static Logger logger = LOGGER.LOGGER;
    public void execute(){
        logger.info("EndProgramCommand Command executed");
        System.exit(0);
    }
}
