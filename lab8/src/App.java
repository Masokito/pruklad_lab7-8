
import command.*;
import menu.Menu;
import java.util.logging.*;
import java.util.logging.LogManager;
import java.io.*;
import java.util.logging.*;
import emailsender.EmailSender;
import logger.LOGGER;
import org.simplejavamail.email.EmailBuilder;


public class App{

    static Logger logger = LOGGER.LOGGER;
    public static void main(String[] args){
        //EmailSender.send("Typereceiveremailhere@gmail.com",test");
        Command start = new StartMenuCommand();
        try {
            start.execute();
        }catch (Exception e){

            logger.severe("Crtitcal error occured");
            EmailSender.send("Typereceiveremailhere@gmail.com",e.getMessage());
        }

    }
}