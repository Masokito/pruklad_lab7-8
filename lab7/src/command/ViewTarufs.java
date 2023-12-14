package command;


import tarufList.TarufList;

public class ViewTarufs implements Command{
    public void execute(){
        TarufList.printAllTarufs();
    }
}
