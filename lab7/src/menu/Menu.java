package menu;

import command.*;
import java.util.*;


public class Menu {
    //final int CLOSECONSOLECODE=-1;
    //final int KEEPCONSOLECODE=0;
    //int ConsoleCode =KEEPCONSOLECODE;
    static Set<String> getMenuKeys(Map<String, Command> hashmap) {
        return hashmap.keySet();
    }
    static void printMenu(Set<String> menuKeys){
        int count = 0;
        System.out.print("\n");
        for(String str:menuKeys){
            System.out.println(count + ")" + str);
            count++;
        }
    }

    static void  startCommand(Map<String,Command> menuItems, Set<String> keys){
        int num;
        try {
        Scanner input = new Scanner(System.in);
        System.out.print("\nВведіть номер команди:");
        num = input.nextInt();
        if ((num >= 0) && (num < (keys.size()))){
            ArrayList<String> keysList = new ArrayList<String>(keys);
            Command command = menuItems.get((keysList.get(num)));
            command.execute();
            }
        } catch (InputMismatchException  e) {
            System.out.println("Not a number \n-------------------------\n");
        }
    }



    public static void createStartMenu(){
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
            //if
        printMenu(menuKeys);
        startCommand(menuItems, menuKeys);

        }
    }
}
