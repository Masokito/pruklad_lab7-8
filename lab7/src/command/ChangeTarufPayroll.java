package command;
import tarufList.TarufList;
import java.util.Scanner;
public class ChangeTarufPayroll implements Command{
    public void execute(){
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
