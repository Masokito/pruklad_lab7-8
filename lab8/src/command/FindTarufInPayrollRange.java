package command;

import tarufList.TarufList;

import java.util.Scanner;
import logger.LOGGER;
import java.util.logging.*;
public class FindTarufInPayrollRange implements Command{
    public static Logger logger = LOGGER.LOGGER;
    public void execute(){
        logger.info("FindTarufInPayrollRange Command executed");

        double minPayroll;double maxPayroll;
        Scanner input = new Scanner(System.in);
        System.out.print("Введіть мінімальну абонплату: ");
        minPayroll = input.nextDouble();
        System.out.print("Введіть максимальну абонплату: ");
        maxPayroll = input.nextDouble();
        TarufList.findTarufInPayrollRange(minPayroll,maxPayroll);
    }
}
