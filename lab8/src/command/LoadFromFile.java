package command;

import tarufList.TarufList;
import logger.LOGGER;
import java.util.logging.*;
public class LoadFromFile implements Command{
    public static Logger logger = LOGGER.LOGGER;
    public void execute(){
        logger.info("LoadFromFile Command executed");
        TarufList.loadTarufsFromXmlFile();
    }
}
