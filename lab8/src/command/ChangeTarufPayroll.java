package command;
import tarufList.TarufList;
import java.util.Scanner;
import logger.LOGGER;
import java.util.logging.*;
public class ChangeTarufPayroll implements Command{
    public static Logger logger = LOGGER.LOGGER;
    public void execute(){
        logger.info("ChangeTarufPayroll Command executed");

        String name;
        double payroll;
        System.out.print("Введіть назву тарифу: ");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        System.out.print("Введіть абонплату: ");
        payroll = input.nextDouble();
        TarufList.setPayrollByName(name,payroll);
    }
}
