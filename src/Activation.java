
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Activation implements IHandler{
    private Object synchedList;

    @Override
    public void Handle(IObject object) {
        synchedList = Collections.synchronizedList(new LinkedList());
        try {
            synchronized (synchedList) {            
            synchedList.wait(3000);
            object.setValue("activ", "active");
            }
        } catch (Exception ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
