package command;


import tarufList.TarufList;
import logger.LOGGER;
import java.util.logging.*;
public class ViewTarufs implements Command{
    public static Logger logger = LOGGER.LOGGER;
    public void execute(){
        logger.info("ViewTarufs Command executed");
        TarufList.printAllTarufs();
    }
}
