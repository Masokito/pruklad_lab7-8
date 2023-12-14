package command;
import tarufList.*;

public class CountClientsCommand implements Command {
    public void execute(){
        TarufList.printAllClients();
    }
}
