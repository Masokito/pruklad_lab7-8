package command;

import tarufList.TarufList;

import java.util.Scanner;

public class AddTarufMobSMSMMSInet implements Command {
    public void execute(){
        String name;
        int clients;
        double payroll;
        int minutes;
        double addMinPrice;
        int numofSMS;double addSMSPrice;
        int numofMMS;double addMMSPrice;
        int numofInetMegs; int inetSpeedInMegs; double addMegsPrice;
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
            System.out.print("Введіть кількість MMS: ");
            numofMMS = input.nextInt();
            System.out.print("Введіть ціну додаткових MMS: ");
            addMMSPrice = input.nextDouble();
            System.out.print("Введіть кількість мегабайт: ");
            numofInetMegs = input.nextInt();
            System.out.print("Введіть швидкість інтернету: ");
            inetSpeedInMegs = input.nextInt();
            System.out.print("Введіть ціну додаткових мегабайт:");
            addMegsPrice = input.nextDouble();


            TarufList.AddTarufMobSMSMMSInet(name,clients,payroll,minutes,addMinPrice,numofSMS,addSMSPrice,numofMMS,addMMSPrice,numofInetMegs,inetSpeedInMegs,addMegsPrice);
        }catch(Exception e){
            System.out.print("Введені некоректні дані \n");
        }
    }
}
