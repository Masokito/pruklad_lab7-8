package logger;

import menu.Menu;
import org.apache.logging.log4j.*;

import java.io.*;
import java.util.logging.Logger;


public class LOGGER {
    public static java.util.logging.Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("./log.config")){
            java.util.logging.LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(LOGGER.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

}
