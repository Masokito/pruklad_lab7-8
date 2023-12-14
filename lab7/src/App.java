import command.*;



public class App{
    public static void main(String[] args){

        Command start = new StartMenuCommand();
        start.execute();
    }
}