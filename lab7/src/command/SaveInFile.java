package command;

import tarufList.TarufList;

public class SaveInFile implements Command{
    public  void execute(){
        TarufList.saveTarufsToXmlFile();
    }
}
