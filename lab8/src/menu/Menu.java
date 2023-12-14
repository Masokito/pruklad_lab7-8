package menu;



import command.*;
import java.util.*;


import java.util.logging.*;
import logger.LOGGER;

public class Menu {

    static  Logger logger = LOGGER.LOGGER;



    static Set<String> getMenuKeys(Map<String, Command> hashmap) {
        logger.info("getMenuKeys executed");
        return hashmap.keySet();
    }
    static void printMenu(Set<String> menuKeys){
        logger.info("printMenu executed");
        int count = 0;
        System.out.print("\n");
        for(String str:menuKeys){
            System.out.println(count + ")" + str);
            count++;
        }
    }

    static void  startCommand(Map<String,Command> menuItems, Set<String> keys){
        logger.info("startCommand executed");
        int num;
        try {
        Scanner input = new Scanner(System.in);
        System.out.print("\nВведіть номер команди:");
        num = input.nextInt();
        if ((num >= 0) && (num < (keys.size()))){
            ArrayList<String> keysList = new ArrayList<String>(keys);
            Command command = menuItems.get((keysList.get(num)));
            logger.info("Starting command execution");
            command.execute();
            }
        } catch (InputMismatchException  e) {
            logger.warning("someone typed not a number in startCommand");
            System.out.println("Not a number \n-------------------------\n");
        }
    }


    public static void createStartMenu(){
        logger.info("CreateStartMenu Executed");
        logger.info("Putting items in menu items");
        Map<String, Command> menuItems = new LinkedHashMap<>();
        menuItems.put("Закрити програму", new EndProgramCommand());
        menuItems.put("Завантажити тарифи в файл", new SaveInFile());
        menuItems.put("Завантажити тарифи з файлу", new LoadFromFile());
        menuItems.put("Додати тариф типу  `тільки мобільний зв`язок", new AddTarufMob());
        menuItems.put("Додати тариф типу  `мобільний зв'язок і SMS", new AddTarufMobSMS());
        menuItems.put("Додати тариф типу  `мобільний зв'язок SMS і MMS", new AddTarufMobSMSMMS());
        menuItems.put("Додати тариф типу  `мобільний зв'язок SMS MMS і інтернет", new AddTarufMobSMSMMSInet());
        //menuItems.put("Створити новий тариф", new startMenuCommand());
        menuItems.put("Підрахувати клієнтів", new CountClientsCommand());
        menuItems.put("Відсортувати тарифи на основі абонплати", new SortTarufByPayroll());
        menuItems.put("Знайти тариф з заданим діапазоном ціни абонплати", new FindTarufInPayrollRange());
        menuItems.put("Змінити абонплату тарифу", new ChangeTarufPayroll());
        menuItems.put("Видалити тариф",new DeleteTaruf());
        menuItems.put("Переглянути тарифи",new ViewTarufs());



        Set<String> menuKeys = new HashSet<String>();
        menuKeys = getMenuKeys(menuItems);
        while(true){
        printMenu(menuKeys);
        startCommand(menuItems, menuKeys);
        }
    }
}
