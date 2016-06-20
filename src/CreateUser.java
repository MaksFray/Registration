
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CreateUser implements IHandler{
        
    public void create(List <IObject> ob)
    {
        try (FileWriter fileWriter = new FileWriter("1.txt",false)) {
        for(IObject o : ob){
            fileWriter.write("{\"username\": \""+o.getValue("username")+"\", \"pass\": \""+o.getValue("pass")+
                    "\", \"email\": \""+o.getValue("email")+"\", \"activ\": \""+o.getValue("activ")+"\", \"role\": \""+o.getValue("role")+"\"}");
        }
            fileWriter.flush();
        } catch (IOException ex) {
        }
    }
    
    @Override
    public void Handle(IObject object) {
        Reader r = new Reader();
        List <IObject> ob=new ArrayList<IObject>();   
        boolean b = true;
        try {
            ob = r.check();

            for(int i =0;i<ob.size();i++)
            {
                if(b==ob.get(i).getValue("username").equals(object.getValue("username")))
                {
                    ob.remove(ob.get(i));
                }
            } 

            ob.add(object);
            } catch (Exception ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            create(ob);

        
    }
    
}
