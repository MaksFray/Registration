
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) throws Exception {
        IObject obj = new FObject();
        obj.setValue("username", "frey");
        obj.setValue("pass", "name1234"); 
        obj.setValue("passagain", "name1234");
        obj.setValue("email", "namoa@net.piu");
        
        IHandler[] handlers = {new Validation(), new FromBase(), new Role(), new CreateUser()};
        IHandler handler = new MacroHandler(handlers);
        handler.Handle(obj);
       
        
        IHandler[] hands = {new Activation(), new CreateUser()};
        
        IHandler hand = new MacroHandler(hands);
        hand.Handle(obj);

    }
    
}
