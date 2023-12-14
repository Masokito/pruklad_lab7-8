package command;
import java.util.Scanner;
import tarufList.TarufList;

public class DeleteTaruf implements Command{
    public void execute() {
        String name;
        System.out.print("Введіть назву тарифу: ");
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        TarufList.deleteTaruf(name);
    }
}
