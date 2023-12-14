package command;

import tarufList.TarufList;

import java.util.Scanner;

public class AddTarufMobSMS implements Command {
    public void execute(){
        String name;
        int clients;
        double payroll;
        int minutes;
        double addMinPrice;
        int numofSMS;
        double addSMSPrice;
        try {
                Scanner input = new Scanner(System.in);
                System.out.print("Введіть ім`я тарифу(String):");
                name = input.nextLine();
                System.out.print("Введіть кількість клієнтів(Int):");
                clients = input.nextInt();
                System.out.print("Введіть абонтплату(Double):");
                payroll = input.nextDouble();
                System.out.print("Введіть кількість хвилин (int):");
                minutes = input.nextInt();
                System.out.print("Введіть ціну додаткових хвилин(Double):");
                addMinPrice = input.nextDouble();
                System.out.print("Введіть кількість SMS: ");
                numofSMS = input.nextInt();
                System.out.print("Введіть ціну додаткових SMS: ");
                addSMSPrice = input.nextDouble();
                TarufList.AddTarufMobSMS(name,clients,payroll,minutes,addMinPrice,numofSMS,addSMSPrice);
        }catch(Exception e){
            System.out.print("Введені некоректні дані \n");
        }
    }
    }

