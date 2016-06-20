
import java.util.logging.Level;
import java.util.logging.Logger;


public class Role implements IHandler{

    @Override
    public void Handle(IObject object) {
        try{
        object.setValue("role", "user");
        object.setValue("activ", "not");
        }
        catch(Exception ex)
        {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
