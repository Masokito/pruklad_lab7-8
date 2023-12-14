package command;

import tarufList.TarufList;
import logger.LOGGER;
import java.util.logging.*;
public class SaveInFile implements Command{
    public static Logger logger = LOGGER.LOGGER;
    public  void execute(){
        logger.info("SaveInFile Command executed");
        TarufList.saveTarufsToXmlFile();
    }
}
