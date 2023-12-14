package command;

import tarufList.TarufList;

public class SortTarufByPayroll implements Command{
    public void execute(){
        TarufList.printSortedByPayroll();
    }
}
