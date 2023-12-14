package command;
import java.util.*;
import tarufList.*;

public class AddTarufMob implements Command {
    public void execute(){
        String name;
        int clients;
        double payroll;
        int minutes;
        double addMinPrice;
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Введіть ім`я тарифу(String):");
            name = input.nextLine();
            System.out.print("Введіть кількість клієнтів(Int):");
            clients = input.nextInt();
            System.out.print("Введіть абонтплату(Double):");
            payroll = input.nextDouble();
            System.out.print("Введіть кількість хвилин (int:");
            minutes = input.nextInt();
            System.out.print("Введіть ціну додаткових хвилин(Double):");
            addMinPrice = input.nextDouble();
            TarufList.AddTarufMob(name,clients,payroll,minutes,addMinPrice);
        }catch(Exception e){
            System.out.print("Введені некоректні дані \n");
        }
    }
}
