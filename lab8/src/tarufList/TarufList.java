package tarufList;
import java.io.*;
import java.util.*;
import taruf.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.*;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.io.StreamException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.*;
import logger.LOGGER;

public class TarufList {
    static Logger logger = LOGGER.LOGGER;
    public static List<Mob_taruf> tarufs = new ArrayList<Mob_taruf>();


    public static void AddTarufMob(String name,int clients,double payroll,int minutes,double addMinutesPrice){
        logger.info("AddtarufMob mwthod executed");

        Mob_taruf taruf = new Mob_taruf(name,clients,payroll,minutes,addMinutesPrice);
        tarufs.add(taruf);
    }
    public static void AddTarufMobSMS(String name,int clients,double payroll,int minutes,double addMinutesPrice,int numofSMS,double addSMSPrice){
        logger.info("AddTarufMobSMS method executed");

        Mob_taruf taruf = new Mob_sms_taruf(name,clients,payroll,minutes,addMinutesPrice,numofSMS,addSMSPrice);
        tarufs.add(taruf);
    }
    public static void AddTarufMobSMSMMS(String name,int clients,double payroll,int minutes,double addMinutesPrice,int numofSMS,double addSMSPrice,int numofMMS,double addMMSPrice){
        logger.info("AddTarufMobSMSMMS method executed");

        Mob_taruf taruf = new Mob_sms_mms_taruf(name,clients,payroll,minutes,addMinutesPrice,numofSMS,addSMSPrice,numofMMS,addMMSPrice);
        tarufs.add(taruf);
    }
    public static void AddTarufMobSMSMMSInet(String name,int clients,double payroll,int minutes,double addMinutesPrice,int numofSMS,double addSMSPrice,int numofMMS,double addMMSPrice,int numofInetMegs,int inetMegsPerSecSpeed,double addInetPrice){
        logger.info("AddTarufMobSMSMMSInet method executed");

        Mob_taruf taruf = new Mob_sms_mms_inet_taruf(name,clients,payroll,minutes,addMinutesPrice,numofSMS,addSMSPrice,numofMMS,addMMSPrice,numofInetMegs,inetMegsPerSecSpeed,addInetPrice);
        tarufs.add(taruf);
    }
    static void printTaruf(Mob_taruf taruf){
        System.out.print(taruf.toString());
    }
    public static void printTarufs(List<Mob_taruf> tarufs){
        logger.info("printTarufs method executed");

        for(Mob_taruf taruf: tarufs){
            System.out.print(taruf.toString());
        }
    }

    public static void printAllTarufs(){
        logger.info("printAllTarufs method executed");

        printTarufs(tarufs);
    }

    public static int measureAllClients(){
        logger.info("measureCleints method executed");

        int clients = 0;
        for(Mob_taruf taruf: tarufs){
            clients += taruf.getClients();
        }
        return  clients;
    }
    public static void printAllClients(){

        logger.info("printAllClients method executed");
        System.out.print("Загальна кількість клієнтів: " + measureAllClients());
    }


    public static List<Mob_taruf> sortbyPayroll(List<Mob_taruf> tarufs){
        logger.info("sortbyPayroll method executed");

        tarufs.sort(Comparator.comparing(Mob_taruf::getPayroll));
        return tarufs;
    }

    public static void printSortedByPayroll(){
        logger.info("printSortedByPayroll method executed");

        if (tarufs.size() == 0){System.out.print("Список тарифів пустий \n");}
        else {
            List<Mob_taruf> taruf = sortbyPayroll(tarufs);
            printTarufs(taruf);
        }
    }

    public static void saveTarufsToXmlFile(){
        logger.info("saveTarufsToXmlFile method executed");

        XStream xstream = new XStream();
        String dataXml = xstream.toXML(tarufs);
        System.out.print(dataXml);
        try {
            FileWriter file = new FileWriter("./tarufs.xml");
            file.write(dataXml);
            file.close();
        } catch (IOException e) {
            logger.warning("Error while writing to file" + e.getMessage());

            System.out.println("Помилка при записі в файл: " + e.getMessage());
        }
    }


    public static void setPayrollByName(String name,double payroll){
        logger.info("setPayrollByName method executed");

        for(Mob_taruf taruf : tarufs){
            if (taruf.getName() == name){
                taruf.setPayroll(payroll);
            }
        }
    }
    public static String finderinPayrollRange(double minPayroll,double maxPayroll){
        logger.info("finderinPayrollRange method executed");

        for(Mob_taruf taruf : tarufs){
            if (taruf.getPayroll() >= minPayroll && taruf.getPayroll() <= maxPayroll)
                return taruf.toString();
        }
        return "";
    }
    public static void findTarufInPayrollRange(double minPayroll,double maxPayroll){
        logger.info("findTarufInPayrollRange method executed");
        System.out.println(finderinPayrollRange(minPayroll,maxPayroll));
    }

    public static void loadTarufsFromXmlFile(){
        logger.info("loadTarufsFromXmlFile method executed");

        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        String tarufsXml;
        try {
        Path file = Path.of("./tarufs.xml");
        tarufsXml = Files.readString(file);
        tarufs = (List<Mob_taruf>) xstream.fromXML(tarufsXml);}catch (IOException e){
            logger.warning("Error while loading from file " + e.getMessage());
            System.out.print("Помилка при відкриті файлу");
        }

    }




    public static void deleteTaruf(String name){
        logger.info("deleteTaruf method executed");
        tarufs.removeIf(el -> name.equals(el.getName()));
    }

    /**public static void deleteTaruf(String name){
        for (Mob_taruf taruf: tarufs){
            if(name.equals((taruf.getName()))){
                tarufs.remove(taruf);
            }
        }
    }*/


}
