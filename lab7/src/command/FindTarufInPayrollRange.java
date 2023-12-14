package command;

import tarufList.TarufList;

import java.util.Scanner;

public class FindTarufInPayrollRange implements Command{
    public void execute(){
        double minPayroll;double maxPayroll;
        Scanner input = new Scanner(System.in);
        System.out.print("Введіть мінімальну абонплату: ");
        minPayroll = input.nextDouble();
        System.out.print("Введіть максимальну абонплату: ");
        maxPayroll = input.nextDouble();
        TarufList.findTarufInPayrollRange(minPayroll,maxPayroll);
    }
}
