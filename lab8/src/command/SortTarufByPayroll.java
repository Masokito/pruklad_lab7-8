package command;

import tarufList.TarufList;
import logger.LOGGER;
import java.util.logging.*;
public class SortTarufByPayroll implements Command{
    public static Logger logger = LOGGER.LOGGER;
    public void execute(){
        logger.info("SortTarufByPayroll Command executed");
        TarufList.printSortedByPayroll();
    }
}
