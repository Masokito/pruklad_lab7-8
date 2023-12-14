package command;

import tarufList.TarufList;

import java.util.Scanner;
import logger.LOGGER;
import java.util.logging.*;

public class AddTarufMobSMS implements Command {
    public static Logger logger = LOGGER.LOGGER;

    public void execute(){
        logger.info("AddtarufMobSMS Command executed");
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
            logger.warning("Incorrect data input");

            System.out.print("Введені некоректні дані \n");
        }
    }
    }

