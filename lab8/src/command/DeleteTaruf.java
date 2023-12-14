package command;
import java.util.Scanner;
import tarufList.TarufList;
import logger.LOGGER;
import java.util.logging.*;
public class DeleteTaruf implements Command{
    public static Logger logger = LOGGER.LOGGER;
    public void execute() {
        logger.info("DeleteTaruf Command executed");
        String name;
        System.out.print("Введіть назву тарифу: ");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        TarufList.deleteTaruf(name);
    }
}
