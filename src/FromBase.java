
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FromBase implements IHandler{
 
    public List<IObject> check()
    {
        List <IObject> ob =null;
        Reader r = new Reader();
        try {
            ob=r.check();
        } catch (IOException ex) {
            Logger.getLogger(FromBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ob;
    }
    
    @Override
    public void Handle(IObject object) throws Exception {
        List <IObject> ob=check();
        boolean b=false;
        for(IObject o: ob)
        {
              
            b=!o.getValue("username").equals(object.getValue("username")) && !o.getValue("email").equals(object.getValue("email"));
            if(!b)
            {
                throw new Exception(); 
            }
            
        }
        
        
    }
    
}
