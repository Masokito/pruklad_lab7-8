package command;

import tarufList.TarufList;

public class LoadFromFile implements Command{
    public void execute(){
        TarufList.loadTarufsFromXmlFile();
    }
}
