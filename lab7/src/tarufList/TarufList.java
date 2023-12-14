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

public class TarufList {
    public static List<Mob_taruf> tarufs = new ArrayList<Mob_taruf>();


    public static void AddTarufMob(String name,int clients,double payroll,int minutes,double addMinutesPrice){
        Mob_taruf taruf = new Mob_taruf(name,clients,payroll,minutes,addMinutesPrice);
        tarufs.add(taruf);
    }
    public static void AddTarufMobSMS(String name,int clients,double payroll,int minutes,double addMinutesPrice,int numofSMS,double addSMSPrice){
        Mob_taruf taruf = new Mob_sms_taruf(name,clients,payroll,minutes,addMinutesPrice,numofSMS,addSMSPrice);
        tarufs.add(taruf);
    }
    public static void AddTarufMobSMSMMS(String name,int clients,double payroll,int minutes,double addMinutesPrice,int numofSMS,double addSMSPrice,int numofMMS,double addMMSPrice){
        Mob_taruf taruf = new Mob_sms_mms_taruf(name,clients,payroll,minutes,addMinutesPrice,numofSMS,addSMSPrice,numofMMS,addMMSPrice);
        tarufs.add(taruf);
    }
    public static void AddTarufMobSMSMMSInet(String name,int clients,double payroll,int minutes,double addMinutesPrice,int numofSMS,double addSMSPrice,int numofMMS,double addMMSPrice,int numofInetMegs,int inetMegsPerSecSpeed,double addInetPrice){
        Mob_taruf taruf = new Mob_sms_mms_inet_taruf(name,clients,payroll,minutes,addMinutesPrice,numofSMS,addSMSPrice,numofMMS,addMMSPrice,numofInetMegs,inetMegsPerSecSpeed,addInetPrice);
        tarufs.add(taruf);
    }
    static void printTaruf(Mob_taruf taruf){
        System.out.print(taruf.toString());
    }
    public static void printTarufs(List<Mob_taruf> tarufs){
        for(Mob_taruf taruf: tarufs){
            System.out.print(taruf.toString());
        }
    }

    public static void printAllTarufs(){
        printTarufs(tarufs);
    }

    public static int measureAllClients(){
        int clients = 0;
        for(Mob_taruf taruf: tarufs){
            clients += taruf.getClients();
        }
        return  clients;
    }
    public static void printAllClients(){
        System.out.print("Загальна кількість клієнтів: " + measureAllClients());
    }


    public static List<Mob_taruf> sortbyPayroll(List<Mob_taruf> tarufs){
        tarufs.sort(Comparator.comparing(Mob_taruf::getPayroll));
        return tarufs;
    }

    public static void printSortedByPayroll(){
        if (tarufs.size() == 0){System.out.print("Список тарифів пустий \n");}
        else {
            List<Mob_taruf> taruf = sortbyPayroll(tarufs);
            printTarufs(taruf);
        }
    }

    public static void saveTarufsToXmlFile(){
        XStream xstream = new XStream();
        String dataXml = xstream.toXML(tarufs);
        System.out.print(dataXml);
        try {
            FileWriter file = new FileWriter("./tarufs.xml");
            file.write(dataXml);
            file.close();
        } catch (IOException e) {
            System.out.println("Помилка при записі в файл: " + e.getMessage());
        }
    }


    public static void setPayrollByName(String name,double payroll){
        for(Mob_taruf taruf : tarufs){
            if (taruf.getName() == name){
                taruf.setPayroll(payroll);
            }
        }
    }

    public static String finderinPayrollRange(double minPayroll,double maxPayroll){
        for(Mob_taruf taruf : tarufs){
            if (taruf.getPayroll() >= minPayroll && taruf.getPayroll() <= maxPayroll)
                return taruf.toString();
        }
        return "";
    }
    public static void findTarufInPayrollRange(double minPayroll,double maxPayroll){
        System.out.println(finderinPayrollRange(minPayroll,maxPayroll));
    }


    public static void loadTarufsFromXmlFile(){
        XStream xstream = new XStream();
        xstream.addPermission(AnyTypePermission.ANY);
        String tarufsXml;
        try {
        Path file = Path.of("./tarufs.xml");
        tarufsXml = Files.readString(file);
        tarufs = (List<Mob_taruf>) xstream.fromXML(tarufsXml);}catch (IOException e){
            System.out.print("Помилка при відкриті файлу");
        }

    }




    public static void deleteTaruf(String name){
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
