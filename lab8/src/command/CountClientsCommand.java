package command;
import tarufList.*;
import logger.LOGGER;
import java.util.logging.*;
public class CountClientsCommand implements Command {
    public static Logger logger = LOGGER.LOGGER;


    public void execute(){
        logger.info("CountClientsCommand Command executed");
        TarufList.printAllClients();
    }
}
