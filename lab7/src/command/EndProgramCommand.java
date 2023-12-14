package command;
import java.util.*;

public class EndProgramCommand implements Command{
    public void execute(){
        System.exit(0);
    }
}
